package com.es.getpet.prototipo;

import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.enuns.Especie;
import com.es.getpet.core.enuns.Sexo;
import com.es.getpet.core.enuns.Tamanho;
import com.es.getpet.core.enuns.Temperamento;
import com.es.getpet.core.enuns.Unidade;
import com.es.getpet.core.rn.AnimalRN;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.DefaultComboBoxModel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.filechooser.FileFilter;

public final class AnimalDialog extends JDialog {

	private static final long serialVersionUID = 1207665357976955407L;
	private Animal animal;
    private AnimalRN animalRN;
    private final Frame parent;
    private boolean ok;
    private boolean editavel;
    private byte[] byteArrayImagem;
    private JFileChooser fc;

    public AnimalDialog(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        carregaCombos();
        ok = false;
        this.parent = parent;
        fc = new JFileChooser();
        fc.addChoosableFileFilter(new ImageFilter());
        fc.setAcceptAllFileFilterUsed(false);
        fc.setAccessory(new PreviewImagem(fc));
        setLocationRelativeTo(parent);
    }

    public AnimalDialog(java.awt.Frame parent) {
        this(parent, true);
    }

    public AnimalDialog(java.awt.Frame parent, AnimalRN animalRN) {
        this(parent, animalRN, null, true);
    }

    public AnimalDialog(java.awt.Frame parent, Animal animal, boolean editavel) {
        this(parent, null, animal, editavel);
    }

    public AnimalDialog(java.awt.Frame parent, AnimalRN animalRN, Animal animal, boolean editavel) {
        this(parent, true);
        this.editavel = editavel;
        this.animalRN = animalRN;
        if (animal != null) {
            this.animal = animal;
            carregaAtributosAnimal();
        }
    }

    public boolean isOk() {
        return ok;
    }

    public Animal getAnimal() {
        return animal;
    }

    private void carregaAtributosAnimal() {
        atualizaCampos();
        if (animal.getFoto() != null) {
            byteArrayImagem = animal.getFoto();
            try {
                labelFoto.setIcon(getIconDoByteArray(byteArrayImagem));
            } catch (IOException e) {
                animal.setFoto(null);
                byteArrayImagem = null;
            }
        }
        atualizaForm();
    }

    private void atualizaCampos() {
        textFieldNome.setText(animal.getNome());
        spinnerIdade.getModel().setValue(animal.getIdade());
        comboBoxUnidade.setSelectedItem(animal.getUnidade());
        comboBoxEspecie.setSelectedItem(animal.getEspecie());
        comboBoxSexo.setSelectedItem(animal.getSexo());
        textFieldRaca.setText(animal.getRaca());
        comboBoxTamanho.setSelectedItem(animal.getTamanho());
        comboBoxTemperamento.setSelectedItem(animal.getTemperamento());
        checkBoxCastrado.setSelected(animal.getCastrado());
        textFieldDoencasLimitacoes.setText(animal.getDoencasLimitacoes());
        textAreaObservacoes.setText(animal.getObs());
    }

    private void atualizaForm() {
        textFieldNome.setEditable(editavel);
        ((JSpinner.DefaultEditor) spinnerIdade.getEditor()).getTextField().setEditable(editavel);
        ((SpinnerNumberModel) spinnerIdade.getModel()).setStepSize(editavel ? 1 : 0);
        textFieldRaca.setEditable(editavel);
        checkBoxCastrado.setEnabled(editavel);
        buttonFoto.setEnabled(editavel);
        textFieldDoencasLimitacoes.setEditable(editavel);
        textAreaObservacoes.setEditable(editavel);
        buttonSalvar.setVisible(!editavel);
        buttonCancelar.setText(editavel ? "Fechar" : "Cancelar");
    }

    private void preencheAtributosAnimal() {
        animal.setNome(textFieldNome.getText());
        animal.setIdade(new Short(spinnerIdade.getValue().toString()));
        animal.setUnidade(comboBoxUnidade.getSelectedItem() != null ? (Unidade) comboBoxUnidade.getSelectedItem() : null);
        animal.setEspecie(comboBoxEspecie.getSelectedItem() != null ? (Especie) comboBoxEspecie.getSelectedItem() : null);
        animal.setSexo(comboBoxSexo.getSelectedItem() != null ? (Sexo) comboBoxSexo.getSelectedItem() : null);
        animal.setRaca(textFieldRaca.getText());
        animal.setTamanho(comboBoxTamanho.getSelectedItem() != null ? (Tamanho) comboBoxTamanho.getSelectedItem() : null);
        animal.setCastrado(checkBoxCastrado.isSelected());
        animal.setDoencasLimitacoes(textFieldDoencasLimitacoes.getText());
        animal.setObs(textAreaObservacoes.getText());
        animal.setFoto(byteArrayImagem);
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	private void carregaCombos() {
        comboBoxUnidade.setModel(new javax.swing.DefaultComboBoxModel(Unidade.values()));
        comboBoxUnidade.setSelectedIndex(-1);

        comboBoxEspecie.setModel(new DefaultComboBoxModel(Especie.values()));
        comboBoxEspecie.setSelectedIndex(-1);

        comboBoxSexo.setModel(new DefaultComboBoxModel(Sexo.values()));
        comboBoxSexo.setSelectedIndex(-1);

        comboBoxTamanho.setModel(new DefaultComboBoxModel(Tamanho.values()));
        comboBoxTamanho.setSelectedIndex(-1);

        comboBoxTemperamento.setModel(new DefaultComboBoxModel(Temperamento.values()));
        comboBoxTemperamento.setSelectedIndex(-1);
    }


    private byte[] getByteArrayDoArquivo(File arquivo) throws IOException {
        BufferedImage originalImage = ImageIO.read(arquivo);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(originalImage, "jpg", baos );
        return baos.toByteArray();
    }

    private Icon getIconDoByteArray(byte[] byteArray) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(new ByteArrayInputStream(byteArray));
        int altura;
        int largura;
        int h = bufferedImage.getHeight();
        int w = bufferedImage.getWidth();
        if (h > w) {
            altura = labelFoto.getHeight();
            largura = labelFoto.getWidth() * w / h;
        } else {
            altura = labelFoto.getHeight() * h / w;
            largura = labelFoto.getWidth();
        }
        Image imagem = bufferedImage.getScaledInstance(largura, altura, Image.SCALE_SMOOTH);
        return new ImageIcon(imagem);
    }

    private static String getExtension(File arquivo) {
        String extensao = null;
        String s = arquivo.getName();
        int i = s.lastIndexOf('.');
        if (i > 0 && i < s.length() - 1) {
            extensao = s.substring(i + 1).toLowerCase();
        }
        return extensao;
    }

    private void initComponents() {

        textFieldNome = new javax.swing.JTextField();
        labelNome = new javax.swing.JLabel();
        spinnerIdade = new javax.swing.JSpinner();
        labelIdade = new javax.swing.JLabel();
        comboBoxUnidade = new javax.swing.JComboBox<>();
        comboBoxEspecie = new javax.swing.JComboBox<>();
        labelEspecie = new javax.swing.JLabel();
        comboBoxSexo = new javax.swing.JComboBox<>();
        labelSexo = new javax.swing.JLabel();
        textFieldRaca = new javax.swing.JTextField();
        labelRaca = new javax.swing.JLabel();
        comboBoxTamanho = new javax.swing.JComboBox<>();
        labelTamanho = new javax.swing.JLabel();
        checkBoxCastrado = new javax.swing.JCheckBox();
        textFieldDoencasLimitacoes = new javax.swing.JTextField();
        labelDoencasLimitacoes = new javax.swing.JLabel();
        scrollPaneTextAreaObservacoes = new javax.swing.JScrollPane();
        textAreaObservacoes = new javax.swing.JTextArea();
        labelObs = new javax.swing.JLabel();
        buttonSalvar = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        labelUnidade = new javax.swing.JLabel();
        labelTemperamento = new javax.swing.JLabel();
        comboBoxTemperamento = new javax.swing.JComboBox<>();
        labelFoto = new javax.swing.JLabel();
        buttonFoto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GetPet - Cadastro de Animais");
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        labelNome.setText("Nome:");

        spinnerIdade.setModel(new javax.swing.SpinnerNumberModel(1, 1, 30, 1));

        labelIdade.setText("Idade:");

        comboBoxUnidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxUnidadeActionPerformed(evt);
            }
        });

        comboBoxEspecie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxUnidadeActionPerformed(evt);
            }
        });

        labelEspecie.setText("Espécie:");

        comboBoxSexo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxUnidadeActionPerformed(evt);
            }
        });

        labelSexo.setText("Sexo:");

        labelRaca.setText("Raça:");

        comboBoxTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxUnidadeActionPerformed(evt);
            }
        });

        labelTamanho.setText("Tamanho:");

        checkBoxCastrado.setText("Castrado");

        labelDoencasLimitacoes.setText("Doenças/Limitações:");

        textAreaObservacoes.setColumns(20);
        textAreaObservacoes.setRows(5);
        scrollPaneTextAreaObservacoes.setViewportView(textAreaObservacoes);

        labelObs.setText("Observações:");

        buttonSalvar.setText("Salvar");
        buttonSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSalvarActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        labelUnidade.setText("Unidade:");

        labelTemperamento.setText("Temperamento:");

        comboBoxTemperamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxUnidadeActionPerformed(evt);
            }
        });

        labelFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelFoto.setMaximumSize(new java.awt.Dimension(256, 256));
        labelFoto.setMinimumSize(new java.awt.Dimension(256, 256));
        labelFoto.setPreferredSize(new java.awt.Dimension(256, 256));

        buttonFoto.setText("Foto");
        buttonFoto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonFotoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneTextAreaObservacoes, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(textFieldDoencasLimitacoes)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelObs)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(textFieldRaca, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(spinnerIdade, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(labelIdade))
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(labelUnidade)
                                                .addComponent(comboBoxUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addComponent(labelNome)
                                    .addComponent(labelRaca))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelEspecie)
                                            .addComponent(comboBoxEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(comboBoxTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(comboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(labelSexo)
                                            .addComponent(checkBoxCastrado, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addComponent(labelTamanho, javax.swing.GroupLayout.Alignment.LEADING)))
                            .addComponent(labelDoencasLimitacoes)
                            .addComponent(labelTemperamento)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(comboBoxTemperamento, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(buttonFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(textFieldNome))
                        .addGap(18, 18, 18)
                        .addComponent(labelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, 291, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(labelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelIdade)
                            .addComponent(labelEspecie)
                            .addComponent(labelSexo)
                            .addComponent(labelUnidade))
                        .addGap(3, 3, 3)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerIdade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxUnidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxEspecie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelRaca)
                            .addComponent(labelTamanho))
                        .addGap(5, 5, 5)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldRaca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboBoxTamanho, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxCastrado))
                        .addGap(18, 18, 18)
                        .addComponent(labelTemperamento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboBoxTemperamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(buttonFoto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelDoencasLimitacoes))
                    .addComponent(labelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldDoencasLimitacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(24, 24, 24)
                .addComponent(labelObs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneTextAreaObservacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonSalvar)
                    .addComponent(buttonCancelar))
                .addContainerGap())
        );

        pack();
    }

    private void buttonSalvarActionPerformed(java.awt.event.ActionEvent evt) {
        if (animal == null) {
            animal = new Animal();
        }
        try {
            preencheAtributosAnimal();
            if (animalRN != null) {
                animalRN.validaSalva(animal);
            }
            ok = true;
            dispose();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(parent, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        if (!ok) {
            animal = null;
        }
    }

    private void buttonFotoActionPerformed(java.awt.event.ActionEvent evt) {
        if (fc.showDialog(parent, "Abrir") == JFileChooser.APPROVE_OPTION) {
            try {
                byteArrayImagem = getByteArrayDoArquivo(fc.getSelectedFile());
                labelFoto.setIcon(getIconDoByteArray(byteArrayImagem));
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this, "Erro ao carregar imagem!\n" + e.getMessage() , "", JOptionPane.ERROR_MESSAGE);
            }
        }
    }

    private void comboBoxUnidadeActionPerformed(java.awt.event.ActionEvent evt) {
        if (!editavel && animal != null) {
            atualizaCampos();
        }
    }

    private class ImageFilter extends FileFilter {

        @Override
        public boolean accept(File f) {
            boolean result = f.isDirectory();
            if (!result) {
                String extension = getExtension(f);
                if (extension != null) {
                    result = extension.equalsIgnoreCase("tiff")
                            || extension.equalsIgnoreCase("tif")
                            || extension.equalsIgnoreCase("gif")
                            || extension.equalsIgnoreCase("jpg")
                            || extension.equalsIgnoreCase("jpeg")
                            || extension.equalsIgnoreCase("png");
                }
            }
            return result;
        }

        @Override
        public String getDescription() {
            return "Apenas imagens";
        }

    }

    private final class PreviewImagem extends JComponent implements PropertyChangeListener {

		private static final long serialVersionUID = -1698449083669964164L;
		private ImageIcon miniatura;
        private File arquivo;

        public PreviewImagem(JFileChooser fc) {
            setPreferredSize(new Dimension(100, 50));
            fc.addPropertyChangeListener(getListener());
        }

        public final PreviewImagem getListener() {
            return this;
        }

        public void carregaImagem() {
            if (arquivo == null) {
                miniatura = null;
                return;
            }
            ImageIcon icone = new ImageIcon(arquivo.getPath());
            if (icone.getIconWidth() > 90) {
                miniatura = new ImageIcon(icone.getImage().getScaledInstance(90, -1, Image.SCALE_DEFAULT));
            } else {
                miniatura = icone;
            }
        }

        @Override
        public void propertyChange(PropertyChangeEvent e) {
            boolean mudou = false;
            String propriedade = e.getPropertyName();
            if (JFileChooser.DIRECTORY_CHANGED_PROPERTY.equals(propriedade)) {
                arquivo = null;
                mudou = true;
            } else if (JFileChooser.SELECTED_FILE_CHANGED_PROPERTY.equals(propriedade)) {
                arquivo = (File) e.getNewValue();
                mudou = true;
            }
            if (mudou) {
                miniatura = null;
                if (isShowing()) {
                    carregaImagem();
                    repaint();
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (miniatura == null) {
                carregaImagem();
            }
            if (miniatura != null) {
                int x = getWidth() / 2 - miniatura.getIconWidth() / 2;
                int y = getHeight() / 2 - miniatura.getIconHeight() / 2;
                if (y < 0) {
                    y = 0;
                }
                if (x < 5) {
                    x = 5;
                }
                miniatura.paintIcon(this, g, x, y);
            }
        }
    }

    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonFoto;
    private javax.swing.JButton buttonSalvar;
    private javax.swing.JCheckBox checkBoxCastrado;
    private javax.swing.JComboBox<String> comboBoxEspecie;
    private javax.swing.JComboBox<String> comboBoxSexo;
    private javax.swing.JComboBox<String> comboBoxTamanho;
    private javax.swing.JComboBox<String> comboBoxTemperamento;
    private javax.swing.JComboBox<String> comboBoxUnidade;
    private javax.swing.JLabel labelDoencasLimitacoes;
    private javax.swing.JLabel labelEspecie;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel labelIdade;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelObs;
    private javax.swing.JLabel labelRaca;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JLabel labelTamanho;
    private javax.swing.JLabel labelTemperamento;
    private javax.swing.JLabel labelUnidade;
    private javax.swing.JScrollPane scrollPaneTextAreaObservacoes;
    private javax.swing.JSpinner spinnerIdade;
    private javax.swing.JTextArea textAreaObservacoes;
    private javax.swing.JTextField textFieldDoencasLimitacoes;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldRaca;

}
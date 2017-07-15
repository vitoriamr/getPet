package com.es.getpet.prototipo;

import java.awt.Frame;
import java.io.IOException;

import com.es.getpet.core.ed.Animal;

public final class AdotarDialog extends javax.swing.JDialog {

	private static final long serialVersionUID = 1L;
	private Animal animal;

    public AdotarDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(parent);
    }

    public AdotarDialog(Frame parent, Animal animal) {
        this(parent, true);
        this.animal = animal;
        atualizaFormulario();
    }

    private void atualizaFormulario() {
        labelNomeAnimal.setText(animal.getNome());
        labelSexoAnimal.setText(animal.getSexo() == null ? "Desconhecido" : animal.getSexo().toString());
        labelIdadeAnimal.setText(animal.getIdade() == null || animal.getUnidade() == null ? "Desconhecida" : animal.getIdade() + " " + animal.getUnidade().toString());
        labelRacaAnimal.setText(animal.getRaca() == null ? "Desconhecida" : animal.getRaca());
        labelCastradoAnimal.setText(animal.getCastrado() == null ? "Desconhecido" : animal.getCastrado() ? "Sim" : "Não");
        labelTamanhoAnimal.setText(animal.getTamanho() == null ? "Desconhecido" : animal.getTamanho().toString());
        labelTemperamentoAnimal.setText(animal.getTemperamento() == null ? "Desconhecido" : animal.getTemperamento().toString());
        textAreaObs.setText(animal.getObs());
        if (animal.getFoto() != null) {
            try {
                labelFoto.setIcon(AnimalDialog.getIconDoByteArray(animal.getFoto(), labelFoto));
            } catch (IOException e) {
            }
        }
    }

    private void initComponents() {

        buttonCandiataAdocao = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        labelFoto = new javax.swing.JLabel();
        labelNome = new javax.swing.JLabel();
        labelNomeAnimal = new javax.swing.JLabel();
        labelRaca = new javax.swing.JLabel();
        labelIdade = new javax.swing.JLabel();
        labelTamanho = new javax.swing.JLabel();
        labelTratamento = new javax.swing.JLabel();
        labelCastrado = new javax.swing.JLabel();
        labelSexo = new javax.swing.JLabel();
        scrollPane = new javax.swing.JScrollPane();
        textAreaObs = new javax.swing.JTextArea();
        labelSexoAnimal = new javax.swing.JLabel();
        labelRacaAnimal = new javax.swing.JLabel();
        labelIdadeAnimal = new javax.swing.JLabel();
        labelTamanhoAnimal = new javax.swing.JLabel();
        labelTemperamentoAnimal = new javax.swing.JLabel();
        labelCastradoAnimal = new javax.swing.JLabel();
        checkBoxTermoResponsabilidade = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Candidatar-se para adoção");

        buttonCandiataAdocao.setText("Sou candidato para Adoção");
        buttonCandiataAdocao.setEnabled(false);

        buttonCancelar.setText("Cancelar");

        labelFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelFoto.setMaximumSize(new java.awt.Dimension(256, 256));
        labelFoto.setMinimumSize(new java.awt.Dimension(256, 256));
        labelFoto.setPreferredSize(new java.awt.Dimension(256, 256));

        labelNome.setText("Nome:");

        labelNomeAnimal.setForeground(new java.awt.Color(0, 0, 255));
        labelNomeAnimal.setText("jLabel2");

        labelRaca.setText("Raça:");

        labelIdade.setText("Idade:");

        labelTamanho.setText("Tamanho:");

        labelTratamento.setText("Temperamento:");

        labelCastrado.setText("Castrado:");

        labelSexo.setText("Sexo:");

        textAreaObs.setEditable(false);
        textAreaObs.setColumns(20);
        textAreaObs.setRows(5);
        scrollPane.setViewportView(textAreaObs);

        labelSexoAnimal.setForeground(new java.awt.Color(0, 0, 255));

        labelRacaAnimal.setForeground(new java.awt.Color(0, 0, 255));
        labelRacaAnimal.setText("jLabel2");

        labelIdadeAnimal.setForeground(new java.awt.Color(0, 0, 255));
        labelIdadeAnimal.setText("jLabel2");

        labelTamanhoAnimal.setForeground(new java.awt.Color(0, 0, 255));
        labelTamanhoAnimal.setText("jLabel2");

        labelTemperamentoAnimal.setForeground(new java.awt.Color(0, 0, 255));
        labelTemperamentoAnimal.setText("jLabel2");

        labelCastradoAnimal.setForeground(new java.awt.Color(0, 0, 255));
        labelCastradoAnimal.setText("jLabel2");

        checkBoxTermoResponsabilidade.setText("Assumo a responsabilidade legal pelo animal.");
        checkBoxTermoResponsabilidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                checkBoxTermoResponsabilidadeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(checkBoxTermoResponsabilidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCancelar))
                    .addComponent(scrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelNomeAnimal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelSexo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelSexoAnimal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelRaca)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelRacaAnimal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelIdade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelIdadeAnimal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelCastrado)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelCastradoAnimal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelTamanho)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelTamanhoAnimal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(labelTratamento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelTemperamentoAnimal)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(labelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonCandiataAdocao, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(15, 15, 15))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelFoto, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonCandiataAdocao, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelNome)
                            .addComponent(labelNomeAnimal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelSexo)
                            .addComponent(labelSexoAnimal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelRaca)
                            .addComponent(labelRacaAnimal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelIdade)
                            .addComponent(labelIdadeAnimal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTamanho)
                            .addComponent(labelTamanhoAnimal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTratamento)
                            .addComponent(labelTemperamentoAnimal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelCastrado)
                            .addComponent(labelCastradoAnimal))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(scrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(buttonCancelar)
                            .addComponent(checkBoxTermoResponsabilidade))))
                .addGap(14, 14, 14))
        );

        pack();
    }

    private void checkBoxTermoResponsabilidadeActionPerformed(java.awt.event.ActionEvent evt) {
        buttonCandiataAdocao.setEnabled(checkBoxTermoResponsabilidade.isSelected());
    }

    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonCandiataAdocao;
    private javax.swing.JCheckBox checkBoxTermoResponsabilidade;
    private javax.swing.JLabel labelCastrado;
    private javax.swing.JLabel labelCastradoAnimal;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel labelIdade;
    private javax.swing.JLabel labelIdadeAnimal;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNomeAnimal;
    private javax.swing.JLabel labelRaca;
    private javax.swing.JLabel labelRacaAnimal;
    private javax.swing.JLabel labelSexo;
    private javax.swing.JLabel labelSexoAnimal;
    private javax.swing.JLabel labelTamanho;
    private javax.swing.JLabel labelTamanhoAnimal;
    private javax.swing.JLabel labelTemperamentoAnimal;
    private javax.swing.JLabel labelTratamento;
    private javax.swing.JScrollPane scrollPane;
    private javax.swing.JTextArea textAreaObs;
}
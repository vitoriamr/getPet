package com.es.getpet.prototipo;

import com.es.getpet.core.ed.Adotante;
import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.ed.Cuidador;
import com.es.getpet.core.ed.Pessoa;
import com.es.getpet.core.rn.AdotanteRN;
import com.es.getpet.core.rn.AnimalRN;
import com.es.getpet.core.rn.CuidadorRN;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;

public final class CadastroDialog extends javax.swing.JDialog {

    private static final long serialVersionUID = 1L;
    private CuidadorRN cuidadorRN;
    private AdotanteRN adotanteRN;
    private AnimalRN animalRN;
    private Cuidador cuidador;
    private Adotante adotante;
    private ButtonGroup grupo;
    private List<Animal> listaAnimais;
    private Frame parent;
    private boolean ok;

    public CadastroDialog(Frame parent, boolean modal) {
        super(parent, modal);
        this.parent = parent;
        initComponents();
        grupo = new ButtonGroup();
        grupo.add(radioButtonAdotante);
        grupo.add(radioButtonCuidador);
        radioButtonCuidador.setSelected(true);
        radioButtonCuidadorActionPerformed(null);
        listaAnimais = new ArrayList<>();
        atualizaTabelaListaAnimais();
        ok = false;
        setLocationRelativeTo(parent);
    }

    public CadastroDialog(Frame parent, AdotanteRN adotanteRN, CuidadorRN cuidadorRN, AnimalRN animalRN) {
        this(parent, true);
        this.cuidadorRN = cuidadorRN;
        this.adotanteRN = adotanteRN;
        this.animalRN = animalRN;
    }

    private void preencheAtributosCuidador() {
        preencheAtributosPessoa(cuidador);
        cuidador.setCnpj(formattedTextFieldCnpj.getText() != null && !formattedTextFieldCnpj.getText().isEmpty() ? new Long(formattedTextFieldCnpj.getText()) : null);
        cuidador.setListaAnimais(listaAnimais);
    }

    private void preencheAtributosAdotante() {
        preencheAtributosPessoa(adotante);
        adotante.setJaAdotou(checkBoxJaAdotou.isSelected());
        adotante.setQteAnimais((Integer) spinnerQteAnimais.getModel().getValue());
    }

    private void preencheAtributosPessoa(Pessoa pessoa) {
        pessoa.setNome(textFieldNome.getText());
        pessoa.setEndereco(textFieldEndereco.getText());
        pessoa.setEmail(textFieldEmail.getText());
        pessoa.setCpf(formattedTextFieldCpf.getText() != null && !formattedTextFieldCpf.getText().isEmpty() ? new Long(formattedTextFieldCpf.getText()) : null);
        pessoa.setTelefone(textFieldTelefone.getText());
        pessoa.setObs(textAreaObs.getText());
        pessoa.setLoginName(textFieldLoginName.getText());
        pessoa.setSenha(new String(passwordFieldSenha.getPassword()));
    }

    private void atualizaFormulario(boolean modoCuidador) {
        labelCnpj.setVisible(modoCuidador);
        formattedTextFieldCnpj.setVisible(modoCuidador);
        checkBoxJaAdotou.setVisible(!modoCuidador);
        labelQteAnimais.setVisible(!modoCuidador);
        spinnerQteAnimais.setVisible(!modoCuidador);
        tabbedPane.setTitleAt(0, modoCuidador ? "Cuidador" : "Adotante");
        if (modoCuidador) {
            if (tabbedPane.getTabCount() < 2) {
                tabbedPane.addTab("Animais", panelAnimais);
            }
        } else {
            if (tabbedPane.getTabCount() > 1) {
                tabbedPane.remove(1);
            }
        }
    }

    private void atualizaTabelaListaAnimais() {
        ModeloTabela<Animal> modelo = new AnimaisModeloTabela(listaAnimais);
        tableListaAnimais.setModel(modelo);
    }

    public boolean isOk() {
        return ok;
    }

    public Cuidador getCuidador() {
        return cuidador;
    }

    public Adotante getAdotante() {
        return adotante;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tabbedPane = new javax.swing.JTabbedPane();
        panelPessoa = new javax.swing.JPanel();
        labelObs = new javax.swing.JLabel();
        labelCnpj = new javax.swing.JLabel();
        formattedTextFieldCnpj = new javax.swing.JFormattedTextField();
        checkBoxJaAdotou = new javax.swing.JCheckBox();
        labelQteAnimais = new javax.swing.JLabel();
        spinnerQteAnimais = new javax.swing.JSpinner();
        labelNome = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        labelNomeUsuario = new javax.swing.JLabel();
        textFieldEndereco = new javax.swing.JTextField();
        textFieldLoginName = new javax.swing.JTextField();
        labelEndereco = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        passwordFieldSenha = new javax.swing.JPasswordField();
        labelCPF = new javax.swing.JLabel();
        textFieldEmail = new javax.swing.JTextField();
        formattedTextFieldCpf = new javax.swing.JFormattedTextField();
        labelTelefone = new javax.swing.JLabel();
        textFieldTelefone = new javax.swing.JTextField();
        scrollPanePessoa = new javax.swing.JScrollPane();
        textAreaObs = new javax.swing.JTextArea();
        panelAnimais = new javax.swing.JPanel();
        buttonCadastrarAnimal = new javax.swing.JButton();
        buttonRemoverAnimal = new javax.swing.JButton();
        scrollPaneAnimais = new javax.swing.JScrollPane();
        tableListaAnimais = new javax.swing.JTable();
        buttonCancelar = new javax.swing.JButton();
        buttonOk = new javax.swing.JButton();
        radioButtonCuidador = new javax.swing.JRadioButton();
        radioButtonAdotante = new javax.swing.JRadioButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setResizable(false);

        labelObs.setText("Obs:");

        labelCnpj.setText("CNPJ:");

        checkBoxJaAdotou.setText("Já adotou?");

        labelQteAnimais.setText("Quantos animais possui:");

        spinnerQteAnimais.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        labelNome.setText("Nome:");

        labelNomeUsuario.setText("Nome de Usuário:");

        labelEndereco.setText("Endereço:");

        labelSenha.setText("Senha:");

        labelEmail.setText("Email:");

        labelCPF.setText("CPF:");

        labelTelefone.setText("Telefone:");

        textAreaObs.setColumns(20);
        textAreaObs.setRows(5);
        scrollPanePessoa.setViewportView(textAreaObs);

        javax.swing.GroupLayout panelPessoaLayout = new javax.swing.GroupLayout(panelPessoa);
        panelPessoa.setLayout(panelPessoaLayout);
        panelPessoaLayout.setHorizontalGroup(
            panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPessoaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPessoaLayout.createSequentialGroup()
                        .addComponent(labelEmail)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelCPF)
                        .addGap(197, 197, 197))
                    .addGroup(panelPessoaLayout.createSequentialGroup()
                        .addComponent(labelObs)
                        .addGap(493, 493, 493))
                    .addGroup(panelPessoaLayout.createSequentialGroup()
                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textFieldNome)
                            .addComponent(textFieldEndereco)
                            .addGroup(panelPessoaLayout.createSequentialGroup()
                                .addComponent(textFieldEmail)
                                .addGap(18, 18, 18)
                                .addComponent(formattedTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(panelPessoaLayout.createSequentialGroup()
                                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNome)
                                    .addComponent(labelEndereco)
                                    .addComponent(labelTelefone)
                                    .addComponent(labelCnpj)
                                    .addComponent(formattedTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(panelPessoaLayout.createSequentialGroup()
                                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(panelPessoaLayout.createSequentialGroup()
                                                .addComponent(labelNomeUsuario)
                                                .addGap(0, 49, Short.MAX_VALUE))
                                            .addComponent(textFieldLoginName))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(labelSenha)
                                            .addComponent(passwordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPessoaLayout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(checkBoxJaAdotou)
                                        .addGap(18, 18, 18)
                                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(labelQteAnimais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(spinnerQteAnimais, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addComponent(scrollPanePessoa))
                        .addContainerGap())))
        );
        panelPessoaLayout.setVerticalGroup(
            panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelPessoaLayout.createSequentialGroup()
                .addComponent(labelNome)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(labelEndereco)
                .addGap(4, 4, 4)
                .addComponent(textFieldEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelEmail)
                    .addComponent(labelCPF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(formattedTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPessoaLayout.createSequentialGroup()
                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelTelefone)
                            .addComponent(labelNomeUsuario))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(textFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(panelPessoaLayout.createSequentialGroup()
                            .addComponent(labelSenha)
                            .addGap(30, 30, 30))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPessoaLayout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(passwordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(textFieldLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(18, 18, 18)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelPessoaLayout.createSequentialGroup()
                        .addComponent(labelQteAnimais)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(spinnerQteAnimais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxJaAdotou))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(panelPessoaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(labelCnpj)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(formattedTextFieldCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(labelObs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPanePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Pessoa", panelPessoa);

        buttonCadastrarAnimal.setText("Cadastrar Animal");
        buttonCadastrarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarAnimalActionPerformed(evt);
            }
        });

        buttonRemoverAnimal.setText("Remover Animal");
        buttonRemoverAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRemoverAnimalActionPerformed(evt);
            }
        });

        scrollPaneAnimais.setViewportView(tableListaAnimais);

        javax.swing.GroupLayout panelAnimaisLayout = new javax.swing.GroupLayout(panelAnimais);
        panelAnimais.setLayout(panelAnimaisLayout);
        panelAnimaisLayout.setHorizontalGroup(
            panelAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAnimaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scrollPaneAnimais, javax.swing.GroupLayout.DEFAULT_SIZE, 561, Short.MAX_VALUE)
                    .addGroup(panelAnimaisLayout.createSequentialGroup()
                        .addComponent(buttonCadastrarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonRemoverAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        panelAnimaisLayout.setVerticalGroup(
            panelAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAnimaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(panelAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCadastrarAnimal)
                    .addComponent(buttonRemoverAnimal))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrollPaneAnimais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tabbedPane.addTab("Animais", panelAnimais);

        buttonCancelar.setText("Cancelar");
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonOk.setText("Ok");
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOkActionPerformed(evt);
            }
        });

        radioButtonCuidador.setText("Quero ser um cuidador");
        radioButtonCuidador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonCuidadorActionPerformed(evt);
            }
        });

        radioButtonAdotante.setText("Quero ser um adotante");
        radioButtonAdotante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radioButtonCuidadorActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tabbedPane)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(radioButtonAdotante)
                    .addComponent(radioButtonCuidador))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(radioButtonCuidador)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(radioButtonAdotante)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 515, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
        try {
            if (radioButtonCuidador.isSelected()) {
                cuidador = new Cuidador();
                preencheAtributosCuidador();
                cuidador = cuidadorRN.salva(cuidador);
            } else {
                adotante = new Adotante();
                preencheAtributosAdotante();
                adotanteRN.salva(adotante);
            }
            ok = true;
            dispose();
        } catch (IllegalArgumentException e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_buttonOkActionPerformed

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dispose();
    }//GEN-LAST:event_buttonCancelarActionPerformed

    private void radioButtonCuidadorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radioButtonCuidadorActionPerformed
        atualizaFormulario(radioButtonCuidador.isSelected());
    }//GEN-LAST:event_radioButtonCuidadorActionPerformed

    private void buttonCadastrarAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarAnimalActionPerformed
        AnimalDialog dlg = new AnimalDialog(parent, animalRN);
        dlg.setVisible(true);
        if (dlg.getAnimal() != null) {
            listaAnimais.add(dlg.getAnimal());
        }
        atualizaTabelaListaAnimais();
    }//GEN-LAST:event_buttonCadastrarAnimalActionPerformed

    private void buttonRemoverAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRemoverAnimalActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_buttonRemoverAnimalActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonCadastrarAnimal;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonOk;
    private javax.swing.JButton buttonRemoverAnimal;
    private javax.swing.JCheckBox checkBoxJaAdotou;
    private javax.swing.JFormattedTextField formattedTextFieldCnpj;
    private javax.swing.JFormattedTextField formattedTextFieldCpf;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelCnpj;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelNomeUsuario;
    private javax.swing.JLabel labelObs;
    private javax.swing.JLabel labelQteAnimais;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JPanel panelAnimais;
    private javax.swing.JPanel panelPessoa;
    private javax.swing.JPasswordField passwordFieldSenha;
    private javax.swing.JRadioButton radioButtonAdotante;
    private javax.swing.JRadioButton radioButtonCuidador;
    private javax.swing.JScrollPane scrollPaneAnimais;
    private javax.swing.JScrollPane scrollPanePessoa;
    private javax.swing.JSpinner spinnerQteAnimais;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tableListaAnimais;
    private javax.swing.JTextArea textAreaObs;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldEndereco;
    private javax.swing.JTextField textFieldLoginName;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldTelefone;
    // End of variables declaration//GEN-END:variables
}

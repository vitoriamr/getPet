package com.es.getpet.prototipo;

import com.es.getpet.core.ed.Adocao;
import com.es.getpet.core.ed.Adotante;
import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.ed.Cuidador;
import com.es.getpet.core.enuns.Sexo;
import com.es.getpet.core.enuns.StatusAdocao;
import com.es.getpet.core.rn.AdocaoRN;
import java.awt.Frame;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

public final class DlgAdocao extends javax.swing.JDialog {

    private AdocaoRN adocaoRN;
    private Cuidador cuidador;
    private AdocoesModeloTabela adocoesModeloTabela;

    public DlgAdocao(Frame parent, boolean modal) {
        super(parent, modal);
        adocaoRN = new AdocaoRN();
        initComponents();
        setLocationRelativeTo(parent);
    }

    public DlgAdocao(Frame parent, Cuidador cuidador) {
        this(parent, true);
        this.cuidador = cuidador;
        atualizaTabela();
        atualizaTela();
    }

    private void atualizaTela() {
        if (tableAdocao.getSelectedRow() > -1 && adocoesModeloTabela != null) {
            Adocao adocao = adocoesModeloTabela.get(tableAdocao.getSelectedRow());
            Adotante adotante = adocao.getAdotante();
            textFieldNome.setText(adotante.getNome());
            textFieldEndereco.setText(adotante.getEndereco());
            textFieldEmail.setText(adotante.getEmail());
            formattedTextFieldCpf.setText(adotante.getCpf() == null ? "" : adotante.getCpf().toString());
            textFieldTelefone.setText(adotante.getTelefone());
            checkBoxJaAdotou.setSelected(adotante.getJaAdotou());
            if (adotante.getQteAnimais() != null) {
                spinnerQteAnimais.setValue(adotante.getQteAnimais());
            }
            if (adocao.getAnimal().getFoto() != null) {
                try {
                    labelFoto.setIcon(AnimalDialog.getIconDoByteArray(adocao.getAnimal().getFoto(), labelFoto));
                } catch (IOException e) {
                }
            }
        }
    }

    private void atualizaTabela() {
        List<Adocao> lista = adocaoRN.listaPorCuidador(cuidador);
        adocoesModeloTabela = new AdocoesModeloTabela(lista);
        tableAdocao.setModel(adocoesModeloTabela);
        if (!lista.isEmpty()) {
            tableAdocao.getSelectionModel().setSelectionInterval(0, 0);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tableAdocao = new javax.swing.JTable();
        panelPessoa = new javax.swing.JPanel();
        labelObs = new javax.swing.JLabel();
        checkBoxJaAdotou = new javax.swing.JCheckBox();
        labelQteAnimais = new javax.swing.JLabel();
        spinnerQteAnimais = new javax.swing.JSpinner();
        labelNome = new javax.swing.JLabel();
        textFieldNome = new javax.swing.JTextField();
        textFieldEndereco = new javax.swing.JTextField();
        labelEndereco = new javax.swing.JLabel();
        labelEmail = new javax.swing.JLabel();
        labelCPF = new javax.swing.JLabel();
        textFieldEmail = new javax.swing.JTextField();
        formattedTextFieldCpf = new javax.swing.JFormattedTextField();
        labelTelefone = new javax.swing.JLabel();
        textFieldTelefone = new javax.swing.JTextField();
        scrollPanePessoa = new javax.swing.JScrollPane();
        textAreaObs = new javax.swing.JTextArea();
        buttonAprovar = new javax.swing.JButton();
        buttonRejeitar = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        labelFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Confirmar Adoção");

        tableAdocao.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                tableAdocaoPropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(tableAdocao);

        labelObs.setText("Obs:");

        checkBoxJaAdotou.setText("Já adotou?");

        labelQteAnimais.setText("Quantos animais possui:");

        spinnerQteAnimais.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        labelNome.setText("Nome:");

        labelEndereco.setText("Endereço:");

        labelEmail.setText("Email:");

        labelCPF.setText("CPF:");

        labelTelefone.setText("Telefone:");

        textAreaObs.setColumns(20);
        textAreaObs.setRows(5);
        scrollPanePessoa.setViewportView(textAreaObs);

        buttonAprovar.setText("Aprovar");
        buttonAprovar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAprovarActionPerformed(evt);
            }
        });

        buttonRejeitar.setText("Rejeitar");
        buttonRejeitar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonRejeitarActionPerformed(evt);
            }
        });

        buttonSair.setText("Sair");
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

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
                                    .addComponent(textFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addComponent(checkBoxJaAdotou)
                                .addGap(18, 18, 18)
                                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelQteAnimais, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(spinnerQteAnimais, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(scrollPanePessoa))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelPessoaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonRejeitar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(buttonAprovar)
                .addContainerGap())
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
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(panelPessoaLayout.createSequentialGroup()
                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(formattedTextFieldCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textFieldTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkBoxJaAdotou)))
                    .addGroup(panelPessoaLayout.createSequentialGroup()
                        .addComponent(labelQteAnimais)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(spinnerQteAnimais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addComponent(labelObs)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(scrollPanePessoa, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelPessoaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonAprovar)
                    .addComponent(buttonRejeitar)
                    .addComponent(buttonSair))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        labelFoto.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        labelFoto.setMaximumSize(new java.awt.Dimension(256, 256));
        labelFoto.setMinimumSize(new java.awt.Dimension(256, 256));
        labelFoto.setPreferredSize(new java.awt.Dimension(256, 256));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(panelPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(labelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(90, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(panelPessoa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(labelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tableAdocaoPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_tableAdocaoPropertyChange
        atualizaTela();
    }//GEN-LAST:event_tableAdocaoPropertyChange

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonSairActionPerformed
        dispose();
    }//GEN-LAST:event_buttonSairActionPerformed

    private void buttonAprovarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonAprovarActionPerformed
        if (tableAdocao.getSelectedRow() > -1 && adocoesModeloTabela != null) {
            Adocao adocao = adocoesModeloTabela.get(tableAdocao.getSelectedRow());
            Animal animal = adocao.getAnimal();
            if (adocaoRN.confirmaAdocao(adocao)) {
                String artigo = animal.getSexo() != null ? animal.getSexo() == Sexo.FEMEA ? "A ": "O " : "";
                JOptionPane.showMessageDialog(this,  artigo  + animal.getNome() +
                        "agora tem um novo Lar!\nObrigado por dar essa oportunidade a um amigo de 4 patas.", "Comfirmado", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }
    }//GEN-LAST:event_buttonAprovarActionPerformed

    private void buttonRejeitarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonRejeitarActionPerformed
        if (tableAdocao.getSelectedRow() > -1 && adocoesModeloTabela != null) {
            Adocao adocao = adocoesModeloTabela.get(tableAdocao.getSelectedRow());
            Animal animal = adocao.getAnimal();
            if (adocaoRN.rejeitaAdocao(adocao)) {
                JOptionPane.showMessageDialog(this,  "O processo de Adoção foi rejeitado pelo Cuidador.", "Rejeitada", JOptionPane.INFORMATION_MESSAGE);
                dispose();
            }
        }

    }//GEN-LAST:event_buttonRejeitarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonAprovar;
    private javax.swing.JButton buttonRejeitar;
    private javax.swing.JButton buttonSair;
    private javax.swing.JCheckBox checkBoxJaAdotou;
    private javax.swing.JFormattedTextField formattedTextFieldCpf;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCPF;
    private javax.swing.JLabel labelEmail;
    private javax.swing.JLabel labelEndereco;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel labelNome;
    private javax.swing.JLabel labelObs;
    private javax.swing.JLabel labelQteAnimais;
    private javax.swing.JLabel labelTelefone;
    private javax.swing.JPanel panelPessoa;
    private javax.swing.JScrollPane scrollPanePessoa;
    private javax.swing.JSpinner spinnerQteAnimais;
    private javax.swing.JTable tableAdocao;
    private javax.swing.JTextArea textAreaObs;
    private javax.swing.JTextField textFieldEmail;
    private javax.swing.JTextField textFieldEndereco;
    private javax.swing.JTextField textFieldNome;
    private javax.swing.JTextField textFieldTelefone;
    // End of variables declaration//GEN-END:variables
}
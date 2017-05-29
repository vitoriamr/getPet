package com.es.getpet.prototipo;

import com.es.getpet.core.ed.Adotante;
import com.es.getpet.core.ed.Cuidador;
import com.es.getpet.core.rn.AdotanteRN;
import com.es.getpet.core.rn.AnimalRN;
import com.es.getpet.core.rn.CuidadorRN;
import java.awt.Frame;
import java.util.List;
import javax.swing.JOptionPane;

public final class LogarDialog extends javax.swing.JDialog {

	private static final long serialVersionUID = -5537378468924874482L;
	private final Frame parent;
    private AdotanteRN adotanteRN;
    private CuidadorRN cuidadorRN;
    private AnimalRN animalRN;
    private Cuidador cuidador;
    private Adotante adotante;
    private boolean ok;

    public LogarDialog(Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        this.parent = parent;
        ok = false;
        setLocationRelativeTo(parent);
    }

    public LogarDialog(Frame parent, AdotanteRN adotanteRN, CuidadorRN cuidadorRN, AnimalRN animalRN) {
        this(parent, true);
        this.adotanteRN = adotanteRN;
        this.cuidadorRN = cuidadorRN;
        this.animalRN = animalRN;
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

    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        textFieldLoginName = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        buttonOk = new javax.swing.JButton();
        buttonCancelar = new javax.swing.JButton();
        buttonCadastrar = new javax.swing.JButton();
        passwordFieldSenha = new javax.swing.JPasswordField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("GetPet - Identifique-se por favor");
        setResizable(false);

        jLabel1.setText("Nome de Usuário:");

        textFieldLoginName.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        textFieldLoginName.setForeground(java.awt.Color.blue);

        jLabel2.setText("Senha:");

        buttonOk.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pata2.gif"))); // NOI18N
        buttonOk.setText("OK");
        buttonOk.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonOk.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonOkActionPerformed(evt);
            }
        });

        buttonCancelar.setText("Cancelar");
        buttonCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarActionPerformed(evt);
            }
        });

        buttonCadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/cadastrar.gif"))); // NOI18N
        buttonCadastrar.setText("Cadastrar-se");
        buttonCadastrar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        buttonCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarActionPerformed(evt);
            }
        });

        passwordFieldSenha.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        passwordFieldSenha.setForeground(java.awt.Color.blue);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(passwordFieldSenha)
                    .addComponent(textFieldLoginName)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonOk, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textFieldLoginName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(passwordFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(buttonCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(buttonCadastrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonOk, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }

    private void buttonOkActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonOkActionPerformed
        Cuidador c = new Cuidador();
        c.setLoginName(textFieldLoginName.getText());
        c.setSenha(new String(passwordFieldSenha.getPassword()));
        List<Cuidador> listaCuidador = cuidadorRN.lista(c, null);

        Adotante a = new Adotante();
        a.setLoginName(textFieldLoginName.getText());
        a.setSenha(new String(passwordFieldSenha.getPassword()));
        List<Adotante> listaAdotante = adotanteRN.lista(a, null);

        cuidador = listaCuidador.isEmpty() ? null : listaCuidador.get(0);
        adotante = listaAdotante.isEmpty() ? null : listaAdotante.get(0);

        ok = adotante != null || cuidador != null;
        if (!ok) {
            JOptionPane.showMessageDialog(parent, "Usuário ou senha não encontrado!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
        dispose();
    }

    private void buttonCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarActionPerformed
        CadastroDialog dlg = new CadastroDialog(parent, adotanteRN, cuidadorRN, animalRN);
        dlg.setVisible(true);
        if (dlg.isOk()) {
            cuidador = dlg.getCuidador();
            adotante = dlg.getAdotante();
            ok = true;
            dispose();
        }
    }

    private void buttonCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarActionPerformed
        dispose();
    }

    private javax.swing.JButton buttonCadastrar;
    private javax.swing.JButton buttonCancelar;
    private javax.swing.JButton buttonOk;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPasswordField passwordFieldSenha;
    private javax.swing.JTextField textFieldLoginName;

}

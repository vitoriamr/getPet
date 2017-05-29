package com.es.getpet.prototipo;

import com.es.getpet.core.ed.Adotante;
import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.ed.Cuidador;
import com.es.getpet.core.rn.AdotanteRN;
import com.es.getpet.core.rn.AnimalRN;
import com.es.getpet.core.rn.CuidadorRN;
import com.es.getpet.core.util.Ordem;
import com.es.getpet.core.util.PropriedadesLista;
import static java.awt.EventQueue.invokeLater;
import java.util.List;

public final class Principal extends javax.swing.JFrame {

	private static final long serialVersionUID = 6323118339059726197L;
	private final AnimalRN animalRN;
    private final CuidadorRN cuidadorRN;
    private final AdotanteRN adotanteRN;
    private Adotante adotante;
    private Cuidador cuidador;
    private List<Animal> listaAnimais;

    public Principal() {
        initComponents();
        setLocationRelativeTo(null);
        animalRN = new AnimalRN();
        cuidadorRN = new CuidadorRN();
        adotanteRN = new AdotanteRN();
        atualizaTela();
        atualizaTabela();
    }

    public void atualizaTabela() {
        Animal animal = new Animal();
        PropriedadesLista pl = new PropriedadesLista();
        pl.addOrdem(new Ordem("nome"));
        listaAnimais = animalRN.lista(animal, pl);
        ModeloTabela<?> modelo = new AnimaisModeloTabela(listaAnimais);
        tableListaAnimais.setModel(modelo);
    }

    public void atualizaTela() {
        String titulo;
        if (cuidador != null) {
            titulo = "GetPet - CUIDADOR " + cuidador.getNome();
        } else if (adotante != null) {
            titulo = "GetPet - ADOTANTE " + adotante.getNome();
        } else {
            titulo = "GetPet - Protótipo v 1.0.0";
        }
        setTitle(titulo);
    }

    private void initComponents() {

        buttonLogar = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        tableListaAnimais = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("GetPet - Protótipo v 1.0.0");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        buttonLogar.setText("Logar");
        buttonLogar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLogarActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(tableListaAnimais);

        jTabbedPane1.addTab("Lista de Animais", jScrollPane1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(652, 652, 652)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(buttonLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 415, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }

    private void formWindowOpened(java.awt.event.WindowEvent evt) {
        atualizaTabela();
    }

    private void formWindowClosed(java.awt.event.WindowEvent evt) {
        animalRN.finaliza();
    }

    private void buttonLogarActionPerformed(java.awt.event.ActionEvent evt) {
        LogarDialog dlg = new LogarDialog(this, adotanteRN, cuidadorRN, animalRN);
        dlg.setVisible(true);
        if (dlg.isOk()) {
            adotante = dlg.getAdotante();
            cuidador = dlg.getCuidador();
            atualizaTela();
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Principal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        invokeLater(() -> {
            new Principal().setVisible(true);
        });
    }

    private javax.swing.JButton buttonLogar;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable tableListaAnimais;
}

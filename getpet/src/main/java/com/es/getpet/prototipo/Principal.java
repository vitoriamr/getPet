package com.es.getpet.prototipo;

import com.es.getpet.core.ed.Adotante;
import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.ed.Cuidador;
import com.es.getpet.core.rn.AdotanteRN;
import com.es.getpet.core.rn.AnimalRN;
import com.es.getpet.core.rn.CuidadorRN;
import com.es.getpet.core.util.Ordem;
import com.es.getpet.core.util.PropriedadesLista;
import java.awt.Color;
import static java.awt.EventQueue.invokeLater;
import java.util.List;

public final class Principal extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
    private final AnimalRN animalRN;
    private final CuidadorRN cuidadorRN;
    private final AdotanteRN adotanteRN;
    private Adotante adotante;
    private Cuidador cuidador;
    private List<Animal> listaAnimais;
    private ModeloTabela<Animal> modeloTabela;
    private static final String ROTULO_BOTAO_ADOTAR = "ADOTAR !!!";

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
        modeloTabela = new AnimaisModeloTabela(listaAnimais);
        tableListaAnimais.setModel(modeloTabela);
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
        if (isLogado()) {
            buttonLogar.setText("Desconectar");
            buttonAdotar.setForeground(Color.RED);
            buttonAdotar.setText("<html><b>" + ROTULO_BOTAO_ADOTAR + "</b></html>");
        } else {
            buttonLogar.setText("Logar");
            buttonAdotar.setForeground(Color.GRAY);
            buttonAdotar.setText(ROTULO_BOTAO_ADOTAR);
        }
        buttonAdotar.setEnabled(isLogado());
        setTitle(titulo);
        atualizaTabela();
    }

    private boolean isLogado() {
        return cuidador != null || adotante != null;
    }

    private void initComponents() {

        buttonLogar = new javax.swing.JButton();
        tabbedPaneListaDeAnimais = new javax.swing.JTabbedPane();
        scrollPaneListaDeAnimais = new javax.swing.JScrollPane();
        tableListaAnimais = new javax.swing.JTable();
        buttonVisualizar = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        buttonAdotar = new javax.swing.JButton();

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

        scrollPaneListaDeAnimais.setViewportView(tableListaAnimais);

        tabbedPaneListaDeAnimais.addTab("Lista de Animais", scrollPaneListaDeAnimais);

        buttonVisualizar.setText("Visualizar");
        buttonVisualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonVisualizarActionPerformed(evt);
            }
        });

        buttonSair.setText("Sair");
        buttonSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonSairActionPerformed(evt);
            }
        });

        buttonAdotar.setForeground(new java.awt.Color(255, 0, 0));
        buttonAdotar.setText("ADOTAR !!!");
        buttonAdotar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdotarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabbedPaneListaDeAnimais, javax.swing.GroupLayout.DEFAULT_SIZE, 822, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonAdotar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAdotar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonSair, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(buttonVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonLogar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPaneListaDeAnimais, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        if (isLogado()) {
            adotante = null;
            cuidador = null;
            atualizaTela();
        } else {
            LogarDialog dlg = new LogarDialog(this, adotanteRN, cuidadorRN, animalRN);
            dlg.setVisible(true);
            if (dlg.isOk()) {
                adotante = dlg.getAdotante();
                cuidador = dlg.getCuidador();
                atualizaTela();
            }
        }
    }

    private void buttonVisualizarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tableListaAnimais.getSelectedRow();
        if (linha > -1) {
            AnimalDialog dlg = new AnimalDialog(this, modeloTabela.get(linha), false);
            dlg.setVisible(true);
        }
    }

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void buttonAdotarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tableListaAnimais.getSelectedRow();
        if (linha > -1) {
            AdotarDialog dlg = new AdotarDialog(this, modeloTabela.get(linha));
            dlg.setVisible(true);
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

    private javax.swing.JButton buttonAdotar;
    private javax.swing.JButton buttonLogar;
    private javax.swing.JButton buttonSair;
    private javax.swing.JButton buttonVisualizar;
    private javax.swing.JScrollPane scrollPaneListaDeAnimais;
    private javax.swing.JTabbedPane tabbedPaneListaDeAnimais;
    private javax.swing.JTable tableListaAnimais;
}
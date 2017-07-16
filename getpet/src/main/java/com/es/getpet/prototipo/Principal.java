package com.es.getpet.prototipo;

import com.es.getpet.core.ed.Adotante;
import com.es.getpet.core.ed.Animal;
import com.es.getpet.core.ed.Cuidador;
import com.es.getpet.core.rn.AdotanteRN;
import com.es.getpet.core.rn.AnimalRN;
import com.es.getpet.core.rn.CuidadorRN;
import java.awt.Color;
import static java.awt.EventQueue.invokeLater;
import java.util.List;
import javax.swing.JPanel;

public final class Principal extends javax.swing.JFrame {

	private static final long serialVersionUID = 1L;
	private final AnimalRN animalRN;
    private final CuidadorRN cuidadorRN;
    private final AdotanteRN adotanteRN;
    private Adotante adotante;
    private Cuidador cuidador;
    private List<Animal> listaAnimais;
    private List<Animal> listaMeusAnimais;
    private ModeloTabela<Animal> modeloTabelaListaAnimais;
    private ModeloTabela<Animal> modeloTabelaListaMeusAnimais;
    private static final String ROTULO_BOTAO_ADOTAR = "ADOTAR !!!";
    private JPanel panelTabListaMeusAnimais;

    public Principal() {
        initComponents();
        panelTabListaMeusAnimais = panelListaMeusAnimais;
        setLocationRelativeTo(null);
        animalRN = new AnimalRN();
        cuidadorRN = new CuidadorRN();
        adotanteRN = new AdotanteRN();
        atualizaTela();
        atualizaTabela();
    }

    public void atualizaTabela() {
        if (animalRN != null) {
            listaAnimais = animalRN.getListaAnimaisDisponiveis();
            listaMeusAnimais = animalRN.getListaAnimaisCuidador(cuidador);
            modeloTabelaListaAnimais = new AnimaisModeloTabela(listaAnimais);
            modeloTabelaListaMeusAnimais = new AnimaisModeloTabela(listaMeusAnimais);
            tableListaAnimais.setModel(modeloTabelaListaAnimais);
            tableListaMeusAnimais.setModel(modeloTabelaListaMeusAnimais);
        }
    }

    public void atualizaTela() {
        String titulo;
        Color corNormal = buttonLogar.getForeground();
        if (isLogado()) {
            buttonLogar.setText("Desconectar");
            botaoAdotar(adotante != null);
            if (cuidador != null) {
                titulo = "GetPet - CUIDADOR " + cuidador.getNome();
                buttonAdicionarAnimal.setEnabled(true);
                if (tabbedPane.getTabCount() == 1) {
                    tabbedPane.add(panelTabListaMeusAnimais);
                    tabbedPane.setTitleAt(1, "Lista Meus Animais");
                }
            } else {
                titulo = "GetPet - ADOTANTE " + adotante.getNome();
                buttonAdicionarAnimal.setEnabled(false);
                if (tabbedPane.getTabCount() > 1) {
                    tabbedPane.remove(1);
                }
            }
        } else {
            buttonLogar.setText("Logar");
            buttonAdicionarAnimal.setEnabled(false);
            botaoAdotar(false);
            titulo = "GetPet - Protótipo v 1.0.0";
            if (tabbedPane.getTabCount() > 1) {
                tabbedPane.remove(1);
            }
        }
        buttonAdicionarAnimal.setForeground(buttonAdicionarAnimal.isEnabled() ? corNormal : Color.GRAY);
        buttonAdotar.setEnabled(adotante != null && tabbedPane.getSelectedIndex() == 0);
        setTitle(titulo);
    }

    private void botaoAdotar(boolean ativado) {
        if (ativado) {
            buttonAdotar.setForeground(Color.RED);
            buttonAdotar.setText("<html><b>" + ROTULO_BOTAO_ADOTAR + "</b></html>");
        } else {
            buttonAdotar.setForeground(Color.GRAY);
            buttonAdotar.setText(ROTULO_BOTAO_ADOTAR);
        }
    }

    private boolean isLogado() {
        return cuidador != null || adotante != null;
    }

    private void initComponents() {

        buttonLogar = new javax.swing.JButton();
        tabbedPane = new javax.swing.JTabbedPane();
        scrollPaneListaDeAnimais = new javax.swing.JScrollPane();
        tableListaAnimais = new javax.swing.JTable();
        panelListaMeusAnimais = new javax.swing.JPanel();
        scrollPaneListaMeusAnimais = new javax.swing.JScrollPane();
        tableListaMeusAnimais = new javax.swing.JTable();
        buttonVisualizar = new javax.swing.JButton();
        buttonSair = new javax.swing.JButton();
        buttonAdotar = new javax.swing.JButton();
        buttonAdicionarAnimal = new javax.swing.JButton();

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

        tabbedPane.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                tabbedPaneStateChanged(evt);
            }
        });

        scrollPaneListaDeAnimais.setViewportView(tableListaAnimais);

        tabbedPane.addTab("Lista de Animais", scrollPaneListaDeAnimais);

        scrollPaneListaMeusAnimais.setViewportView(tableListaMeusAnimais);

        javax.swing.GroupLayout panelListaMeusAnimaisLayout = new javax.swing.GroupLayout(panelListaMeusAnimais);
        panelListaMeusAnimais.setLayout(panelListaMeusAnimaisLayout);
        panelListaMeusAnimaisLayout.setHorizontalGroup(
            panelListaMeusAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1004, Short.MAX_VALUE)
            .addGroup(panelListaMeusAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelListaMeusAnimaisLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(scrollPaneListaMeusAnimais, javax.swing.GroupLayout.PREFERRED_SIZE, 1004, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        panelListaMeusAnimaisLayout.setVerticalGroup(
            panelListaMeusAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 390, Short.MAX_VALUE)
            .addGroup(panelListaMeusAnimaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(panelListaMeusAnimaisLayout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(scrollPaneListaMeusAnimais, javax.swing.GroupLayout.PREFERRED_SIZE, 390, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        tabbedPane.addTab("Meus Animais", panelListaMeusAnimais);

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

        buttonAdicionarAnimal.setText("Adicionar Animal");
        buttonAdicionarAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAdicionarAnimalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabbedPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(buttonLogar, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(buttonVisualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(buttonAdotar, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(buttonAdicionarAnimal, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(236, 236, 236)
                        .addComponent(buttonSair, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonSair, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
                    .addComponent(buttonLogar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonVisualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAdotar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(buttonAdicionarAnimal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tabbedPane, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                atualizaTabela();
                atualizaTela();
            }
        }
    }

    private void buttonVisualizarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tableListaAnimais.getSelectedRow();
        if (linha > -1) {
            AnimalDialog dlg = new AnimalDialog(this, modeloTabelaListaAnimais.get(linha), false);
            dlg.setVisible(true);
        }
    }

    private void buttonSairActionPerformed(java.awt.event.ActionEvent evt) {
        dispose();
    }

    private void buttonAdotarActionPerformed(java.awt.event.ActionEvent evt) {
        int linha = tableListaAnimais.getSelectedRow();
        if (linha > -1) {
            AdotarDialog dlg = new AdotarDialog(this, modeloTabelaListaAnimais.get(linha), adotante);
            dlg.setVisible(true);
            atualizaTabela();
        }
    }

    private void buttonAdicionarAnimalActionPerformed(java.awt.event.ActionEvent evt) {
        AnimalDialog dlg = new AnimalDialog(this, animalRN);
        dlg.setVisible(true);
        Animal animal = dlg.getAnimal();
        if (animal != null) {
            animal.setCuidador(cuidador);
            animalRN.salva(animal);
            atualizaTabela();
        }
    }

    private void tabbedPaneStateChanged(javax.swing.event.ChangeEvent evt) {
        atualizaTela();
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

    private javax.swing.JButton buttonAdicionarAnimal;
    private javax.swing.JButton buttonAdotar;
    private javax.swing.JButton buttonLogar;
    private javax.swing.JButton buttonSair;
    private javax.swing.JButton buttonVisualizar;
    private javax.swing.JPanel panelListaMeusAnimais;
    private javax.swing.JScrollPane scrollPaneListaDeAnimais;
    private javax.swing.JScrollPane scrollPaneListaMeusAnimais;
    private javax.swing.JTabbedPane tabbedPane;
    private javax.swing.JTable tableListaAnimais;
    private javax.swing.JTable tableListaMeusAnimais;
}

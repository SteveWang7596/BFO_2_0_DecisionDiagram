/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.uct.cs.views;

import java.io.File;
import javax.swing.JFileChooser;

/**
 *
 * @author SteveW
 */
public class MainFrame extends javax.swing.JFrame {

    private File owl_file;
    private String owl_file_path;
    private String current_entity_name;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        initComponents();
        owl_file = null;
        owl_file_path = "";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        FileChooser = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        lblOwlFile = new javax.swing.JLabel();
        txtOwlFilePath = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        lblEntityName = new javax.swing.JLabel();
        txtEntityName = new javax.swing.JTextField();
        btnEntityName = new javax.swing.JButton();
        spQuestion = new javax.swing.JScrollPane();
        txtAreaQuestion = new javax.swing.JTextArea();
        cbQuestionOptions = new javax.swing.JComboBox<>();
        btnPrevQuestion = new javax.swing.JButton();
        nextQuestion = new javax.swing.JButton();
        btnInsertAxiom = new javax.swing.JButton();
        txtAxiom = new javax.swing.JTextField();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        ImportOWLFile = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblOwlFile.setText("OWL File: ");

        txtOwlFilePath.setEditable(false);
        txtOwlFilePath.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtOwlFilePathActionPerformed(evt);
            }
        });

        lblEntityName.setText("Entity Name:");

        txtEntityName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtEntityNameActionPerformed(evt);
            }
        });

        btnEntityName.setText("Confirm");
        btnEntityName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntityNameActionPerformed(evt);
            }
        });

        txtAreaQuestion.setEditable(false);
        txtAreaQuestion.setColumns(20);
        txtAreaQuestion.setRows(5);
        spQuestion.setViewportView(txtAreaQuestion);

        cbQuestionOptions.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        cbQuestionOptions.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cbQuestionOptionsActionPerformed(evt);
            }
        });

        btnPrevQuestion.setText("< Previous Question");
        btnPrevQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevQuestionActionPerformed(evt);
            }
        });

        nextQuestion.setText("Next Question >");

        btnInsertAxiom.setText("Insert Axiom");

        txtAxiom.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spQuestion)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblEntityName, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEntityName, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnEntityName, javax.swing.GroupLayout.DEFAULT_SIZE, 136, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lblOwlFile, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtOwlFilePath))
                    .addComponent(cbQuestionOptions, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnPrevQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtAxiom))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btnInsertAxiom, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nextQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOwlFile)
                    .addComponent(txtOwlFilePath, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEntityName)
                    .addComponent(txtEntityName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEntityName))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spQuestion, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cbQuestionOptions, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnPrevQuestion)
                    .addComponent(nextQuestion))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnInsertAxiom)
                    .addComponent(txtAxiom, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        FileMenu.setText("File");

        ImportOWLFile.setText("Import");
        ImportOWLFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ImportOWLFileActionPerformed(evt);
            }
        });
        FileMenu.add(ImportOWLFile);

        MenuBar.add(FileMenu);

        jMenu2.setText("Edit");
        MenuBar.add(jMenu2);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImportOWLFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportOWLFileActionPerformed
        JFileChooser fileChooser = FileChooser;
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            owl_file = fileChooser.getSelectedFile();
            owl_file_path = owl_file.getPath();
            txtOwlFilePath.setText(owl_file_path);
            System.out.println("Ontology File: " + owl_file.getName() + ".");
            System.out.println("From path: " + owl_file_path);
        }
        else
        {
            System.out.println("User cancelled owl file selection process.");
        }
    }//GEN-LAST:event_ImportOWLFileActionPerformed

    private void txtOwlFilePathActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtOwlFilePathActionPerformed
        // Unreachable code txtOwlFilePath is uneditable
    }//GEN-LAST:event_txtOwlFilePathActionPerformed

    private void txtEntityNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntityNameActionPerformed
        setCurrentEntityName(txtEntityName.getText());
    }//GEN-LAST:event_txtEntityNameActionPerformed

    private void btnEntityNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntityNameActionPerformed
        setCurrentEntityName(txtEntityName.getText());
    }//GEN-LAST:event_btnEntityNameActionPerformed

    private void cbQuestionOptionsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cbQuestionOptionsActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cbQuestionOptionsActionPerformed

    private void btnPrevQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevQuestionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnPrevQuestionActionPerformed

    private void setCurrentEntityName(String entity_name)
    {
        current_entity_name = entity_name;
        txtEntityName.setEnabled(false);
        System.out.println("Current entity name: " + current_entity_name);
    }
            
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFileChooser FileChooser;
    private javax.swing.JMenu FileMenu;
    private javax.swing.JMenuItem ImportOWLFile;
    private javax.swing.JMenuBar MenuBar;
    private javax.swing.JButton btnEntityName;
    private javax.swing.JButton btnInsertAxiom;
    private javax.swing.JButton btnPrevQuestion;
    private javax.swing.JComboBox<String> cbQuestionOptions;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEntityName;
    private javax.swing.JLabel lblOwlFile;
    private javax.swing.JButton nextQuestion;
    private javax.swing.JScrollPane spQuestion;
    private javax.swing.JTextArea txtAreaQuestion;
    private javax.swing.JTextField txtAxiom;
    private javax.swing.JTextField txtEntityName;
    private javax.swing.JTextField txtOwlFilePath;
    // End of variables declaration//GEN-END:variables
}

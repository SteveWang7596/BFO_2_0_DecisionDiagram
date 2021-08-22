/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.uct.cs.views;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.nio.file.Paths;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;

import za.ac.uct.cs.controllers.Questions;
import za.ac.uct.cs.controllers.OWLHandler;

/**
 *
 * @author SteveW, ChiadikaE
 */
public class MainFrame extends javax.swing.JFrame {

    private String default_owl_file_path;
    private String current_entity_name;
    private Questions question_controller;
    private OWLHandler owl_handler;
    
    /**
     * Creates new form MainFrame
     */
    public MainFrame() {
        this.default_owl_file_path =  "/za/ac/uct/cs/owl/BF0_2_0.owl"; // "C:\\Users\\Eek Ok 0987\\Documents\\Mein__\\BFO_2_0_Decision_Diagram\\src\\main\\resources\\za\\ac\\uct\\cs\\owl\\BF0_2_0.owl"; // "src/main/resources/za/ac/uct/cs/owl/BFO_2_0.owl";
        this.question_controller = new Questions();
        initDecisionProcess();
        initComponents();
        enableSelection(false);
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
        btnNextQuestion = new javax.swing.JButton();
        btnInsertAxiom = new javax.swing.JButton();
        txtAxiom = new javax.swing.JTextField();
        MenuBar = new javax.swing.JMenuBar();
        FileMenu = new javax.swing.JMenu();
        ImportOWLFile = new javax.swing.JMenuItem();
        jMenuEdit = new javax.swing.JMenu();
        jMenuRestart = new javax.swing.JMenuItem();
        jMenuRemoveEntity = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        lblOwlFile.setText("OWL File: ");

        txtOwlFilePath.setEditable(false);

        lblEntityName.setText("Entity Label:");

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

        btnPrevQuestion.setText("< Previous Question");
        btnPrevQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPrevQuestionActionPerformed(evt);
            }
        });

        btnNextQuestion.setText("Next Question >");
        btnNextQuestion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNextQuestionActionPerformed(evt);
            }
        });

        btnInsertAxiom.setText("Insert Axiom");
        btnInsertAxiom.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInsertAxiomActionPerformed(evt);
            }
        });

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
                            .addComponent(btnNextQuestion, javax.swing.GroupLayout.DEFAULT_SIZE, 177, Short.MAX_VALUE))))
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
                    .addComponent(btnNextQuestion))
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

        jMenuEdit.setText("Edit");

        jMenuRestart.setText("Restart");
        jMenuRestart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRestartActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuRestart);

        jMenuRemoveEntity.setText("Change Entity");
        jMenuRemoveEntity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRemoveEntityActionPerformed(evt);
            }
        });
        jMenuEdit.add(jMenuRemoveEntity);

        MenuBar.add(jMenuEdit);

        setJMenuBar(MenuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ImportOWLFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ImportOWLFileActionPerformed
        FileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        int result = FileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File owl_file = FileChooser.getSelectedFile();
            try{
                this.owl_handler = new OWLHandler(owl_file.getPath());
            }
            catch (
                NullPointerException 
                | OWLOntologyCreationException 
                | FileNotFoundException 
                | AssertionError ex
            )
            { return; } /// TODO: add error popup: Could not load owl file...
            txtOwlFilePath.setText(this.owl_handler.filepath());
            System.out.println("Ontology File: " + this.owl_handler.filename());
            System.out.println("From path: " + this.owl_handler.filepath());
        }
        else
        {
            System.out.println("User cancelled owl file selection process.");
        }
    }//GEN-LAST:event_ImportOWLFileActionPerformed

    private void btnEntityNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntityNameActionPerformed
        String text = txtEntityName.getText();
        if (txtEntityName.isEnabled() && !text.equals("")){
            /* Future: 
                give user the option to choose IRI fragment
            */
            this.setCurrentEntityName(text);
            this.resetSelection();
        }
    }//GEN-LAST:event_btnEntityNameActionPerformed

    /** 
     * Triggered when 'previous question button is clicked; this method restores 
     * previous question and axiom text 
     */
    private void btnPrevQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPrevQuestionActionPerformed
        try {
            this.question_controller.goToPreviousQuestion();
            this.resetSelection();
        }
        catch(NullPointerException ex){
            String error_message = ex.getMessage();
            if (error_message != null && error_message.equals("There is no previous question.")){
                btnPrevQuestion.setEnabled(false);
            }
            throw ex;
        }
    }//GEN-LAST:event_btnPrevQuestionActionPerformed

    private void btnInsertAxiomActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInsertAxiomActionPerformed
        this.importAxiomIntoOWLFile();
    }//GEN-LAST:event_btnInsertAxiomActionPerformed

    /**
     * Triggered when 'next question button is clicked; this method processes 
     * the answer selection and adjusts the display accordingly
     */
    private void btnNextQuestionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNextQuestionActionPerformed
        String selected_answer = cbQuestionOptions.getSelectedItem().toString();
        System.out.println("Selected answer: " + selected_answer);
        this.question_controller.processAnswer(selected_answer);
        this.resetSelection();
    }//GEN-LAST:event_btnNextQuestionActionPerformed

    private void jMenuRestartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRestartActionPerformed
        this.initDecisionProcess();
        this.resetSelection();
    }//GEN-LAST:event_jMenuRestartActionPerformed

    private void jMenuRemoveEntityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRemoveEntityActionPerformed
        this.enableSelection(false);
        // clear all questions, selection options and axioms
        txtAreaQuestion.setText("");
        txtAxiom.setText("");
        cbQuestionOptions.removeAllItems();
        txtEntityName.setEnabled(true);
        // reset decision tree
        this.initDecisionProcess();
    }//GEN-LAST:event_jMenuRemoveEntityActionPerformed

    private void txtEntityNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtEntityNameActionPerformed
        // Allows user to type enter instead of having to click button.
        btnEntityNameActionPerformed(evt);
    }//GEN-LAST:event_txtEntityNameActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        if (this.owl_handler == null) { return; }
        if (this.owl_handler.filepath().equals(this.default_owl_file_path)){
            // i.e. we are using the default BFO owl file
            /// TODO: ask user to confirm new location of file, then move owl file. In future, always request confirmation of changes and location.
        }
        this.saveOWLFile();
    }//GEN-LAST:event_formWindowClosing

    private void setCurrentEntityName(String entity_name){
        current_entity_name = entity_name;
        txtEntityName.setEnabled(false);
        System.out.println("Current entity name: " + current_entity_name);
    }
    
    private void enableSelection(boolean enable){
        // enables or disables the form items used for processing questions
        btnPrevQuestion.setEnabled(enable);
        btnNextQuestion.setEnabled(enable);
        btnInsertAxiom.setEnabled(enable);
        cbQuestionOptions.setEnabled(enable);
    }
    
    private void resetSelection(){
        // use current question to fill in question text and answer options
        cbQuestionOptions.removeAllItems();
        txtAreaQuestion.setText(
            this.question_controller.getQuestion().replaceAll(
                "\\[\\]", 
                this.current_entity_name
            )
        );
        String[] options = this.question_controller.getAnswerOptions();
        for (String option: options) { cbQuestionOptions.addItem(option); }
        cbQuestionOptions.setEnabled(true);
        // update axiom and unfreeze axiom import button
        String axiom = String.format(
                "%s \u2291 %s",
                this.current_entity_name,
                this.question_controller.getAxiom()
        );
        txtAxiom.setText(axiom);
        btnInsertAxiom.setEnabled(!axiom.equals(""));
        // freeze/unfreeze next/prev buttons if at root/leaves
        btnPrevQuestion.setEnabled(!this.question_controller.isFirstQuestion());
        btnNextQuestion.setEnabled(!this.question_controller.isFinalQuestion());
    }
    
    private void initDecisionProcess(){
        // reset the decision tree
        this.question_controller.begin();
        if (!this.question_controller.isFirstQuestion()) { 
            throw new AssertionError("Restart should return to the first question."); 
        }
    }
    
    private void importAxiomIntoOWLFile(){
        ///TODO: documentation
        /// TODO: check if owl file selected (prompt or select default?) [if default, make a copy/ask where to save copy]
        if (this.owl_handler == null) {
            try {
                URL bfo_2_0_file = getClass().getResource(this.default_owl_file_path);
                String bfo_2_0_path = Paths.get(bfo_2_0_file.toURI()).toAbsolutePath().toString();
                this.owl_handler = new OWLHandler(bfo_2_0_path);
                /// TODO: update import file text field
            }
            catch (Exception ex){
                /// TODO
            }
        }
        // confirm insert and owl file
        String message = String.format(
            "Are you sure you want to import \"%s\" into %s",
            txtAxiom.getText(),
            this.owl_handler.filename()
        );
        
        int accept_import = JOptionPane.showConfirmDialog(
            this, message, "Confirm Axiom Import", JOptionPane.YES_NO_OPTION
        );
        
        if (accept_import == JOptionPane.YES_OPTION){
            System.out.println("Importing \""+txtAxiom.getText()+"\" into "+this.owl_handler.filename());
            String axiom_superclass = this.question_controller.getAxiom();
            boolean success = this.owl_handler.addClassAxiom(
                this.current_entity_name.toLowerCase(), 
                "SubClassOf", 
                axiom_superclass.toLowerCase()
            );
            if (success){
                /* Future: 
                    save temporary copy and give user option of saving changes 
                    on exit (allow them to change file name/location)
                */
                this.saveOWLFile();
            }
            System.out.println((success)? "success" : "failure");
        }
    }
    
    private void saveOWLFile(){
        if (this.owl_handler == null){ return; }
        // allow 2 retries
        int retry = 0;
        while (retry < 3){
            try {
                this.owl_handler.saveToFile();
                return;
            }
            catch(OWLOntologyStorageException ex){
                ++retry;
            }
        }
        // if it gets here all retries failed
        /// TODO: error popup: unable to save owl file
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
    private javax.swing.JButton btnNextQuestion;
    private javax.swing.JButton btnPrevQuestion;
    private javax.swing.JComboBox<String> cbQuestionOptions;
    private javax.swing.JMenu jMenuEdit;
    private javax.swing.JMenuItem jMenuRemoveEntity;
    private javax.swing.JMenuItem jMenuRestart;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JLabel lblEntityName;
    private javax.swing.JLabel lblOwlFile;
    private javax.swing.JScrollPane spQuestion;
    private javax.swing.JTextArea txtAreaQuestion;
    private javax.swing.JTextField txtAxiom;
    private javax.swing.JTextField txtEntityName;
    private javax.swing.JTextField txtOwlFilePath;
    // End of variables declaration//GEN-END:variables
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.ac.uct.cs.controllers;

import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import za.ac.uct.cs.controllers.OWLHandler;

/**
 *
 * @author SteveW
 */
public class OWLTester {
    public static void main(String[] args) throws OWLOntologyStorageException {
        try {
            OWLHandler owl_handler = new OWLHandler("BF0_2_0.owl");
            String label = "entity";
            System.out.println("IRI of " + label + ": " + owl_handler.getIRIFromLabel(label));
            String parent = "entity";
            String child = "some_entity";
            owl_handler.addSubClassOfAxiom(parent, child);
            owl_handler.saveOntology();
            
        } catch (NullPointerException ex) {
            Logger.getLogger(OWLTester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (OWLOntologyCreationException ex) {
            Logger.getLogger(OWLTester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(OWLTester.class.getName()).log(Level.SEVERE, null, ex);
        } catch (AssertionError ex) {
            Logger.getLogger(OWLTester.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

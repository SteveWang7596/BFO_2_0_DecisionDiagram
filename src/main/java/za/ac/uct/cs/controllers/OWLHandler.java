/// TODO
package za.ac.uct.cs.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;

public class OWLHandler{
    private String filename;
    private String filepath;
    private OWLOntology ontology;
    private OWLDataFactory datafactory;

    public OWLHandler(String filepath) 
    throws NullPointerException, OWLOntologyCreationException, FileNotFoundException, AssertionError 
    {
        /// TODO: documentation
        if (filepath == null) { throw new NullPointerException("No file path provided."); }
        
        this.filepath = filepath;
        
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        File owlFile = new File(filepath);
        
        this.filename = owlFile.getName();
        this.ontology = manager.loadOntologyFromOntologyDocument(owlFile);
        this.datafactory = manager.getOWLDataFactory();
        
        if (ontology == null) { throw new AssertionError("Ontology cannot be null"); }
        this.importBFOClassesAndAxioms();
    }

    // save ontology method
    
    private void importBFOClassesAndAxioms(){
        /// TODO
        // ontology merger?
    }
    
    public String filename(){
    	return this.filename;
    }
    
    public String filepath(){
        return this.filepath;
    }
    
    // insert axiom method
    public boolean addClassAxiom(String OWLClassName, String axiomType, String otherOWLClassName){
    	// returns true if successful and false otherwise.
    	/// TODO
    	IRI ontology_iri = ontology.getOntologyID().getOntologyIRI().get();
        /// FIXME: Talking point: do we want to check if they are using an existing bfo entity and stop them if they are?
        IRI class_iri = this.datafactory.getOWLClass(
            OWLClassName, 
            this.ontology.getFormat().asPrefixOWLDocumentFormat()
        ).getIRI();
        /// TODO: check if class is in Ontology
        /// TODO: check if relation is in Ontology
        OWLClass owlCls = this.getOrCreateClass(class_iri);
        
        return (owlCls != null);
    	// return false;
    }
    
    private OWLClass getOrCreateClass(IRI classIRI){
        // adds class if not found in ontology
        /* short way: 
            currently doesn't work 
        */
        if (this.ontology.containsClassInSignature(classIRI)){//isDeclared(classIRI)){
            return this.datafactory.getOWLClass(classIRI);
        }
        /* long way */
        for (OWLClass owlCls : this.ontology.getClassesInSignature()) {
            if(owlCls.getIRI().equals(classIRI)){
                return owlCls;
            }
        }
        /// TODO: create owl class assertion and return class
        return null;
    }
    
    public static String[] getAxiomTypes(){
        int size = AxiomType.AXIOM_TYPES.size();
        String[] axiomTypes = new String[size];
        int index = 0;
        for (AxiomType at: AxiomType.AXIOM_TYPES){
            axiomTypes[index] = at.getName();
            index++;
        }       
        return axiomTypes;
    }
}
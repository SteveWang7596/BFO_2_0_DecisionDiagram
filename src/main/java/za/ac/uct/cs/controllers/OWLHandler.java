/// TODO
package za.ac.uct.cs.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.parameters.ChangeApplied;

public class OWLHandler{
    private String filename;
    private String filepath;
    private OWLOntology ontology;
    private OWLDataFactory datafactory;
    private static Map<String, String> LABEL_TO_IRI_FRAGMENT;
    private static boolean STATIC_VARIABLES_INITIALISED = false;

    static void init(){
    	// initialise LABEL_TO_IRI_FRAGMENT
        if (STATIC_VARIABLES_INITIALISED) { return; }
        System.out.println("Executing static block"); // TODO: REMOVE
        LABEL_TO_IRI_FRAGMENT = new HashMap<>();
    	// Entity: BFO_0000001
		// Class: BFO_0000002
		// Class: BFO_0000003
		// Class: BFO_0000004
		// Class: BFO_0000006
		// Class: BFO_0000008
		// Class: BFO_0000009
		// Class: BFO_0000011
		// Class: BFO_0000015
		// Class: BFO_0000016
		// Class: BFO_0000017
		// Class: BFO_0000018
		// Class: BFO_0000019
		// Class: BFO_0000020
		// Class: BFO_0000023
		// Class: BFO_0000024
		// Class: BFO_0000026
		// Class: BFO_0000027
		// Class: BFO_0000028
		// Class: BFO_0000029
		// Class: BFO_0000030
		// Class: BFO_0000031
		// Class: BFO_0000034
		// Class: BFO_0000035
		// Class: BFO_0000038
		// Class: BFO_0000040
		// Class: BFO_0000140
		// Class: BFO_0000141
		// Class: BFO_0000142
		// Class: BFO_0000144
		// Class: BFO_0000145
		// Class: BFO_0000146
		// Class: BFO_0000147
		// Class: BFO_0000148
		// Class: BFO_0000182
		// Class: Nothing
        STATIC_VARIABLES_INITIALISED = true;
    }

    public OWLHandler(String filepath) 
    throws NullPointerException, OWLOntologyCreationException, FileNotFoundException, AssertionError 
    {
        /// TODO: documentation
        init();
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
    ///TODO: talking points: give user option to choose IRI fragment??
    
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
        IRI class_iri = this.getIRIFromLabel(OWLClassName);
        IRI other_iri = this.getIRIFromLabel(otherOWLClassName);
        // check if class is in Ontology
        OWLClass entityOne = this.getOrCreateClass(class_iri);
        OWLClass entityTwo = this.getOrCreateClass(other_iri);
        if (entityOne == null || entityTwo == null) { return false; }           // unable to locate or create class
        /// TODO: check if relation is in Ontology
        // add axiom to Ontology
        if (AxiomType.getAxiomType(axiomType).equals(AxiomType.SUBCLASS_OF)){
            OWLAxiom relAxiom = this.datafactory.getOWLSubClassOfAxiom(entityOne, entityTwo);
            return (this.ontology.addAxiom(relAxiom) == ChangeApplied.SUCCESSFULLY);
        }
        // some other axiom type was provided
        return false;
    }
    
    private IRI getIRIFromLabel(String label){
        return this.datafactory.getOWLClass(
            LABEL_TO_IRI_FRAGMENT.getOrDefault(label, label), 
            this.ontology.getFormat().asPrefixOWLDocumentFormat()
        ).getIRI();
    }
    
    private OWLClass getOrCreateClass(IRI classIRI){
        // adds class if not found in ontology
        /* short way: 
            it works but does not consider labels 
            i.e. you cannot search for 'Entity' rather 'BFO_0000001'
        */
        if (this.ontology.containsClassInSignature(classIRI)){//isDeclared(classIRI)){
            return this.datafactory.getOWLClass(classIRI);
        }
        /* long way 
            doesn't work on labels; see above
        */
        String label = classIRI.getFragment();
        LabelExtractor extractor = new LabelExtractor();
        // AxiomType.getAxiomsOfTypes(sourceAxioms, axiomTypes);
        for (OWLClass owlCls : this.ontology.getClassesInSignature()) {
            System.out.println("Class: " + owlCls.getIRI().getShortForm()); // TODO: REMOVE
            // look into "map" set of functions for annotations
            OWLEntity entity = (OWLEntity)owlCls;
            // Set<OWLAnnotation> annotations = entity.getAnnotations(this.ontology);
            // for (OWLAnnotation note : annotations) {
            //     String result = note.accept(extractor);
            //     if (result != null) {
            //         System.out.println(result);
            //         // compare result with label
            //     }
            // }
            if(owlCls.getIRI().equals(classIRI)){
                return owlCls;
            }
        }
        /// TODO: create owl class declaration and return class
        System.out.println("Creating new class: " + label); // TODO: REMOVE
        OWLClass owlCls = this.datafactory.getOWLClass(classIRI);
        OWLAxiom[] axioms = new OWLAxiom[] {
            // add label annotation
            this.datafactory.getOWLAnnotationAssertionAxiom(
                this.datafactory.getRDFSLabel(),
                classIRI, 
                this.datafactory.getRDFSLabel(label).annotationValue()
            ),
            // add class declaration
            this.datafactory.getOWLDeclarationAxiom(owlCls)
        };
        if (this.ontology.addAxioms(axioms) != ChangeApplied.SUCCESSFULLY) {
            return null;
        }
        return owlCls;
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
    
    class LabelExtractor 
    implements OWLObjectVisitorEx<String>, OWLAnnotationObjectVisitorEx<String>{    
        @Override
        public String visit(OWLAnnotation annotation) {
            if (annotation.getProperty().isLabel()) {
                return annotation.literalValue().get().getLiteral();
            }
            return null;
        }
    }

}
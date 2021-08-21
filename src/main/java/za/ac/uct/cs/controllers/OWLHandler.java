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
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.model.parameters.ChangeApplied;
import org.semanticweb.owlapi.util.DefaultPrefixManager;

public class OWLHandler{
    private String filename;
    private String filepath;
    private OWLOntology ontology;
    private OWLDataFactory datafactory;
    private OWLOntologyManager manager;
    private PrefixManager prefixManager;
    private static Map<String, String> LABEL_TO_IRI_FRAGMENT;
    private static boolean STATIC_VARIABLES_INITIALISED = false;

    static void init(){
    	// initialise LABEL_TO_IRI_FRAGMENT
        if (STATIC_VARIABLES_INITIALISED) { return; }
        System.out.println("Executing static block"); // TODO: REMOVE
        LABEL_TO_IRI_FRAGMENT = new HashMap<>();
    	LABEL_TO_IRI_FRAGMENT.put("entity", "BFO_0000001");
        LABEL_TO_IRI_FRAGMENT.put("continuant", "BFO_0000002");
        LABEL_TO_IRI_FRAGMENT.put("occurrent", "BFO_0000003");
        LABEL_TO_IRI_FRAGMENT.put("independent continuant", "BFO_0000004");
        LABEL_TO_IRI_FRAGMENT.put("spatial region", "BFO_0000006");
        LABEL_TO_IRI_FRAGMENT.put("temporal region", "BFO_0000008");
        LABEL_TO_IRI_FRAGMENT.put("two-dimensional spatial region", "BFO_0000009");
        LABEL_TO_IRI_FRAGMENT.put("spatiotemporal region", "BFO_0000011");
        LABEL_TO_IRI_FRAGMENT.put("process", "BFO_0000015");
        LABEL_TO_IRI_FRAGMENT.put("disposition", "BFO_0000016");
        LABEL_TO_IRI_FRAGMENT.put("realizable entity", "BFO_0000017");
        LABEL_TO_IRI_FRAGMENT.put("zero-dimensional spatial region", "BFO_0000018");
        LABEL_TO_IRI_FRAGMENT.put("quality", "BFO_0000019");
        LABEL_TO_IRI_FRAGMENT.put("specifically dependent continuant", "BFO_0000020");
        LABEL_TO_IRI_FRAGMENT.put("role", "BFO_0000023");
        LABEL_TO_IRI_FRAGMENT.put("fiat object", "BFO_0000024");
        LABEL_TO_IRI_FRAGMENT.put("one-dimensional spatial region", "BFO_0000026");
        LABEL_TO_IRI_FRAGMENT.put("object aggregate", "BFO_0000027");
        LABEL_TO_IRI_FRAGMENT.put("three-dimensional spatial region", "BFO_0000028");
        LABEL_TO_IRI_FRAGMENT.put("site", "BFO_0000029");
        LABEL_TO_IRI_FRAGMENT.put("object", "BFO_0000030");
        LABEL_TO_IRI_FRAGMENT.put("generically dependent continuant", "BFO_0000031");
        LABEL_TO_IRI_FRAGMENT.put("function", "BFO_0000034");
        LABEL_TO_IRI_FRAGMENT.put("process boundary", "BFO_0000035");
        LABEL_TO_IRI_FRAGMENT.put("one-dimensional temporal region", "BFO_0000038");
        LABEL_TO_IRI_FRAGMENT.put("material entity", "BFO_0000040");
        LABEL_TO_IRI_FRAGMENT.put("continuant fiat boundary", "BFO_0000140");
        LABEL_TO_IRI_FRAGMENT.put("immaterial entity", "BFO_0000141");
        LABEL_TO_IRI_FRAGMENT.put("one-dimensional continuant fiat boundary", "BFO_0000142");
        LABEL_TO_IRI_FRAGMENT.put("process profile", "BFO_0000144");
        LABEL_TO_IRI_FRAGMENT.put("relational quality", "BFO_0000145");
        LABEL_TO_IRI_FRAGMENT.put("two-dimensional continuant fiat boundary", "BFO_0000146");
        LABEL_TO_IRI_FRAGMENT.put("zero-dimensional continuant fiat boundary", "BFO_0000147");
        LABEL_TO_IRI_FRAGMENT.put("zero-dimensional temporal region", "BFO_0000148");
        LABEL_TO_IRI_FRAGMENT.put("history", "BFO_0000182");
        
        STATIC_VARIABLES_INITIALISED = true;
    }

    public OWLHandler(String filepath) 
    throws NullPointerException, OWLOntologyCreationException, FileNotFoundException, AssertionError 
    {
        /// TODO: documentation
        init();
        if (filepath == null) { throw new NullPointerException("No file path provided."); }
        
        this.filepath = filepath;
        
        manager = OWLManager.createOWLOntologyManager();
        File owlFile = new File(filepath);
        
        this.filename = owlFile.getName();
        this.ontology = manager.loadOntologyFromOntologyDocument(owlFile);
        this.datafactory = manager.getOWLDataFactory();
        this.prefixManager = getPrefixManager();
        
        if (ontology == null) { throw new AssertionError("Ontology cannot be null"); }
        this.importBFOClassesAndAxioms();
    }
    
    public PrefixManager getPrefixManager(){
        String bfo_prefix = this.ontology.getFormat().asPrefixOWLDocumentFormat().getDefaultPrefix().replace("bfo.owl#", "");
        return new DefaultPrefixManager(bfo_prefix);
    }

    // save ontology method
    ///TODO: talking points: give user option to choose IRI fragment??
    
    public void saveOntology() throws OWLOntologyStorageException{
        manager.saveOntology(ontology);
    }
    
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
    //[**At the moment we only going to use subclass axioms, so I recommend keep this for later]
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
    
    public boolean addSubClassOfAxiom(String superclass, String subclass){
        // Class validation
        if (!LABEL_TO_IRI_FRAGMENT.containsKey(superclass.toLowerCase()))
            // Superclass should be an BFO enetity
            return false;
        if (LABEL_TO_IRI_FRAGMENT.containsKey(subclass.toLowerCase()))
            // Subclass should not be an BFO enetity
            return false;
        
        OWLClass owl_superclass = getOrCreateClass(getIRIFromLabel(superclass));
        OWLClass owl_subclass = getOrCreateClass(getIRIFromLabel(subclass));
        
        if (owl_superclass == null || owl_subclass == null)
            // Unable to create OWLClasses
            return false;
        
        OWLAxiom subClassOfAxiom = datafactory.getOWLSubClassOfAxiom(owl_subclass, owl_superclass);
        System.out.println("Adding Axiom: " + subClassOfAxiom.toString());
        return (ontology.addAxiom(subClassOfAxiom) == ChangeApplied.SUCCESSFULLY);
        
    }
    
    public IRI getIRIFromLabel(String label){
        return this.datafactory.getOWLClass(
            LABEL_TO_IRI_FRAGMENT.getOrDefault(label, label), 
            this.prefixManager
        ).getIRI();
    }
    
    private OWLClass getOrCreateClass(IRI classIRI){
        
        // adds class if not found in ontology
        /* short way: 
            it works but does not consider labels 
            i.e. you cannot search for 'Entity' rather 'BFO_0000001'
        */
        if (this.ontology.containsClassInSignature(classIRI)){//isDeclared(classIRI)){
            System.out.println("IRI: " + classIRI + " found in the ontology.");
            return this.datafactory.getOWLClass(classIRI);
        }
        System.out.println("IRI: " + classIRI + " not found in the ontology. Creating OWL class....");
        /* long way  [** Not neded since the short way does the same thing]
            doesn't work on labels; see above
        */
        String label = classIRI.getFragment();
        System.out.println("Lable: " + label);
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
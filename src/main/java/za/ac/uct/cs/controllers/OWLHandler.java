/// TODO
package za.ac.uct.cs.controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.io.FileDocumentTarget;
import org.semanticweb.owlapi.model.AddImport;
import org.semanticweb.owlapi.model.AxiomType;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLAnnotation;
import org.semanticweb.owlapi.model.OWLAnnotationObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLAxiom;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLEntity;
import org.semanticweb.owlapi.model.OWLImportsDeclaration;
import org.semanticweb.owlapi.model.OWLObjectVisitorEx;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.model.PrefixManager;
import org.semanticweb.owlapi.model.parameters.ChangeApplied;
import org.semanticweb.owlapi.model.parameters.Imports;
import org.semanticweb.owlapi.util.SimpleIRIMapper;

public class OWLHandler{
    private String filename;
    private String filepath;
    private OWLOntology ontology;
    private OWLDataFactory datafactory;
    private static OWLOntology BFO_2_0;
    private static String BFO_PREFIX_NAME = "obo:";
    private static Map<String, String> LABEL_TO_IRI_FRAGMENT;
    private static boolean STATIC_VARIABLES_INITIALISED = false;
    public final static String BFO_FILEPATH = "za/ac/uct/cs/owl/BF0_2_0.owl";

    static void init(){
    	// initialise LABEL_TO_IRI_FRAGMENT
        if (STATIC_VARIABLES_INITIALISED) { return; }
        Logger.getLogger(OWLHandler.class.getName()).log(
            Level.CONFIG,
            "Executing static block."
        );
        LABEL_TO_IRI_FRAGMENT = new HashMap<>();
    	// Entity: BFO_0000001
        LABEL_TO_IRI_FRAGMENT.put("entity", "BFO_0000001");
        // Continuant: BFO_0000002
        LABEL_TO_IRI_FRAGMENT.put("continuant", "BFO_0000002");
        // Occurrent: BFO_0000003
        LABEL_TO_IRI_FRAGMENT.put("occurrent", "BFO_0000003");
        // Independent Continuant: BFO_0000004
        LABEL_TO_IRI_FRAGMENT.put("independent continuant", "BFO_0000004");
        // Spatial Region: BFO_0000006
        LABEL_TO_IRI_FRAGMENT.put("spatial region", "BFO_0000006");
        // Temporal Region: BFO_0000008
        LABEL_TO_IRI_FRAGMENT.put("temporal region", "BFO_0000008");
        // Two-dimensional Spatial Region: BFO_0000009
        LABEL_TO_IRI_FRAGMENT.put("two-dimensional spatial region", "BFO_0000009");
        // Spatio-Temporal Region: BFO_0000011
        LABEL_TO_IRI_FRAGMENT.put("spatiotemporal region", "BFO_0000011");
        // Process: BFO_0000015
        LABEL_TO_IRI_FRAGMENT.put("process", "BFO_0000015");
        // Disposition: BFO_0000016
        LABEL_TO_IRI_FRAGMENT.put("disposition", "BFO_0000016");
        // Realizable Entity: BFO_0000017
        LABEL_TO_IRI_FRAGMENT.put("realizable entity", "BFO_0000017");
        // Zero-dimensional Spatial Region: BFO_0000018
        LABEL_TO_IRI_FRAGMENT.put("zero-dimensional spatial region", "BFO_0000018");
        // Quality: BFO_0000019
        LABEL_TO_IRI_FRAGMENT.put("quality", "BFO_0000019");
        // Specifically Dependent Continuant: BFO_0000020
        LABEL_TO_IRI_FRAGMENT.put("specifically dependent continuant", "BFO_0000020");
        // Role: BFO_0000023
        LABEL_TO_IRI_FRAGMENT.put("role", "BFO_0000023");
        // Fiat: BFO_0000024
        LABEL_TO_IRI_FRAGMENT.put("fiat object", "BFO_0000024");
        // One-dimensional Spatial Region: BFO_0000026
        LABEL_TO_IRI_FRAGMENT.put("one-dimensional spatial region", "BFO_0000026");
        // Object Aggregate: BFO_0000027
        LABEL_TO_IRI_FRAGMENT.put("object aggregate", "BFO_0000027");
        // Three-dimensional Spatial Region: BFO_0000028
        LABEL_TO_IRI_FRAGMENT.put("three-dimensional spatial region", "BFO_0000028");
        // Site: BFO_0000029
        LABEL_TO_IRI_FRAGMENT.put("site", "BFO_0000029");
        // Object: BFO_0000030
        LABEL_TO_IRI_FRAGMENT.put("object", "BFO_0000030");
        // Generically Dependent Continuant: BFO_0000031
        LABEL_TO_IRI_FRAGMENT.put("generically dependent continuant", "BFO_0000031");
        // Function: BFO_0000034
        LABEL_TO_IRI_FRAGMENT.put("function", "BFO_0000034");
        // Process Boundary: BFO_0000035
        LABEL_TO_IRI_FRAGMENT.put("process boundary", "BFO_0000035");
        // One-dimensional Temporal Region: BFO_0000038
        LABEL_TO_IRI_FRAGMENT.put("one-dimensional temporal region", "BFO_0000038");
        // Material Entity: BFO_0000040
        LABEL_TO_IRI_FRAGMENT.put("material entity", "BFO_0000040");
        // Continuant Fiat Boundary: BFO_0000140
        LABEL_TO_IRI_FRAGMENT.put("continuant fiat boundary", "BFO_0000140");
        // Immaterial Entity: BFO_0000141
        LABEL_TO_IRI_FRAGMENT.put("immaterial entity", "BFO_0000141");
        // One-dimensional Continuant Fiat Entity: BFO_0000142
        LABEL_TO_IRI_FRAGMENT.put("one-dimensional continuant fiat boundary", "BFO_0000142");
        // Process Profile: BFO_0000144
        LABEL_TO_IRI_FRAGMENT.put("process profile", "BFO_0000144");
        // Relational Quality: BFO_0000145
        LABEL_TO_IRI_FRAGMENT.put("relational quality", "BFO_0000145");
        // Two-dimensional Continuant Fiat Boundary: BFO_0000146
        LABEL_TO_IRI_FRAGMENT.put("two-dimensional continuant fiat boundary", "BFO_0000146");
        // Zero-dimensional Continuant Fiat Boundary: BFO_0000147
        LABEL_TO_IRI_FRAGMENT.put("zero-dimensional continuant fiat boundary", "BFO_0000147");
        // Zero-dimensional Temporal Region: BFO_0000148
        LABEL_TO_IRI_FRAGMENT.put("zero-dimensional temporal region", "BFO_0000148");
        // History: BFO_0000182
        LABEL_TO_IRI_FRAGMENT.put("history", "BFO_0000182");

        loadBFOOntology();
        
        STATIC_VARIABLES_INITIALISED = true;
        Logger.getLogger(OWLHandler.class.getName()).log(
            Level.CONFIG,
            "Static block execution complete."
        );
    }

    /**
     * Constructor that creates an OWLHandler object for an owl ontology 
     * document stored at the provided system path.
     * @param filepath  path to where the owl ontology document is saved.
     * @throws NullPointerException
     * @throws OWLOntologyCreationException
     * @throws FileNotFoundException
     * @throws AssertionError 
     */
    public OWLHandler(String filepath) 
    throws NullPointerException, OWLOntologyCreationException, FileNotFoundException, AssertionError 
    {
        init();
        if (filepath == null) { throw new NullPointerException("No file path provided."); }

        this.filepath = filepath;

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        File owlFile = new File(filepath);

        this.filename = owlFile.getName();
        this.ontology = manager.loadOntologyFromOntologyDocument(owlFile);
        this.datafactory = manager.getOWLDataFactory();

        if (ontology == null) { throw new AssertionError("Ontology cannot be null"); }
        this.setDefaultPrefix();
        this.importBFOClassesAndAxioms();
    }
    
    /**
     * Constructor that creates an OWLHandler object from an InputStream of an 
     * existing owl ontology document.
     * @param filestream   an InputStream of an existing owl ontology document.
     * @param filepath  path that the modified owl ontology should be saved at.
     * @throws NullPointerException
     * @throws OWLOntologyCreationException
     * @throws AssertionError 
     */
    public OWLHandler(InputStream filestream, String filepath) 
    throws NullPointerException, OWLOntologyCreationException, AssertionError 
    {
        init();
        if (filestream == null) { 
            throw new NullPointerException("No file input stream provided."); 
        }
        if (filepath == null) { 
            throw new NullPointerException("No file path provided."); 
        }

        this.filepath = filepath;
        this.filename = FileUtils.getFilename(filepath);

        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();

        this.ontology = manager.loadOntologyFromOntologyDocument(filestream);
        this.datafactory = manager.getOWLDataFactory();

        if (ontology == null) { throw new AssertionError("Ontology cannot be null"); }
        this.setDefaultPrefix();
        this.importBFOClassesAndAxioms();
    }

    private static void loadBFOOntology() {
        if (BFO_2_0 != null) { return; }
        OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
        InputStream bfoFile = FileUtils.getFileFromResourcePackage(BFO_FILEPATH);

        try {
            BFO_2_0 = manager.loadOntologyFromOntologyDocument(bfoFile);
        }
        catch(OWLOntologyCreationException ex) {
            Logger.getLogger(OWLHandler.class.getName()).log(
                Level.SEVERE,
                null,
                ex
            );
        }
        
        if (BFO_2_0 == null) { throw new NullPointerException("BFO_2_0 is Null."); }

        PrefixManager prefix = BFO_2_0.getFormat().asPrefixOWLDocumentFormat();
        prefix.setDefaultPrefix(prefix.getPrefix(BFO_PREFIX_NAME));
    }

    // save ontology method
    public void saveToFile() throws OWLOntologyStorageException {
        /// TODO: change ontology IRI and location if equal to BFO 2.0 IRI
        // set document target using filepath and use that when saving
        FileDocumentTarget fd = new FileDocumentTarget(new File(this.filepath));
        this.ontology.saveOntology(fd);
    }
    
    private void importBFOClassesAndAxioms() throws OWLOntologyCreationException {
        /// TODO: documentation
        IRI ontology_iri = this.ontology.getOntologyID().getOntologyIRI().get();
        IRI bfo_iri = BFO_2_0.getOntologyID().getOntologyIRI().get();
        if (ontology_iri.equals(bfo_iri)) { return; }
        // Create imports declaration for BFO 2.0
        OWLImportsDeclaration bfo_import = this.datafactory
                                               .getOWLImportsDeclaration(bfo_iri);
        // Check for BFO 2.0 import
        boolean bfo_imported = this.ontology.importsDeclarations().anyMatch(
            (t) -> {
                Logger.getLogger(OWLHandler.class.getName()).log(
                    Level.INFO,
                    String.format("Imported ontology: %s", t.getIRI().getIRIString())
                );
                return t.equals(bfo_import);
            }
        );
        if (bfo_imported){
            Logger.getLogger(OWLHandler.class.getName()).log(
                Level.INFO, 
                "BFO 2.0 already imported."
            );
            return;
        }
        // If not already imported, import BFO 2.0
        this.ontology.getOWLOntologyManager().makeLoadImportRequest(bfo_import);
        bfo_imported = (this.ontology.applyChange(
            new AddImport(this.ontology, bfo_import)) == ChangeApplied.SUCCESSFULLY
        );
        if (!bfo_imported){
            throw new OWLOntologyCreationException(
                String.format(
                    "Could not import BFO 2.0 into %s ontology", 
                    getIRIFragment(ontology_iri)
                )
            );
        }
        Logger.getLogger(OWLHandler.class.getName()).log(Level.INFO, "BFO 2.0 successfully imported.");
    }
    
    /**
     * Gets the file name that the loaded ontology will be saved to. 
     * @return  the name of the file where the loaded ontology will be saved.
     */
    public String filename(){
    	return this.filename;
    }
    
    /**
     * Gets the full file path that the loaded ontology will be saved to. 
     * @return  the path where the loaded ontology will be saved.
     */
    public String filepath(){
        return this.filepath;
    }
    
    private void setDefaultPrefix(){
        PrefixManager manager = this.ontology.getFormat().asPrefixOWLDocumentFormat();
        if (manager.containsPrefixMapping(BFO_PREFIX_NAME)){
            manager.setDefaultPrefix(manager.getPrefix(BFO_PREFIX_NAME));
        }
    }

    /**
     * This method adds a binary axiom to the loaded ontology.
     * @param OWLClassName  name of an owl class 
     * @param axiomType  name of the binary axiom
     * @param otherOWLClassName  name of an owl class
     * @return  A Boolean value of True if successful and False otherwise.
     */
    public boolean addClassAxiom(String OWLClassName, String axiomType, String otherOWLClassName){
    	/* TODO: documentation; returns true if successful and false otherwise. */
    	IRI class_iri = this.getIRIFromLabel(OWLClassName, this.ontology);
        IRI other_iri = this.getIRIFromLabel(otherOWLClassName, this.ontology);
        return this.addClassAxiom(class_iri, axiomType, other_iri);
    }

    /**
     * This method adds a binary axiom to the loaded ontology.
     * @param OWLClassIRI  IRI of an owl class 
     * @param axiomType  name of the binary axiom
     * @param otherOWLClassIRI  IRI of an owl class
     * @return  A Boolean value of True if successful and False otherwise.
     */
    public boolean addClassAxiom(IRI OWLClassIRI, String axiomType, IRI otherOWLClassIRI){
    	// check if class is in Ontology
        OWLClass entityOne = this.getOrCreateClass(OWLClassIRI);
        OWLClass entityTwo = this.getOrCreateClass(otherOWLClassIRI);
        if (entityOne == null || entityTwo == null) { return false; }           // unable to locate or create class
        // check if relation is in Ontology
        // if not, add axiom to Ontology
        if (AxiomType.getAxiomType(axiomType).equals(AxiomType.SUBCLASS_OF)){
            OWLAxiom relAxiom = this.datafactory.getOWLSubClassOfAxiom(entityOne, entityTwo);
            if (this.ontology.containsAxiom(relAxiom)) { return true; }         // axiom already exists in the ontology
            return (this.ontology.addAxiom(relAxiom) == ChangeApplied.SUCCESSFULLY);
        }
        // some other axiom type was provided
        return false;
    }

    //[**I don't think this is necessary, the existing method already does this]
    //[**I'll add the subclass check to the other method.]
    //[**Actually I'm probably just being stubborn. (debating with myself which approach is better)]
    //[**After much deliberation, my conclusion is that this is too much program logic for this class]__chiadika
    public boolean addSubClassOfAxiom(String superclass, String subclass){
        // Class validation
        if (!LABEL_TO_IRI_FRAGMENT.containsKey(superclass))
            // Superclass should be an BFO entity
            return false;
        if (LABEL_TO_IRI_FRAGMENT.containsKey(subclass))
            // Subclass should not be an BFO entity
            return false;

        OWLClass owl_superclass = getOrCreateClass(getIRIFromLabel(superclass, BFO_2_0));
        OWLClass owl_subclass = getOrCreateClass(getIRIFromLabel(subclass, this.ontology));

        if (owl_superclass == null || owl_subclass == null)
            // Unable to create OWLClasses
            return false;

        OWLAxiom subClassOfAxiom = datafactory.getOWLSubClassOfAxiom(owl_subclass, owl_superclass);
        Logger.getLogger(OWLHandler.class.getName()).log(
            Level.INFO,
            String.format("Adding Axiom: %s", subClassOfAxiom.toString())
        );
        return (ontology.addAxiom(subClassOfAxiom) == ChangeApplied.SUCCESSFULLY);
    }

    /**
     * Creates an IRI for the given class label using the BFO 2.0 prefix format.
     * @param label  the name of the OWL class.
     * @return  the class IRI for the given class label.
     */
    public IRI getBFOClassIRI(String label){
        return this.getIRIFromLabel(label, OWLHandler.BFO_2_0);
    }

    /**
     * Creates an IRI for the given class label using the prefix format of the 
     * loaded ontology.
     * @param label  the name of the OWL class.
     * @return  the class IRI for the given class label.
     */
    public IRI getDomainIRI(String label){
    	return this.getIRIFromLabel(label, this.ontology);
    }

    private IRI getIRIFromLabel(String label, OWLOntology ontologie){
        label = LABEL_TO_IRI_FRAGMENT.getOrDefault(label, label);
        PrefixManager prefix = ontologie.getFormat().asPrefixOWLDocumentFormat();
        Set<String> prefixNames = prefix.getPrefixNames();
        
        for (String prefixName : prefixNames){
            IRI tempIRI = IRI.create(prefix.getPrefix(prefixName), label);
            if (ontologie.containsClassInSignature(tempIRI, Imports.INCLUDED)){
                return tempIRI;
            }
        }
        /// TODO? maybe check for label in ontologie and return associated class iri if it exists.
        // otherwise use default prefix to create class IRI
        return this.datafactory.getOWLClass(label, prefix).getIRI();
    }
    
    private OWLClass getOrCreateClass(IRI classIRI){
        // adds class if not found in ontology
        /* short way: 
            it works but does not consider labels 
            i.e. you cannot search for 'Entity' rather 'BFO_0000001'
        */
        if (this.ontology.containsClassInSignature(classIRI, Imports.INCLUDED)){
            Logger.getLogger(OWLHandler.class.getName()).log(
                Level.INFO,
                String.format("IRI: %s found in the ontology.", classIRI)
            );
            return this.datafactory.getOWLClass(classIRI);
        }
        /* long way:
            if class is not found, check through labels [TODO]
            (maybe only do this if IRI differs from BFO 2.0 IRI)
        */
        String label = classIRI.getFragment();
        LabelExtractor extractor = new LabelExtractor();
        for (OWLClass owlCls : this.ontology.getClassesInSignature()) {
            // System.out.println("Class: " + owlCls.getIRI().getShortForm()); // TODO: REMOVE
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
        // create owl class declaration and return class
        Logger.getLogger(OWLHandler.class.getName()).log(
            Level.INFO,
            String.format("Creating new class: %s", label)
        );
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
    
    private String getIRIFragment(IRI fullIRI){
        String no_spaces = fullIRI.getIRIString().replaceAll(" ", "-");
        IRI no_space_iri = IRI.create(no_spaces);
        int begin_index = no_spaces.lastIndexOf(no_space_iri.getFragment());
        return fullIRI.getIRIString().substring(begin_index);
    }
    
    /**
     * Returns an array of string representations (names) of all owl axiom types.
     * @return the names of owl axiom types
     */
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
    
    /**
     * This method is provided for use for memory management. 
     * It is only to be called once, to remove the loaded ontology from memory.
     */
    public void clean(){
        OWLOntologyManager manager = this.ontology.getOWLOntologyManager();
        manager.removeOntology(this.ontology);
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
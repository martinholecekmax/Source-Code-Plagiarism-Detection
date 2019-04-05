public class SemanticAnnotation_Type extends ReferenceAnnotation_Type {
  
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (SemanticAnnotation_Type.this.useExistingInstance) {
  			     		     FeatureStructure fs = SemanticAnnotation_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new SemanticAnnotation(addr, SemanticAnnotation_Type.this);
  			   SemanticAnnotation_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new SemanticAnnotation(addr, SemanticAnnotation_Type.this);
  	  }
    };
  
  public final static int typeIndexID = SemanticAnnotation.typeIndexID;
  
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.u_compare.shared.semantic.SemanticAnnotation");
  
  public SemanticAnnotation_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());
  }
}
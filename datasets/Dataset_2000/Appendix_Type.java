public class Appendix_Type extends Structure_Type {
  
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Appendix_Type.this.useExistingInstance) {
  			     		     FeatureStructure fs = Appendix_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Appendix(addr, Appendix_Type.this);
  			   Appendix_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Appendix(addr, Appendix_Type.this);
  	  }
    };
  
  public final static int typeIndexID = Appendix.typeIndexID;
  
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("org.u_compare.shared.document.structure.Appendix");
  
  public Appendix_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());
  }
}
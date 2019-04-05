public class AlgoQ3 extends AlgoElement {
	private static final long serialVersionUID = 1L;
	private GeoList inputList;     private GeoNumeric Q3;     private int size;
    public AlgoQ3(Construction cons, String label, GeoList inputList) {
    	this(cons, inputList);
        Q3.setLabel(label);
    }
    public AlgoQ3(Construction cons, GeoList inputList) {
        super(cons);
        this.inputList = inputList;
        Q3 = new GeoNumeric(cons);
        setInputOutput();
        compute();
    }
    public String getClassName() {
        return "AlgoQ3";
    }
    protected void setInputOutput(){
        input = new GeoElement[1];
        input[0] = inputList;
        output = new GeoElement[1];
        output[0] = Q3;
        setDependencies();     }
    public GeoNumeric getQ3() {
        return Q3;
    }
    protected final void compute() {
    	size = inputList.size();
    	if (!inputList.isDefined() ||  size < 2) {
    		Q3.setUndefined();
    		return;
    	} 
       double[] sortList = new double[size];
              for (int i=0 ; i<size ; i++)
       {
   		 GeoElement geo = inputList.get(i); 
		 if (geo.isNumberValue()) {
			NumberValue num = (NumberValue) geo;
			sortList[i]=num.getDouble();
		 }
		 else
		 {
			Q3.setUndefined();
    		return;			
		 }
       }
              Arrays.sort(sortList);
       switch (size % 4)
       {
       case 0:
      	   Q3.setValue((sortList[(3*size)/4-1]+sortList[(3*size+4)/4-1])/2);  
    	   break;
       case 1:
           Q3.setValue((sortList[(3*size+1)/4-1]+sortList[(3*size+5)/4-1])/2);  
    	   break;
       case 2:
      	   Q3.setValue(sortList[(3*size+2)/4-1]);  
    	   break;
       default:
           Q3.setValue(sortList[(3*size+3)/4-1]);  
    	   break;
       }
    }
}
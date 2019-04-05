public class AggConvert {
	
	public static void main(String[] args) {
		HenshinPackageImpl.init();
		ModelHelper.registerFileExtension("henshin");
		ModelHelper.registerFileExtension("ecore");
		EPackage sierpinskiPackage = (EPackage) ModelHelper.loadFile("tests/sierpinski.ecore");
		EPackage.Registry.INSTANCE.put(sierpinskiPackage.getNsURI(), sierpinskiPackage);
		EPackage statechartPackage = (EPackage) ModelHelper.loadFile("tests/statechart.ecore");
		EPackage.Registry.INSTANCE.put(statechartPackage.getNsURI(), statechartPackage);
		EPackage ooPackage = (EPackage) ModelHelper.loadFile("tests/OO.ecore");
		EPackage.Registry.INSTANCE.put(ooPackage.getNsURI(), ooPackage);
		EPackage oo2rdbPackage = (EPackage) ModelHelper.loadFile("tests/OO2RDB.ecore");
		EPackage.Registry.INSTANCE.put(oo2rdbPackage.getNsURI(), oo2rdbPackage);
		EPackage rdbPackage = (EPackage) ModelHelper.loadFile("tests/RDB.ecore");
		EPackage.Registry.INSTANCE.put(rdbPackage.getNsURI(), rdbPackage);
				TransformationSystem ts = (TransformationSystem) ModelHelper
				.loadFile("tests/sierpinski.henshin");
		AggInfo aggInfo = new AggInfo(ts);
		aggInfo.getAggGrammar().save("tests/sierpinski.ggx");
				ts = (TransformationSystem) ModelHelper.loadFile("tests/statechart.henshin");
		aggInfo = new AggInfo(ts);
		aggInfo.getAggGrammar().save("tests/statechart.ggx");
		ts = (TransformationSystem) ModelHelper.loadFile("tests/final.henshin");
		aggInfo = new AggInfo(ts);
		aggInfo.getAggGrammar().save("tests/final.ggx");
	}
}
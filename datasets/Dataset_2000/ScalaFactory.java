public interface ScalaFactory extends EFactory {
	
	ScalaFactory eINSTANCE = com.github.sbegaudeau.acceleo.modules.psm.gen.scala.model.scala.impl.ScalaFactoryImpl
			.init();
	
	ExtendableClassifier createExtendableClassifier();
	
	Class createClass();
	
	Object createObject();
	
	Trait createTrait();
	
	Field createField();
	
	Constructor createConstructor();
	
	Method createMethod();
	
	MethodSignature createMethodSignature();
	
	Model createModel();
	
	Parameter createParameter();
	
	Package createPackage();
	
	File createFile();
	
	Visibility createVisibility();
	
	VisibilityKind createVisibilityKind(String literal);
	
	String convertVisibilityKind(VisibilityKind instanceValue);
	
	ScalaPackage getScalaPackage();
}
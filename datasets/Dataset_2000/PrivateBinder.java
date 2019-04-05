public interface PrivateBinder extends Binder {
  
  void expose(Key<?> key);
  
  AnnotatedElementBuilder expose(Class<?> type);
  
  AnnotatedElementBuilder expose(TypeLiteral<?> type);
  PrivateBinder withSource(Object source);
  PrivateBinder skipSources(Class... classesToSkip);
}
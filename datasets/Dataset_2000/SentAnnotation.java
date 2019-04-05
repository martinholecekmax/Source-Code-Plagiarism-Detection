public class SentAnnotation extends AnnotationLiteral<Sent>
                            implements Sent {
    @Override
    public Class<? extends Annotation> annotationType() {
        return Sent.class;
    }
}
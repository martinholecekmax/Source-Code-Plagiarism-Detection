final class ConcatenatedTransformDirect2D extends ConcatenatedTransformDirect
                                       implements MathTransform2D
{
    
    private static final long serialVersionUID = 6009454091075588885L;
    
    private final MathTransform2D transform1;
    
    private final MathTransform2D transform2;
    
    public ConcatenatedTransformDirect2D(final MathTransform2D transform1,
                                         final MathTransform2D transform2)
    {
        super(transform1, transform2);
        this.transform1 = transform1;
        this.transform2 = transform2;
    }
    
    @Override
    boolean isValid() {
        return super.isValid() && getSourceDimensions()==2 && getTargetDimensions()==2;
    }
    
    @Override
    public Point2D transform(final Point2D ptSrc, Point2D ptDst) throws TransformException {
        assert isValid();
        ptDst = transform1.transform(ptSrc, ptDst);
        return  transform2.transform(ptDst, ptDst);
    }
    
    @Override
    public Shape createTransformedShape(final Shape shape) throws TransformException {
        assert isValid();
        return transform2.createTransformedShape(transform1.createTransformedShape(shape));
    }
    
    @Override
    public Matrix derivative(final Point2D point) throws TransformException {
        final XMatrix matrix1 = toXMatrix(transform1.derivative(point));
        final XMatrix matrix2 = toXMatrix(transform2.derivative(transform1.transform(point,null)));
        matrix2.multiply(matrix1);
        return matrix2;
    }
    
    @Override
    public MathTransform2D inverse() throws NoninvertibleTransformException {
        return (MathTransform2D) super.inverse();
    }
}
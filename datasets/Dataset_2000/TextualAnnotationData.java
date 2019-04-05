public class TextualAnnotationData 
	extends AnnotationData
{
	
	public TextualAnnotationData()
	{
		super(TextAnnotation.class);
		setContent(null);
	}
	
	public TextualAnnotationData(String text)
	{
		super(TextAnnotation.class);
		setContent(text);
	}
	
	public  TextualAnnotationData(TextAnnotation annotation)
	{
		super(annotation);
	}
	
	public void setText(String text) { setContent(text); }
	
	public String getText() { return getContentAsString(); }
	
	public Object getContent()
	{
		return ((TextAnnotation) asAnnotation()).getTextValue();
	}
	
	public String getContentAsString() { return (String) getContent(); }
	
	public void setContent(Object content)
	{
		if (content == null)
			throw new IllegalArgumentException("Annotation value cannot " +
												"be null.");
		if (!(content instanceof String))
			throw new IllegalArgumentException("Object must be of type String");
		String value = (String) content;
		if (value.trim().length() == 0)
			throw new IllegalArgumentException(
							"Annotation value cannot be null.");
		((TextAnnotation) asAnnotation()).setTextValue(value);
	}
}
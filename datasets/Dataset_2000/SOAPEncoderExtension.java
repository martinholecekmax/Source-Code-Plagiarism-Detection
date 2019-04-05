public class SOAPEncoderExtension extends Extension {
	public SOAPEncoderExtension(String id, String name, IConfigurationElement e) {
		super(id, name, e);
	}
	public ISOAPEncoder createNew() throws SpecificationException {
		Object o= getExecutableExtension("encoderClass");
		if (o != null) {
			return (ISOAPEncoder) o;
		}
		throw new SpecificationException("Can't intantiate class for processor " + getId());
	}
}
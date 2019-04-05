public class SpringQueryExamplesSupplier extends ParameterSupplier {
	@Override
	public List<PotentialAssignment> getValueSources(ParameterSignature signature) {
		SpringQueryExamples annotation = signature.getAnnotation(SpringQueryExamples.class);
		ApplicationContext ctx = new ClassPathXmlApplicationContext(annotation.contextLocation());
		@SuppressWarnings("unchecked")
		List<String> exampleList = (List<String>) ctx.getBean(annotation.exampleList());
		List<PotentialAssignment> examples = new ArrayList<PotentialAssignment>();
		for (final String example : exampleList)
			examples.add(new PotentialAssignment() {
				@Override
				public Object getValue()
						throws CouldNotGenerateValueException {
					return example;
				}
				@Override
				public String getDescription()
						throws CouldNotGenerateValueException {
					return "query = " + example;
				}
			});
		return examples;
	}
}
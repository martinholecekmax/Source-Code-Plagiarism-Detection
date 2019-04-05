interface DictionaryBuilderParams extends EncodingParameter {
  @ParameterDescription(valueName = "in", description = "Plain file with one entry per line")
  File getInputFile();
  @ParameterDescription(valueName = "out", description = "The dictionary file.")
  File getOutputFile();
}
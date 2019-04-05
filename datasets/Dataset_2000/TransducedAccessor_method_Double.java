public final class TransducedAccessor_method_Double extends DefaultTransducedAccessor {
    public String print(Object o) {
        return DatatypeConverterImpl._printDouble( ((Bean)o).get_double() );
    }
    public void parse(Object o, CharSequence lexical) {
        ((Bean)o).set_double(DatatypeConverterImpl._parseDouble(lexical));
    }
    public boolean hasValue(Object o) {
        return true;
    }
}
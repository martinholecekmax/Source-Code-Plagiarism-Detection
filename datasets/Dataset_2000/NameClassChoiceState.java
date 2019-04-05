public class NameClassChoiceState extends NameClassWithChildState {
    protected NameClass castNameClass( NameClass halfCasted, NameClass newChild ) {
        if( halfCasted==null )    return newChild;            else return new ChoiceNameClass( halfCasted, newChild );
    }
}
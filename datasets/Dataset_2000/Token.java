class Token {
    public static final int ENDSTRING = -1;
    public static final int TOKEN = -2;
    public final int type;         public final String contents;
    public final int position;
	public Token(int code, String input, int start, int end) {
		this.type = code;  		
		this.contents = input.substring(start, end);		
		this.position = start;				
	}
	Token(int code,String sval, Token token) {
		this.type = code;
		this.contents = sval;		
		this.position = token.position;
	}
	int compareTo(String otherString) {
	    return this.contents.compareTo(otherString);
	}
}
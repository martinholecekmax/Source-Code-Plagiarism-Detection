class PageNumberFormatStub implements PageNumberFormat {
	public boolean equals(Object obj) {
		return Util.sameClass(this, obj);
	}
	public String format(PageNumber pageNumber) {
		return null;
	}
}
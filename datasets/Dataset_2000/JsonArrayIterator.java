public class JsonArrayIterator<T> implements Iterator<T>
{
    T curr;
    final JsonParser parser;
    final Class<T> clazz;
    public JsonArrayIterator(JsonParser parser, Class<T> clazz) throws IOException
    {
        this.parser = parser;
        this.clazz = clazz;
                while (parser.getCurrentToken() != JsonToken.START_ARRAY && parser.nextToken() != JsonToken.END_OBJECT) ;
        parser.nextToken();
        next();
    }
    public boolean hasNext()
    {
        return curr != null;
    }
    public T next()
    {
        try {
            return curr;
        }
        finally {
            try {
                curr = parser.readValueAs(clazz);
            }
            catch (IOException e) {
                curr = null;
                throw new RuntimeException(e);
            }
        }
    }
    public void remove()
    {
        throw new UnsupportedOperationException();
    }
}
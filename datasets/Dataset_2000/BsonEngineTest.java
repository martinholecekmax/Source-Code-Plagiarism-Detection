public class BsonEngineTest {
    private BsonEngine engine;
    @Before
    public void setUp() throws Exception {
        this.engine = new BsonEngine();
    }
    @Test(expected = MarshallingException.class)
    public void shouldFailWhenUnableToMarshall() throws Exception {
        engine.marshall(new ErrorObject());
    }
    @Test
    public void shouldFailWhenUnableToUnmarshall() throws Exception {
        try {
            engine.unmarshall(bsonify("{'error':'notADate'}"), ErrorObject.class);
            fail();
        } catch (Exception e) {
            assertThat(e).isInstanceOf(MarshallingException.class);
        }
    }
    @Test
    public void canMarshall() {
        DBObject dbo = engine.marshall(new Fox("fantastic", "roux"));
        assertThat(dbo.get("_class")).isEqualTo("org.jongo.model.Fox");
        assertThat(dbo.get("name")).isEqualTo("fantastic");
        assertThat(dbo.get("color")).isEqualTo("roux");
    }
    @Test
    public void canUnmarshallBson() throws IOException {
        DBObject document = bsonify("{'address': '22 rue des murlins'}");
        Friend friend = engine.unmarshall(document, Friend.class);
        assertThat(friend.getAddress()).isEqualTo("22 rue des murlins");
    }
}
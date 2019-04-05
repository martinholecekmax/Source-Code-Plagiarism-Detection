public class Actions_findActionKey_Test {
  private ActionMap map;
  private Action action;
  @Before
  public void setUp() {
    map = new ActionMap();
    action = createMock(Action.class);
    map.put("key", action);
  }
  @Test
  public void should_return_given_name_if_equal_to_key() {
    Object found = Actions.findActionKey("key", map);
    assertThat(found).isEqualTo("key");
  }
  @Test
  public void should_return_key_if_action_name_is_equal_to_given_name() {
    new EasyMockTemplate(action) {
      @Override protected void expectations() {
        expect(action.getValue(NAME)).andReturn("name");
      }
      @Override protected void codeToTest() {
        Object found = Actions.findActionKey("name", map);
        assertThat(found).isEqualTo("key");
      }
    }.run();
  }
  @Test
  public void should_throw_error_if_key_not_found() {
    try {
      new EasyMockTemplate(action) {
        @Override protected void expectations() {
          expect(action.getValue(NAME)).andReturn("name");
        }
        @Override protected void codeToTest() {
          Object found = Actions.findActionKey("someName", map);
          assertThat(found).isEqualTo("key");
        }
      }.run();
      failWhenExpectingException();
    } catch (ActionFailedException expected) {
      assertThat(expected.getMessage()).isEqualTo("The action 'someName' is not available, available actions:['key']");
    }
  }
}
public class ImmutableEntryWithHashingStrategyTest
{
    @Test
    public void serializedForm()
    {
        Verify.assertSerializedForm(
                1L,
                "rO0ABXNyAFBjb20uZ3MuY29sbGVjdGlvbnMuaW1wbC5tYXAuc3RyYXRlZ3kuaW1tdXRhYmxlLklt\n"
                        + "bXV0YWJsZUVudHJ5V2l0aEhhc2hpbmdTdHJhdGVneQAAAAAAAAABAgABTAAPaGFzaGluZ1N0cmF0\n"
                        + "ZWd5dAAuTGNvbS9ncy9jb2xsZWN0aW9ucy9hcGkvYmxvY2svSGFzaGluZ1N0cmF0ZWd5O3hyADRj\n"
                        + "b20uZ3MuY29sbGVjdGlvbnMuaW1wbC50dXBsZS5BYnN0cmFjdEltbXV0YWJsZUVudHJ5AAAAAAAA\n"
                        + "AAECAAJMAANrZXl0ABJMamF2YS9sYW5nL09iamVjdDtMAAV2YWx1ZXEAfgADeHBwcHNyAEdjb20u\n"
                        + "Z3MuY29sbGVjdGlvbnMuaW1wbC5ibG9jay5mYWN0b3J5Lkhhc2hpbmdTdHJhdGVnaWVzJERlZmF1\n"
                        + "bHRTdHJhdGVneQAAAAAAAAABAgAAeHA=",
                new ImmutableEntryWithHashingStrategy<Object, Object>(null, null, HashingStrategies.<Object>defaultStrategy()));
    }
}
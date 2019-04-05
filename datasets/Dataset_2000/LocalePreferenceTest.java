public class LocalePreferenceTest {
    @Test
    public void testSingleLocale() {
        Locale us = Locale.US;
        LocalePreference pref = new LocalePreference(us);
        Assert.assertEquals("en", pref.getStringValue());
        Assert.assertEquals(1.0, pref.getQuality(), 1.0);
    }
    @Test
    public void testSingleLocaleWithIgnoredQuality() {
        Locale us = Locale.US;
        LocalePreference pref = new LocalePreference(us, 1.0);
        Assert.assertEquals("en", pref.getStringValue());
        Assert.assertEquals(1.0, pref.getQuality(), 1.0);
    }
    @Test
    public void testSingleLocaleWithQuality() {
        Locale us = Locale.US;
        LocalePreference pref = new LocalePreference(us, 0.8);
        Header expected = new Header(HeaderConstants.ACCEPT_LANGUAGE, us.getLanguage() + ";q=0.8");
        Assert.assertEquals(expected, Preferences.toHeader(HeaderConstants.ACCEPT_LANGUAGE, Collections.singletonList(pref)));
    }
    @Test
    public void testMultipleLocales() {
        List<Preference<Locale>> preferences = new ArrayList<Preference<Locale>>(2);
        for (Locale locale : Arrays.asList(Locale.US, Locale.GERMAN)) {
            preferences.add(new LocalePreference(locale));
        }
        Header expected = new Header(HeaderConstants.ACCEPT_LANGUAGE, Locale.US.getLanguage() + ", " + Locale.GERMAN);
        Assert.assertEquals(expected, Preferences.toHeader(HeaderConstants.ACCEPT_LANGUAGE, preferences));
    }
}
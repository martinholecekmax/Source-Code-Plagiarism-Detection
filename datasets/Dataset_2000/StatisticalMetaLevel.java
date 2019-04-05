public class StatisticalMetaLevel {
    private final ImmutableMap<String, Integer> highscores;
    public StatisticalMetaLevel(final ImmutableMap<String, Integer> highscores) {
        this.highscores = highscores;
    }
    public ImmutableMap<String, Integer> getHighscores() {
        return highscores;
    }
    public JSONObject toJSON() throws JSONException {
        final JSONObject result = new JSONObject();
        final JSONObject highscoresObject = new JSONObject();
        for (final Map.Entry<String, Integer> highscore : highscores.entrySet()) {
            highscoresObject.put(highscore.getKey(), highscore.getValue());
        }
        result.put("highscores", highscoresObject);
        return result;
    }
}
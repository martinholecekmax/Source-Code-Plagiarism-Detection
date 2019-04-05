public class NameValidation {
	private static Pattern namePattern = null;
	
	public static String checkAndFilterName(String name) throws InvalidNameException {
		String out = filterName(name);
		if (isBlacklistName(out))
			throw new InvalidNameException(out + " is an invalid name.");
		return out;
	}
	
	public static String checkAndFilterPlayerName(String name) throws InvalidNameException {
		String out = filterName(name);
		if (!isValidName(out))
			throw new InvalidNameException(out + " is an invalid name.");
		return out;
	}
	
	public static String[] checkAndFilterArray(String[] arr) {
		String[] out = arr;
		int count = 0;
		for (String word : arr) {
			out[count] = filterName(word);
			count++;
		}
		return out;
	}
	
	public static boolean isBlacklistName(String name) {
				if (name.length() > HungerGamesSettings.getMaxNameLength())
			return true;
		
		ArrayList<String> bannedNames = new ArrayList<String>();
		bannedNames.addAll(Arrays.asList("list", "new", "here", "help", "?", "leave", "withdraw", "deposit", "set", "toggle", "mayor", "assistant", "kick", "add", "claim", "unclaim", "title", "outpost"));
				if (bannedNames.contains(name.toLowerCase()))
			return true;
		return !isValidName(name);
	}
	
	public static boolean isValidName(String name) {
		try {
			if (namePattern == null)
				namePattern = Pattern.compile(HungerGamesSettings.getNameCheckRegex());
			return namePattern.matcher(name).find();
		} catch (PatternSyntaxException e) {
			e.printStackTrace();
			return false;
		}
	}
	public static String filterName(String input) {
		return input.replaceAll(HungerGamesSettings.getNameFilterRegex(), "_").replaceAll(HungerGamesSettings.getNameRemoveRegex(), "");
	}
}
public final class PCGFile
{
	
	private PCGFile()
	{
	}
	
	public static boolean isPCGenCharacterFile(final File file)
	{
				if (!file.isFile())
		{
			return false;
		}
		return getWindowsSafeFilename(file).endsWith(
			Constants.EXTENSION_CHARACTER_FILE);
	}
	
	public static boolean isPCGenPartyFile(final File file)
	{
				if (!file.isFile())
		{
			return false;
		}
		return getWindowsSafeFilename(file).endsWith(
			Constants.EXTENSION_PARTY_FILE);
	}
	
	public static boolean isPCGenCampaignFile(final File file)
	{
				if (!file.isFile())
		{
			return false;
		}
		return getWindowsSafeFilename(file).endsWith(
			Constants.EXTENSION_CAMPAIGN_FILE);
	}
	
	public static boolean isPCGenCampaignFile(final URI uri)
	{
		if ("file".equals(uri.getScheme()))
		{
			return isPCGenCampaignFile(new File(uri));
		}
		return uri.getPath() != null
			&& uri.getPath().toLowerCase().endsWith(
				Constants.EXTENSION_CAMPAIGN_FILE);
	}
	
	public static boolean isPCGenListFile(final File file)
	{
				if (!file.isFile())
		{
			return false;
		}
		return getWindowsSafeFilename(file).endsWith(
			Constants.EXTENSION_LIST_FILE);
	}
	
	public static boolean isPCGenCharacterOrPartyFile(final File file)
	{
				if (file.isDirectory())
		{
			return false;
		}
		final String name = getWindowsSafeFilename(file);
		return name.endsWith(Constants.EXTENSION_CHARACTER_FILE)
			|| name.endsWith(Constants.EXTENSION_PARTY_FILE);
	}
	
	public static boolean isPCGenCharacterPartyOrCampaignFile(final File file)
	{
				if (!file.isFile())
		{
			return false;
		}
		final String name = getWindowsSafeFilename(file);
		return name.endsWith(Constants.EXTENSION_CHARACTER_FILE)
			|| name.endsWith(Constants.EXTENSION_PARTY_FILE)
			|| name.endsWith(Constants.EXTENSION_CAMPAIGN_FILE);
	}
	
	private static String getWindowsSafeFilename(final File file)
	{
		return file.getName().toLowerCase();
	}
}
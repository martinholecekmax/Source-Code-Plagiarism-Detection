public class ProjectCoinNewFeatures {
	
	protected static <T> Map<Integer, List<T>> diamondSyntax() {
		Map<Integer, List<T>> result = new HashMap<>();
		return result;
	}
	
	protected static void improvedExceptionHandling(String str,
			String methodName) {
		Method m = null;
		try {
			str.getClass().getMethod(methodName);
			m.invoke(str);
		} catch (IllegalAccessException | IllegalArgumentException
				| InvocationTargetException | NoSuchMethodException
				| SecurityException e) {
			System.err.println("Error while executing method " + methodName);
		}
	}
	
	protected static void stringsAsSwitchSelector(String dayOfTheWeek) {
		switch (dayOfTheWeek) {
		case "Monday":
		case "Tuesday":
		case "Wednesday":
		case "Thursday":
		case "Friday":
			System.out.println("Working day!!");
			break;
		case "Saturday":
		case "Sunday":
			System.out.println("Rest day!!");
			break;
		default:
			System.err.println(dayOfTheWeek + " is not a valid name for a day");
			break;
		}
	}
	
	protected static void tryWithResource(String fileName) {
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			System.out.println(br.readLine());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader consoleInputStream = new BufferedReader(
				new InputStreamReader(System.in));
		System.out.println("Introduce a day of the week");
		String line = consoleInputStream.readLine();
		ProjectCoinNewFeatures.stringsAsSwitchSelector(line);
		System.out.println("Introduce a file path: ");
		line = consoleInputStream.readLine();
		ProjectCoinNewFeatures.tryWithResource(line);
	}
}
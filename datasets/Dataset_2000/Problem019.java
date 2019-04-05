public class Problem019 {
    public static boolean isLeapYear(int year) {
	if (year % 4 == 0) {
	    if (year % 1000 == 0 && year % 400 != 0) {
		return false;
	    }
	    return true;
	}
	return false;
    }
    public static void main(String[] args) {
	long startTime = System.nanoTime();
	int year = 1900;
	int month = 1;
	int day = 1;
	int numSundays = 0;
	int counter = 1;
	while (true) {
	    if (month == 9 || month == 4 || month == 6 || month == 11) {
		if (day == 30) {
		    month++;
		    day = 1;
		} else {
		    day++;
		}
	    } else if (month == 2) {
		if (isLeapYear(year)) {
		    if (day == 29) {
			month++;
			day = 1;
		    } else {
			day++;
		    }
		} else {
		    if (day == 28) {
			month++;
			day = 1;
		    } else {
			day++;
		    }
		}
	    } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 ||
		       month == 10 || month == 12) {
		if (day == 31) {
		    if (month == 12) {
			year++;
			month = 1;
			day = 1;
		    } else {
			month++;
			day = 1;
		    }
		} else {
		    day++;
		}
	    }
	    counter++;
	    if (counter % 7 == 0 && year >= 1901 && day == 1) {
		numSundays++;
	    }
	    if (day == 31 && month == 12 && year == 2000) break;
	}
	System.out.println(numSundays);
	long endTime = System.nanoTime();
	System.out.printf("Total Time: %.6f seconds\n", ((endTime - startTime)/1000000000.0));
    }
}
package com.simen.visualizedCalendar;
import java.util.*;
import java.text.*;
/**
 * visualized calendar tool in console.
 * @author simenhuang
 *
 */
public class VisualizedCalendar {
	public static void main(String[] agrs) throws ParseException{
		System.out.println("Please enter a date in this format:");
		System.out.println("yyyy-MM-dd");
		Scanner scanner = new Scanner (System.in);
		String dateString = scanner.nextLine();
		scanner.close();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date date = format.parse(dateString);
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
		calendar.set(Calendar.DATE, 1);
		//find out how many days are in that month
		int daysInMonth = calendar.getActualMaximum(Calendar.DATE);
		int firstPrintDay = calendar.get(Calendar.DAY_OF_WEEK);		
		System.out.println("Sun" + "\t" + "Mon" + "\t" + "Tue" + "\t" + "Wed" + "\t" + "Thu" + "\t" +
				"Fri" + "\t" + "Sat" + "\t");
		int Date = 1;
		int counter = 0;
		StringBuilder dates = new StringBuilder();
		for (int i=0; i<firstPrintDay-1; i++) {
			dates.append("\t");
			counter++;
			if(counter%7 == 0)
				dates.append("\n");
		}
		for (int i=1; i<daysInMonth; i++) {
			if(i == dayOfMonth) {
				dates.append(i + "*\t");
			}
			else {
				dates.append(i + "\t");
			}
			counter++;
			if(counter%7 == 0)
				dates.append("\n");
		}
		System.out.print(dates);
	}

}

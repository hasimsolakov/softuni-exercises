package Main;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Problem24_CountWorkingDays {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        List<String> holidays = new ArrayList<>(12);
        holidays.add("01 January");
        holidays.add("03 March");
        holidays.add("01 May");
        holidays.add("06 May");
        holidays.add("24 May");
        holidays.add("06 September");
        holidays.add("22 September");
        holidays.add("01 November");
        holidays.add("24 December");
        holidays.add("25 December");
        holidays.add("26 December");
        int workingDays = 0;
            Date startDay = dateFormat.parse(scanner.nextLine());
            Date endDay = dateFormat.parse(scanner.nextLine());
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(startDay);
            DateFormat holidayCheckFormat = new SimpleDateFormat("EEEE dd MMMM", Locale.ENGLISH);
            Date currentTime;
            while((currentTime = calendar.getTime()).compareTo(endDay) != 1){
                String currentDate = holidayCheckFormat.format(currentTime);
                String [] splittedDate = currentDate.split(" ");
                String dayOfWeek = splittedDate[0];
                String date = new StringBuilder().append(splittedDate[1]).append(" ").append(splittedDate[2]).toString();
                if ((!dayOfWeek.equals("Saturday")&&!dayOfWeek.equals("Sunday")) && !holidays.contains(date)){
                   ++workingDays;
                }

                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }

            System.out.println(workingDays);
    }
}

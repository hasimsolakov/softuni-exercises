package Main;

import javafx.beans.binding.StringBinding;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Problem24_CountWorkingDays {
    public static void main(String[] args) throws ParseException {
        Scanner scanner = new Scanner(System.in);
        final DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        HashSet<String> holidays = new HashSet<>(12);
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
           final DateFormat holidayCheckFormat = new SimpleDateFormat("EEEE dd MMMM", Locale.ENGLISH);
            Date currentTime;
        final StringBuilder builder = new StringBuilder();
            while((currentTime = calendar.getTime()).compareTo(endDay) != 1){
                String currentDate = holidayCheckFormat.format(currentTime);
                String [] splittedDate = currentDate.split(" ");
                String dayOfWeek = splittedDate[0];
                builder.append(splittedDate[1]);
                builder.append(" ");
                builder.append(splittedDate[2]);
                String date = builder.toString();
                builder.delete(0,builder.length());
                if (!dayOfWeek.equals("Saturday")&&!dayOfWeek.equals("Sunday") && !holidays.contains(date)){
                   ++workingDays;
                }

                calendar.add(Calendar.DAY_OF_MONTH, 1);
            }

            System.out.println(workingDays);
    }
}

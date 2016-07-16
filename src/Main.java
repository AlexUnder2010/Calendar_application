import java.time.*;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Calendar app uses Java 8 API");
        System.out.print("Enter month: ");

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        int day = localDate.getDayOfMonth();
        int year = localDate.getYear();
        int month;
        if (sc.hasNextInt())
            month = sc.nextInt();
        else //if entered chars
            month = localDate.getMonthValue();

        LocalDate curr = LocalDate.of(year, month, day);
        System.out.print("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n");
        System.out.printf("%15s",curr.getMonth()+" ");
        System.out.printf(curr.getYear()+"\n");
        System.out.print("___________________________");
        System.out.print("\nMon Tue Wed Thu Fri "); // default color
        System.out.println((char) 27 + "[31mSat Sun" + (char) 27 + "[0m"); // red color

        int i, j, f = 1, r = 7, c = 7; // f = first day, r = rows, c = columns
        int[][] monthCalendar = new int[r][c];
        for (i = 0; i < r && f <= (curr.lengthOfMonth()); ++i)
            for (j = 0; j < c && f <= (curr.lengthOfMonth()); ++j)
                if ((i == 0 && j >= curr.get(ChronoField.DAY_OF_WEEK) - 2) || i != 0)
                    monthCalendar[i][j] = f++;

        for (i = 0; i < r; ++i, System.out.println())
            for (j = 0; j < c; ++j)
                if (monthCalendar[i][j] != 0)
                    if ( localDate.getMonth() == curr.getMonth() && monthCalendar[i][j] == curr.getDayOfMonth() ) { //check if the month equals current month
                        System.out.printf((char) 27 + "[1;34m");
                        System.out.printf("%3d ",monthCalendar[i][j]);
                        System.out.printf((char) 27 + "[0m");
                    }
                    else if (j==5 || j==6) {
                        System.out.printf((char) 27 + "[31m");
                        System.out.printf("%3d ",monthCalendar[i][j]);
                        System.out.printf((char) 27 + "[0m");
                    }
                    else
                        System.out.printf("%3d ", monthCalendar[i][j]);
                else
                    System.out.print("    "); // empty "dates" of foreign months
        System.out.print("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n");
        System.out.print("Color meanings are shown below\n");
        System.out.print((char) 27 + "[1;34m"+"Current day " +(char) 27 + "[0m"+ "|");
        System.out.print((char) 27 + "[31m"+" Day off "+(char)27 + "[0m");
        System.out.print("|"+" Workday\n");
    }
}

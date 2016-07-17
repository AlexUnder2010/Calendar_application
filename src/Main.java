import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoField;
import java.util.Date;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Calendar app uses Java 8 API");
        System.out.print("Enter month: ");

        Date date = new Date();
        LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate(); //converting from jdk 7 to 8

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

        int i, j, f = 1, r = 6, c = 7; // f = first day, r = rows, c = columns
        int[][] monthCalendar = new int[r][c]; // new array
        for (i = 0; i < r && f <= (curr.lengthOfMonth()); ++i)
            for (j = 0; j < c && f <= (curr.lengthOfMonth()); ++j)
                if ((i == 0 && j >= curr.get(ChronoField.ALIGNED_DAY_OF_WEEK_IN_YEAR)) || i != 0) //loop
                    monthCalendar[i][j] = f++;

        for (i = 0; i < r; ++i, System.out.println())
            for (j = 0; j < c; ++j)
                if (monthCalendar[i][j] != 0)
                    if (localDate.getMonth() == curr.getMonth() && monthCalendar[i][j] == curr.get(ChronoField.DAY_OF_MONTH)) { //check if the selected month equals current month
                        System.out.printf((char) 27 + "[1;34m");
                        System.out.printf("%3d ",monthCalendar[i][j]);
                        System.out.printf((char) 27 + "[0m");
                    } else if (j == 5 || j == 6) { // Sat and Sun colors
                        System.out.printf((char) 27 + "[31m");
                        System.out.printf("%3d ",monthCalendar[i][j]);
                        System.out.printf((char) 27 + "[0m");
                    }
                    else
                        System.out.printf("%3d ", monthCalendar[i][j]);
                else
                    System.out.print("    "); // empty "dates" of foreign months
        // information block stuff
        System.out.print("¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯\n");
        System.out.print("Color meanings are shown below\n");
        System.out.print((char) 27 + "[1;34m"+"Current day " +(char) 27 + "[0m"+ "|");
        System.out.print((char) 27 + "[31m"+" Day off "+(char)27 + "[0m");
        System.out.print("|"+" Workday\n");
    }
}


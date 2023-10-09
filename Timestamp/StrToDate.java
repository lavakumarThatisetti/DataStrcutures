package Timestamp;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class StrToDate {

    // Function tot convert String to Date
    public static Instant getDateFromString(String string)
    {

        // Create an Instant object
        Instant timestamp = null;

        // Parse the String to Date
        timestamp = Instant.parse(string);

        // return the converted timestamp
        return timestamp;
    }

    public static void main(String[] args)
    {
        // Get the String
        String sDate1 = "2018-10-28";

        // Get the Date from String
        try {

            Date date1=new SimpleDateFormat("yyyy-MM-dd").parse(sDate1);
            System.out.println(sDate1+"\t"+date1);

        }
        catch (Exception e) {

            System.out.println("Exception: " + e);
        }
    }
}
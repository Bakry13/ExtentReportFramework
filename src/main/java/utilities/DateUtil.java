package utilities;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class DateUtil {
    public static LocalDateTime convertPlannedStartTimeToDate(String dateS) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm", Locale.ENGLISH);
        LocalDateTime date = LocalDateTime.parse(dateS, formatter);
        return date;
    }
}

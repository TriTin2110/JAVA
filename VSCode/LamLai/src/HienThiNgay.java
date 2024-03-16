package src;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Pattern;

public class HienThiNgay {
        public static void main(String[] args) {
                LocalDateTime dateTime = LocalDateTime.now();
                DateTimeFormatter df = DateTimeFormatter.ofPattern("dd-MM-YYYY");
                String date = dateTime.format(df);
                System.out.println(date);
        }
}

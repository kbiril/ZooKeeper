package be.vdab.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RijksregisternummerValidator{
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyMMdd");

    public boolean isValid(Long rijksregisternummer, LocalDate geboortedatum) {

            return  (rijksregisternummer.toString().substring(0, 6).equals(geboortedatum.format(FORMATTER))) &&
                    (97 - (int) (Long.parseLong(rijksregisternummer.toString().substring(0, 9)) % 97)) ==
                Integer.parseInt(rijksregisternummer.toString().substring(9));

    }
}

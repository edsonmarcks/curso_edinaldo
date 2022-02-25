
package views.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class DataConverte {
    //Padrão de conversão
    private static final  DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private static final  SimpleDateFormat SIMPLE_DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");
    /***
     * Converte um Date do tipo java.util em um LocalDate
     * @param date
     * @return 
     */
    public static LocalDate getLocalDate(Date date){
        return date == null? null : LocalDate.parse(SIMPLE_DATE_FORMAT.format(date), DATE_TIME_FORMATTER);
    }
    /***
     * Converte um LocalDate em Date do tipo java.util
     * @param localDate
     * @return
     * @throws ParseException 
     */
    public static Date getDate(LocalDate localDate) throws ParseException{
        return localDate==null? null: SIMPLE_DATE_FORMAT.parse(localDate.format(DATE_TIME_FORMATTER));
    }
}

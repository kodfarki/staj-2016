package com.servlet.helper;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ParseHelper {

    public static java.sql.Date parseDate(String string){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-YYYY");
        Date parsed = null;
        java.sql.Date date;

        try {
            parsed = simpleDateFormat.parse(string);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        date = new java.sql.Date(parsed.getTime());

        if(parsed == null){
            date  = null;
        } else {
            date = new java.sql.Date(parsed.getTime());
        }

        return date;
    }

    public static boolean isInteger(String string) {
        if (string == null) {
            return false;
        }
        int length = string.length();
        if (length == 0) {
            return false;
        }
        int i=0;
        for (; i < length; i++) {
            char c = string.charAt(i);
            if (c < '0' || c > '9') {
                return false;
            }
        }
        return true;
    }


}

package com.atasoyh.appbusinesstestproject.util;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 * Created by atasoyh on 29/06/2017.
 */

public class PriceFormatterUtil {

    public static long getCurrentTimestamp() {
        return System.currentTimeMillis() / 1000;
    }

    public static String getFormattedDate(Date date, Locale current) {
        DateFormat f = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT, current);
        return f.format(date);
    }


    public static String getFormattedCurrency(Double number, Locale locale, Currency currency) {
        DecimalFormat format = (DecimalFormat) DecimalFormat.getCurrencyInstance(locale);
        format.setCurrency(currency);
        format.setDecimalSeparatorAlwaysShown(true);
        return format.format(number);
    }
}


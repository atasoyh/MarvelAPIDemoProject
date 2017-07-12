package com.atasoyh.appbusinesstestproject.util;

import org.junit.Assert;

import java.util.Currency;
import java.util.Date;
import java.util.Locale;

/**
 * Created by atasoyh on 12/07/2017.
 */
public class PriceFormatterUtilTest {

    @org.junit.Test
    public void formattedAsLocaleDate() throws Exception {
        Locale usLocale = Locale.US;
        Locale ukLocale = Locale.UK;
        PriceFormatterUtil util = new PriceFormatterUtil();
        Date date = new Date();
        String usDate = util.getFormattedDate(date, usLocale);
        String ukDate = util.getFormattedDate(date, ukLocale);
        Assert.assertNotEquals(usDate, ukDate);
    }

    @org.junit.Test
    public void formattedCurrency_SybmolTest() throws Exception {
        Locale usLocale = Locale.US;
        Locale ukLocale = Locale.UK;
        PriceFormatterUtil util = new PriceFormatterUtil();
        String usValue = util.getFormattedCurrency(1000000.00, usLocale, Currency.getInstance(Locale.US));
        String ukValue = util.getFormattedCurrency(1000000.00, ukLocale, Currency.getInstance(Locale.UK));
        Assert.assertNotEquals(usValue, ukValue);

    }

    @org.junit.Test
    public void formattedCurrency_SeperatorTest() throws Exception {
        Locale usLocale = Locale.US;
        Locale grLocale = Locale.GERMAN;
        PriceFormatterUtil util = new PriceFormatterUtil();
        String usValue = util.getFormattedCurrency(1000000.00, usLocale, Currency.getInstance(Locale.US));
        String grValue = util.getFormattedCurrency(1000000.00, grLocale, Currency.getInstance(Locale.US));
        Assert.assertNotEquals(usValue, grValue);

    }
}
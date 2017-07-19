package com.atasoyh.marvelapidemoproject.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by atasoyh on 12/07/2017.
 */
public class TextUtilsTest {
    @Test
    public void ifValueIsNull() throws Exception {
        String value=null;
        assertTrue(TextUtils.isEmpty(value));
    }
    @Test
    public void ifValueIsEmpty() throws Exception {
        String value="";
        assertTrue(TextUtils.isEmpty(value));
    }

    @Test
    public void ifValueIsNotEmpty() throws Exception {
        String value="asd";
        assertFalse(TextUtils.isEmpty(value));
    }
}
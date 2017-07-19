package com.atasoyh.marvelapidemoproject.util;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by atasoyh on 12/07/2017.
 */
public class HashGeneratorTest {

    String privateKey="e0dd7b04026a005be73751265dec6520bece5c02";
    String publicKey="18d148ca86bd623d2b2b9acdc736e034";
    String publicKeyWrong="18d148ca86bd623d2b2b9acdc736e123";
    long timestamp=1499871127;
    String expected="e1caf90ce91a5b3bba48c9cc1af3b0b7";

    @Test
    public void testHash(){
        assertTrue(HashGenerator.generate(timestamp,privateKey,publicKey).equals(expected));
    }

    @Test
    public void testHashWrong(){
        assertFalse(HashGenerator.generate(timestamp,privateKey,publicKeyWrong).equals(expected));
    }
}
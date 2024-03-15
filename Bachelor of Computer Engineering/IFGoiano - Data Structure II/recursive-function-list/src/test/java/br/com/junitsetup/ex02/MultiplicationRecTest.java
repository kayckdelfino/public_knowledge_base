package br.com.junitsetup.ex02;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class MultiplicationRecTest {
    @Test
    public void successMultiplication() {
        assertEquals(48, MultiplicationRec.calc(6, 8));
        assertEquals(30, MultiplicationRec.calc(10, 3));

        assertEquals(0, MultiplicationRec.calc(0, 10));
        assertEquals(0, MultiplicationRec.calc(10, 0));
        
        assertEquals(-30, MultiplicationRec.calc(-10, 3));
        assertEquals(-30, MultiplicationRec.calc(10, -3));
        assertEquals(30, MultiplicationRec.calc(-10, -3));
    }
}
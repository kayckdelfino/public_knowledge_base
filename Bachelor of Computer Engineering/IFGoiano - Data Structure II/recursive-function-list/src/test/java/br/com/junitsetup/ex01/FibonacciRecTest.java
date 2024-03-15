package br.com.junitsetup.ex01;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class FibonacciRecTest {
    @Test
    public void successFibonacci() {
        assertEquals(1, FibonacciRec.calc(0));
        assertEquals(1, FibonacciRec.calc(1));
        assertEquals(2, FibonacciRec.calc(2));
        assertEquals(3, FibonacciRec.calc(3));
        assertEquals(5, FibonacciRec.calc(4));
        assertEquals(8, FibonacciRec.calc(5));
        assertEquals(13, FibonacciRec.calc(6));
        assertEquals(21, FibonacciRec.calc(7));
        assertEquals(34, FibonacciRec.calc(8));
        assertEquals(55, FibonacciRec.calc(9));
        assertEquals(89, FibonacciRec.calc(10));
    }

    @Test
    public void failFibonacci() {
        assertThrows(IllegalArgumentException.class, () -> FibonacciRec.calc(-1));
        assertThrows(IllegalArgumentException.class, () -> FibonacciRec.calc(-5));
        assertThrows(IllegalArgumentException.class, () -> FibonacciRec.calc(-10));
    }
}
package br.com.junitsetup.ex04;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PowerRecTest {
    @Test
    public void successPower() {
        assertEquals(9, PowerRec.calc(3, 2));
        assertEquals(1024, PowerRec.calc(2, 10));

        assertEquals(1, PowerRec.calc(10, 0));
        assertEquals(0, PowerRec.calc(0, 10));

        assertEquals(0.125, PowerRec.calc(2, -3));
        assertEquals(-8, PowerRec.calc(-2, 3));
    }
}
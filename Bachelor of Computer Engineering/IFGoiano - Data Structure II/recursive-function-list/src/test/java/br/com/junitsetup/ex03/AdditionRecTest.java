package br.com.junitsetup.ex03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class AdditionRecTest {
    @Test
    public void successAddition() {
        assertEquals(5, AdditionRec.calc(3, 2));
        assertEquals(10, AdditionRec.calc(10, 0));
        assertEquals(0, AdditionRec.calc(0, 0));
        assertEquals(10, AdditionRec.calc(0, 10));
        assertEquals(10, AdditionRec.calc(10, 0));
        assertEquals(20, AdditionRec.calc(10, 10));
    }
}
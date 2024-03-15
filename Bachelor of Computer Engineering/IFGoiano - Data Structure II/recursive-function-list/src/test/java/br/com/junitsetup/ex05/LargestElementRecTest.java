package br.com.junitsetup.ex05;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class LargestElementRecTest {
    
    @Test
    public void successLargestElement() {
        int[] vetor1 = {3, 7, 2, 10, 5};
        assertEquals(10, LargestElementRec.calc(vetor1, 0, vetor1[0]));

        int[] vetor2 = {-5, -10, -3, -1};
        assertEquals(-1, LargestElementRec.calc(vetor2, 0, vetor2[0]));

        int[] vetor3 = {100};
        assertEquals(100, LargestElementRec.calc(vetor3, 0, vetor3[0]));
    }

    @Test
    public void failLargestElement() {
        int[] vetor = {};
        assertThrows(ArrayIndexOutOfBoundsException.class, () -> LargestElementRec.calc(vetor, 0, vetor[0]));
    }
}
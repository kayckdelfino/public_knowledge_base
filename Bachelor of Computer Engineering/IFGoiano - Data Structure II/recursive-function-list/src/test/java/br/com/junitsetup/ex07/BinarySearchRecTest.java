package br.com.junitsetup.ex07;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class BinarySearchRecTest {
    @Test
    public void successBinarySearch() {
        int[] vetor = {2, 5, 8, 12, 16, 23, 38, 56, 72, 91};

        assertEquals(5, BinarySearchRec.search(vetor, 23, 0, vetor.length - 1));
        assertEquals(0, BinarySearchRec.search(vetor, 2, 0, vetor.length - 1));
        assertEquals(9, BinarySearchRec.search(vetor, 91, 0, vetor.length - 1));

        assertEquals(-1, BinarySearchRec.search(vetor, 20, 0, vetor.length - 1));
    }
}
package br.com.junitsetup.ex06;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringReversalRecTest {
    @Test
    public void successStringReversal() {
        assertEquals("fedcba", StringReversalRec.reverse("abcdef"));
        assertEquals("4321", StringReversalRec.reverse("1234"));
        assertEquals("54321", StringReversalRec.reverse("12345"));
        assertEquals("7654321", StringReversalRec.reverse("1234567"));
        assertEquals("", StringReversalRec.reverse(""));
        assertEquals("a", StringReversalRec.reverse("a"));
        assertEquals("racecar", StringReversalRec.reverse("racecar"));
    }
}
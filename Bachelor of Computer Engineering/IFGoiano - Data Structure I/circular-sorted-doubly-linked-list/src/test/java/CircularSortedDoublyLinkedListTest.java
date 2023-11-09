import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.listproject.CircularSortedDoublyLinkedList;

public class CircularSortedDoublyLinkedListTest {

    private CircularSortedDoublyLinkedList<Integer> list;

    @BeforeEach
    public void setup() {
        list = new CircularSortedDoublyLinkedList<>();
    }

    @Test
    @DisplayName("Empty list")
    public void testEmptyList() {
        CircularSortedDoublyLinkedList<Integer> list = new CircularSortedDoublyLinkedList<>();

        assertEquals("List is empty", list.listContent());
    }

    @Test
    @DisplayName("Insert action")
    public void testInsert() {
        list.insert(5);
        list.insert(3);
        list.insert(7);
        list.insert(1);

        assertEquals("1 -> 3 -> 5 -> 7 -> (circular)", list.listContent());
    }

    @Test
    @DisplayName("Remove action")
    public void testRemove() {
        list.insert(5);
        list.insert(3);
        list.insert(7);
        list.insert(1);

        assertTrue(list.remove(5));
        assertFalse(list.remove(2));

        assertEquals("1 -> 3 -> 7 -> (circular)", list.listContent());

        list.remove(1);
        list.remove(3);
        list.remove(7);

        assertEquals("List is empty", list.listContent());
    }

    @Test
    @DisplayName("Find action")
    public void testFind() {
        list.insert(5);
        list.insert(3);
        list.insert(7);
        list.insert(1);

        assertEquals(Integer.valueOf(3), list.find(3));
        assertNull(list.find(6));
    }

    @Test
    @DisplayName("Clear action")
    public void testClear() {
        list.insert(5);
        list.insert(3);
        list.clear();

        assertNull(list.find(5));
        assertEquals("List is empty", list.listContent());
    }

    @Test
    @DisplayName("List Content action")
    public void testListContent() {
        list.insert(5);
        list.insert(3);
        list.insert(7);

        assertEquals("3 -> 5 -> 7 -> (circular)", list.listContent());
    }

    @Test
    @DisplayName("List Content Reverse action")
    public void testListContentReverse() {
        list.insert(5);
        list.insert(3);
        list.insert(7);

        assertEquals("7 -> 5 -> 3 -> (circular)", list.listContentReverse());
    }

    @Test
    @DisplayName("Navigation action")
    public void testNavigation() {
        list.insert(5);
        list.insert(3);
        list.insert(7);

        list.clearNavigation();
        assertEquals(Integer.valueOf(5), list.getNextElement());
        assertEquals(Integer.valueOf(7), list.getNextElement());
        assertEquals(Integer.valueOf(3), list.getNextElement());
        assertEquals(Integer.valueOf(7), list.getPreviousElement());
    }

    @Test
    @DisplayName("Get Next Element action")
    public void testGetNextElement() {
        list.insert(5);
        list.insert(3);
        list.insert(7);

        assertEquals(3, list.getNextElement());
        assertEquals(5, list.getNextElement());
        assertEquals(7, list.getNextElement());

        list.clearNavigation();

        assertEquals(5, list.getNextElement());
    }

    @Test
    @DisplayName("Get Previous Element action")
    public void testGetPreviousElement() {
        list.insert(5);
        list.insert(3);
        list.insert(7);

        assertEquals(7, list.getPreviousElement());
        assertEquals(5, list.getPreviousElement());
        assertEquals(3, list.getPreviousElement());

        list.clearNavigation();

        assertEquals(7, list.getPreviousElement());
    }
}
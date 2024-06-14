import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

import org.junit.jupiter.api.Test;

import com.project.Graph;

public class GraphTest {

    @Test
    void createGraphTest() {
        Graph<Integer> graph = new Graph<Integer>();

        assertNull(graph.toString());

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);

        assertEquals("1{ } 2{ } 3{ } 4{ }", graph.toString());
    
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        assertEquals("1{ 2 4 } 2{ 1 3 } 3{ 2 4 } 4{ 3 1 }", graph.toString());
    }

    @Test
    void createDirectedGraphTest() {
        Graph<Integer> directedGraph = new Graph<Integer>(false, true);

        assertNull(directedGraph.toString());

        directedGraph.addVertex(1);
        directedGraph.addVertex(2);
        directedGraph.addVertex(3);
        directedGraph.addVertex(4);

        assertEquals("1{ } 2{ } 3{ } 4{ }", directedGraph.toString());
    
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 4);
        directedGraph.addEdge(4, 1);

        assertEquals("1{ 2 } 2{ 3 } 3{ 4 } 4{ 1 }", directedGraph.toString());
    }

    @Test
    void createWeightedGraphTest() {
        Graph<Integer> weightedGraph = new Graph<Integer>(true, false);

        assertNull(weightedGraph.toString());

        weightedGraph.addVertex(1);
        weightedGraph.addVertex(2);
        weightedGraph.addVertex(3);
        weightedGraph.addVertex(4);

        assertEquals("1{ } 2{ } 3{ } 4{ }", weightedGraph.toString());
    
        weightedGraph.addEdge(1, 2, 5);
        weightedGraph.addEdge(2, 3, 10);
        weightedGraph.addEdge(3, 4, 15);
        weightedGraph.addEdge(4, 1, 20);

        assertEquals("1{ 2<5.0> 4<20.0> } 2{ 1<5.0> 3<10.0> } 3{ 2<10.0> 4<15.0> } 4{ 3<15.0> 1<20.0> }", weightedGraph.toString());
    }

    @Test
    void countGraphLoopsTest() {
        Graph<Integer> graph = new Graph<Integer>();

        graph.addVertex(1);
        graph.addVertex(2);

        graph.addEdge(1, 1);
        
        assertEquals(1, graph.countLoops());

        graph.addEdge(2, 2);

        assertEquals(2, graph.countLoops());
    }

    @Test
    void countDirectedGraphLoopsTest() {
        Graph<Integer> directedGraph = new Graph<Integer>(false, true);

        directedGraph.addVertex(1);
        directedGraph.addVertex(2);

        directedGraph.addEdge(1, 1);
        
        assertEquals(1, directedGraph.countLoops());

        directedGraph.addEdge(2, 2);

        assertEquals(2, directedGraph.countLoops());
    }

    @Test
    void countGraphMultipleEdgesTest() {
        Graph<Integer> graph = new Graph<Integer>();

        graph.addVertex(1);
        graph.addVertex(2);

        graph.addEdge(1, 2);
        graph.addEdge(1, 2);

        assertEquals(1, graph.countMultipleEdges());

        graph.addEdge(2, 1);

        assertEquals(2, graph.countMultipleEdges());
    }

    @Test
    void countDirectedGraphMultipleEdgesTest() {
        Graph<Integer> directedGraph = new Graph<Integer>(false, true);

        directedGraph.addVertex(1);
        directedGraph.addVertex(2);

        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(1, 2);

        assertEquals(1, directedGraph.countMultipleEdges());

        directedGraph.addEdge(2, 1);

        assertEquals(1, directedGraph.countMultipleEdges());

        directedGraph.addEdge(2, 1);

        assertEquals(2, directedGraph.countMultipleEdges());
    }

    @Test
    void isGraphCompleteTest() {
        Graph<Integer> graph = new Graph<Integer>();

        assertFalse(graph.isComplete());
        
        graph.addVertex(1);
        assertTrue(graph.isComplete());
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
    
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);

        assertFalse(graph.isComplete());

        graph.addEdge(1, 3);
        graph.addEdge(2, 4);

        assertTrue(graph.isComplete());
    }

    @Test
    void isDirectedGraphCompleteTest() {
        Graph<Integer> directedGraph = new Graph<Integer>(false, true);

        assertFalse(directedGraph.isComplete());
        
        directedGraph.addVertex(1);
        assertTrue(directedGraph.isComplete());
        directedGraph.addVertex(2);
        directedGraph.addVertex(3);
    
        directedGraph.addEdge(1, 2);
        directedGraph.addEdge(2, 1);
        directedGraph.addEdge(1, 3);
        directedGraph.addEdge(3, 1);

        assertFalse(directedGraph.isComplete());

        directedGraph.addEdge(2, 3);
        directedGraph.addEdge(3, 2);

        assertTrue(directedGraph.isComplete());
    }

    @Test
    void getGraphDegreeTest() {
        Graph<Integer> graph = new Graph<>();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);

        assertEquals(0, graph.getDegree(1));
    
        graph.addEdge(1, 2);

        assertEquals(1, graph.getDegree(1));

        graph.addEdge(2, 3);
        graph.addEdge(3, 1);

        assertEquals(2, graph.getDegree(1));
    }

    @Test
    void getDirectedGraphDegreeTest() {
        Graph<Integer> directedGraph = new Graph<>(false, true);

        directedGraph.addVertex(1);
        directedGraph.addVertex(2);
        directedGraph.addVertex(3);

        assertEquals(0, directedGraph.getDegree(1));
    
        directedGraph.addEdge(1, 2);

        assertEquals(1, directedGraph.getDegree(1));
        assertEquals(1, directedGraph.getDegree(2));

        directedGraph.addEdge(2, 3);

        assertEquals(1, directedGraph.getDegree(1));
        assertEquals(2, directedGraph.getDegree(2));
        assertEquals(1, directedGraph.getDegree(3));
    }

    @Test
    void getGraphPathTest() {
        Graph<Integer> graph = new Graph<>();

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);
    
        graph.addEdge(1, 3);
        graph.addEdge(3, 2);
        graph.addEdge(3, 4);
        graph.addEdge(3, 5);
        graph.addEdge(2, 5);
        graph.addEdge(4, 6);
        graph.addEdge(5, 6);

        assertEquals("1 -> 3 -> 5", graph.getPath(1, 5));
    }

    @Test
    void getWeightedGraphPathTest() {
        Graph<Integer> weightedGraph = new Graph<>(true, false);

        weightedGraph.addVertex(1);
        weightedGraph.addVertex(2);
        weightedGraph.addVertex(3);
        weightedGraph.addVertex(4);
        weightedGraph.addVertex(5);
        weightedGraph.addVertex(6);

        weightedGraph.addEdge(1, 3, 2);
        weightedGraph.addEdge(3, 2, 2);
        weightedGraph.addEdge(3, 4, 1);
        weightedGraph.addEdge(3, 5, 4);
        weightedGraph.addEdge(2, 5, 3);
        weightedGraph.addEdge(4, 6, 2);
        weightedGraph.addEdge(5, 6, 1);

        weightedGraph.addEdge(1, 6, 10);

        assertEquals("1 -> 3 -> 4 -> 6", weightedGraph.getPath(1, 6));
    }

    @Test
    void getDirectedGraphPathTest() {
        Graph<Integer> graph = new Graph<>(false, true);

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(1, 3);
        graph.addEdge(2, 3);
        graph.addEdge(2, 5);
        graph.addEdge(3, 5);
        graph.addEdge(4, 3);
        graph.addEdge(4, 6);
        graph.addEdge(6, 5);

        assertEquals("1 -> 3 -> 5", graph.getPath(1, 5));
    }

    @Test
    void getWeightedDirectedGraphPathTest() {
        Graph<Integer> graph = new Graph<>(true, true);

        graph.addVertex(1);
        graph.addVertex(2);
        graph.addVertex(3);
        graph.addVertex(4);
        graph.addVertex(5);
        graph.addVertex(6);

        graph.addEdge(1, 3, 2);
        graph.addEdge(3, 2, 2);
        graph.addEdge(3, 4, 1);
        graph.addEdge(3, 5, 4);
        graph.addEdge(2, 5, 3);
        graph.addEdge(4, 6, 2);
        graph.addEdge(5, 6, 1);

        graph.addEdge(1, 5, 10);

        assertEquals("1 -> 3 -> 5", graph.getPath(1, 5));
    }
}
package TestAlgoritnWidth;

public class Runner {
    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addVertex('M'); // 0
        graph.addVertex('L'); // 1
        graph.addVertex('B'); // 2
        graph.addVertex('C'); // 3
        graph.addVertex('O'); // 4
        graph.addVertex('A'); // 5
        graph.addVertex('G'); // 6
        graph.addVertex('P'); // 7
        graph.addVertex('D'); // 8
        graph.addVertex('V'); // 9
        graph.addVertex('K'); // 10


        graph.addEdge(5,2);
        graph.addEdge(2,3);
        graph.addEdge(3,8);
        graph.addEdge(3,6);
        graph.addEdge(2,4);
        graph.addEdge(4,10);
        graph.addEdge(10,7);
        graph.addEdge(10,1);
        graph.addEdge(10,2);
        graph.addEdge(10,3);



        graph.passInWidth(2);
        graph.checkRoad(6);
    }
}

package TestAlgoritnWidth;

import java.util.Arrays;

public class Graph {
    public int maxN = 11;
    public int [][] matrix;
    Vertex[] vertexList;
    public int curN;
    private MyStack myStack = new MyStack();
    private MyQueue myQueue = new MyQueue();
    private int [] dist = new int[maxN];
    private int [] from = new int[maxN];

    public Graph() {
        vertexList = new Vertex[maxN];
        matrix = new int [maxN][maxN];
        curN = 0;
    }
    public void addVertex(char name) {
        vertexList[curN++] = new Vertex(name);
    }
    public void addEdge(int start, int end) {
        matrix[start][end] = 1;
        matrix[end][start] = 1;

    }
    public int check(int v){
        for(int i = 0; i < curN; i++){
            if(matrix[i][v] == 1 && vertexList[i].isVisited == false){
                return i;
            }
        }

        return -1;
    }
    private void fillDistGraph(){
        Arrays.fill(dist,10000);
    }

    public void passInDeep(int index){

        System.out.println(vertexList[index].name);
        vertexList[index].isVisited = true;
        myStack.push(index);

        while(!myStack.isEmpty()){
            int neigh = check(myStack.peek());

            if(neigh == -1){
                neigh = myStack.pop();
            }else {
                System.out.println(vertexList[neigh].name);
                vertexList[neigh].isVisited = true;
                myStack.push(neigh);
            }
        }
        for(int i = 0; i < curN; i++){
            vertexList[i].isVisited = false;
        }

    }

    public void passInWidth(int index){
        fillDistGraph();

        System.out.println(vertexList[index].name);
        vertexList[index].isVisited = true;
        dist[index] = 0;
        from[index] = -1;
        myQueue.insert(index);

        int vertex;

        while(!myQueue.isEmpty()){
            int temp = myQueue.remove();


            while ((vertex = check(temp)) != -1){
                System.out.println(vertexList[vertex].name);
                vertexList[vertex].isVisited = true;
                dist[vertex] = dist[temp] + 1;
                from[vertex] = temp;
                myQueue.insert(vertex);
            }
        }
        for (int i = 0;i < curN;++i){
            System.out.println(vertexList[i].name + " " + dist[i]);
        }

        for(int i = 0;i < curN; i++){
            vertexList[i].isVisited = false;
        }

    }
    public void checkRoad(int finish){
        System.out.println("\n===========================\n");
        while (from[finish] != -1) {

            System.out.println(from[finish] + " " + vertexList[from[finish]].name);
            finish = from[finish];
        }
    }

}

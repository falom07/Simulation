package TestAlgoritnWidth;

import java.util.Arrays;

public class Graph {
    public int maxN = 11;
    public int [][] matrix;
    Vertexs[] vertexsList;
    public int curN;
    private MyStack myStack = new MyStack();
    private MyQueue myQueue = new MyQueue();
    private int [] dist = new int[maxN];
    private int [] from = new int[maxN];

    public Graph() {
        vertexsList = new Vertexs[maxN];
        matrix = new int [maxN][maxN];
        curN = 0;
    }
    public void addVertex(char name) {
        vertexsList[curN++] = new Vertexs(name);
    }
    public void addEdge(int start, int end) {
        matrix[start][end] = 1;
        matrix[end][start] = 1;

    }
    public int check(int v){
        for(int i = 0; i < curN; i++){
            if(matrix[i][v] == 1 && vertexsList[i].isVisited == false){
                return i;
            }
        }

        return -1;
    }
    private void fillDistGraph(){
        Arrays.fill(dist,10000);
    }

    public void passInDeep(int index){

        System.out.println(vertexsList[index].name);
        vertexsList[index].isVisited = true;
        myStack.push(index);

        while(!myStack.isEmpty()){
            int neigh = check(myStack.peek());

            if(neigh == -1){
                neigh = myStack.pop();
            }else {
                System.out.println(vertexsList[neigh].name);
                vertexsList[neigh].isVisited = true;
                myStack.push(neigh);
            }
        }
        for(int i = 0; i < curN; i++){
            vertexsList[i].isVisited = false;
        }

    }

    public void passInWidth(int index){
        fillDistGraph();

        System.out.println(vertexsList[index].name);
        vertexsList[index].isVisited = true;
        dist[index] = 0;
        from[index] = -1;
        myQueue.insert(index);

        int vertex;

        while(!myQueue.isEmpty()){
            int temp = myQueue.remove();


            while ((vertex = check(temp)) != -1){
                System.out.println(vertexsList[vertex].name);
                vertexsList[vertex].isVisited = true;
                dist[vertex] = dist[temp] + 1;
                from[vertex] = temp;
                myQueue.insert(vertex);
            }
        }
        for (int i = 0;i < curN;++i){
            System.out.println(vertexsList[i].name + " " + dist[i]);
        }
        for (int j = 0; j < vertexsList.length; ++j){
            for (int i = 0; i < vertexsList.length; ++i) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0;i < curN; i++){
            vertexsList[i].isVisited = false;
        }

    }
    public void checkRoad(int finish){
        System.out.println("\n===========================\n");
        while (from[finish] != -1) {

            System.out.println(from[finish] + " " + vertexsList[from[finish]].name);
            finish = from[finish];
        }
    }

}

package AlgoritmForFindWay;

public class AlgoritmForFindingWay { //todo delete all print
    public int maxN = 101;
    public int [][] matrix;
    Vertex[] vertexsList;
    public int curN;
    private Queue queue = new Queue();
    private int [] from = new int[maxN];

    public AlgoritmForFindingWay() {
        vertexsList = new Vertex[maxN];
        matrix = new int [maxN][maxN]; //todo add matrix
        curN = 0;
        addVertexes();
    }
    public void addVertexes() {
        for (int i = 0; i < maxN; ++i) {
            vertexsList[curN++] = new Vertex();
        }
    }

    public Integer check(int v){
                //todo v
            v
            int x = 23;
            int y = 3;

            if(x - 1 != -1){
                System.out.println(matrix[x-1][y]);
                int res = Integer.parseInt((x-1) + "" + y);
                if(matrix[x-1][y] == 0 && vertexsList[res].isVisited == false){ // unvisited and is empty
                    return res;
                }
            }
            if(x + 1 != 10){
                System.out.println(matrix[x+1][y]);
                int res = Integer.parseInt((x+1) + "" + y);
                if(matrix[x+1][y] == 0 && vertexsList[res].isVisited == false){ // unvisited and is empty
                    return res;
                }
            }
            if(y - 1 != -1){
                System.out.println(matrix[x][y-1]);
                int res = Integer.parseInt(x + "" + (y-1));
                if(matrix[x][y-1] == 0 && vertexsList[res].isVisited == false){ // unvisited and is empty
                    return res;
                }
            }
            if(y + 1 != 10){
                System.out.println(matrix[x][y+1]);
                int res = Integer.parseInt(x + "" + (y+1));
                if(matrix[x][y+1] == 0 && vertexsList[res].isVisited == false){ // unvisited and is empty
                    return res;
                }
            }
        return -1;
    }




    public int passInWidth(int index){
        vertexsList[index].isVisited = true;
        from[index] = -1;
        queue.insert(index);

        int vertex;

        while(!queue.isEmpty()){
            int temp = queue.remove();


            while ((vertex = check(temp)) != -1){

                vertexsList[vertex].isVisited = true;
                from[vertex] = temp;
                queue.insert(vertex);
            }
        }

        for (int j = 0; j < vertexsList.length; ++j){
            for (int i = 0; i < vertexsList.length; ++i) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        int nextMovePosition = from[index];   //todo right
        for(int i = 0;i < curN; i++){
            vertexsList[i].isVisited = false;
//            from[i] = i; todo normal
        }
        return 0;

    }
    public void checkRoad(int finish){ //todo delete after testing
        System.out.println("\n===========================\n");
        while (from[finish] != -1) {

//            System.out.println(from[finish] + " " + vertexsList[from[finish]].name);
            finish = from[finish];
        }
    }
}

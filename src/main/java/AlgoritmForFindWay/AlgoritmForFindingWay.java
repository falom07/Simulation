package AlgoritmForFindWay;

public class AlgoritmForFindingWay { //todo delete all print
    public int maxN = 101;
    public int [][] matrix;
    Vertex[] vertexsList;
    public int curN;
    private final Queue queue = new Queue();
    private final int [] from = new int[maxN];
    private boolean isClose = true;
    private int positionSacrifice;
    private int goalSacrifice;

    public AlgoritmForFindingWay(int [][] map) {
        vertexsList = new Vertex[maxN];
        matrix = map;
        curN = 0;
        addVertexes();
    }
    public void addVertexes() {
        for (int i = 0; i < maxN; ++i) {
            vertexsList[curN++] = new Vertex();
        }
    }

    public Integer check(int v){
            int x;
            int y;
            if (v <= 9) {
                x = 0;
                y = v;
            } else {
                y = v % 10;
                x = (int) ((v - y) * 0.1);
            }

            if(x - 1 != -1){
                int res = Integer.parseInt((x-1) + "" + y);
                if(matrix[x-1][y] == goalSacrifice){
                    positionSacrifice = res;
                    return res;
                }else if(matrix[x-1][y] == 0 && !vertexsList[res].isVisited){    // unvisited and is empty(0 mean that field is empty)
                    return res;
                }
            }
            if(x + 1 != 10){
                int res = Integer.parseInt((x + 1) + "" + y);
                if(matrix[x + 1][y] == goalSacrifice){
                    positionSacrifice = res;
                    return res;
                }
                if(matrix[x + 1][y] == 0 && !vertexsList[res].isVisited){
                    return res;
                }
            }
            if(y - 1 != -1){
                int res = Integer.parseInt(x + "" + (y-1));
                if(matrix[x][y - 1] == goalSacrifice){
                    positionSacrifice = res;
                    return res;
                }
                if(matrix[x][y - 1] == 0 && !vertexsList[res].isVisited){
                    return res;
                }
            }
            if(y + 1 != 10){
                int res = Integer.parseInt(x + "" + (y+1));
                if(matrix[x][y + 1] == goalSacrifice){
                    positionSacrifice = res;
                    return res;
                }
                if(matrix[x][y + 1] == 0 && !vertexsList[res].isVisited){ // unvisited and is empty
                    return res;
                }
            }
        return -1;
    }




    public int passInWidth(int index,int goalSacrifice){
        this.goalSacrifice = goalSacrifice;
        vertexsList[index].isVisited = true;
        from[index] = -1;
        isClose = true;
        queue.insert(index);


        int vertex;

        while(!queue.isEmpty()){
            int temp = queue.remove();


            while ((vertex = check(temp)) != -1){
                System.out.println(vertex);
                from[vertex] = temp;
                if(positionSacrifice != 0){
                    break;
                }
                vertexsList[vertex].isVisited = true;
                queue.insert(vertex);
            }

            if (positionSacrifice != 0){
                break;
            }
            isClose = false;
        }
        cleanVertexList();
        return  getNextField(positionSacrifice);

    }
    private void cleanVertexList(){
        for(int i = 0;i < curN; i++){
            vertexsList[i].isVisited = false;
        }
    }

    public int getNextField(int finish){
        int result = -1;
        while (from[finish] != -1) {
            result = finish;
            finish = from[finish];
        }
        if(isClose) {
            return 0;
        }
        return result;

    }
}

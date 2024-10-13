package AlgoritmForFindWay;

import java.sql.SQLOutput;

public class AlgoritmForFindingWay { //todo delete all print
    public int maxN = 101;
    public int [][] matrix;
    Vertex[] vertexsList;
    public int curN;
    private final int [] from = new int[maxN];
    private boolean isClose;
    private int positionSacrifice;
    private int positionSacrificeForEat;
    private int goalSacrifice;

    public AlgoritmForFindingWay() {
        vertexsList = new Vertex[maxN];
        isClose = true;
        curN = 0;
        addVertexes();
    }
    private void addVertexes() { //create list for know what are already visite
        for (int i = 0; i < maxN; ++i) {
            vertexsList[curN++] = new Vertex();
        }
    }

    public Integer check(int v){ //check if we have not visited field close us
            int x;
            int y;
            if (v <= 9) { //divide our pos for x and y
                y = v;
                x = 0;
            } else {

                y = v % 10;
                x = (int) ((v - y) * 0.1);
            }

            if(x - 1 != -1){ //check neighbors corner if we have them
                int res = Integer.parseInt((x-1) + "" + y);
                if(matrix[x-1][y] == goalSacrifice){ //if we find our sacrifice we break search and return position or road for move
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




    public int passInWidth(int index,int goalSacrifice,int [][]map){
        matrix = map;
        this.goalSacrifice = goalSacrifice;
        Queue queue = new Queue();
        vertexsList[index].isVisited = true;
        from[index] = -1;


        queue.insert(index);


        int vertex;

        while(!queue.isEmpty()){ //search while we have element in queue
            int temp = queue.remove();
            int zero = 0;


            while ((vertex = check(temp)) != -1){


                from[vertex] = temp;
                if(positionSacrifice != 0){ //if we find sacrifice return pos or wau for achieve him
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

        return  getNextField(positionSacrifice);

    }
    private void cleanAllForNextPassInWidth(){ //cleat all for next pass in width
        positionSacrificeForEat = positionSacrifice;
        positionSacrifice = 0;
        isClose = true;
        for(int i = 0;i < curN; i++){
            vertexsList[i].isVisited = false;
            from[i] = 0;
        }

    }

    public int getNextField(int finish){ //return 100 if we can not move,0 if we can shoot,and position where we should move
        int result = -1;

        while (from[finish] != -1) {
            result = finish;
            finish = from[finish];
            if(result == 0){
                result = 100;
                break;
            }
        }


        if(isClose) {
            result = 0;
        }
        cleanAllForNextPassInWidth();
        return result;
    }
    public int getPositionSacrificeForEat(){ //take position for eat
        return positionSacrificeForEat;
    }
}

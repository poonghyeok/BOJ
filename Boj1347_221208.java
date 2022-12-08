import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boj1347_221208 {


    private BufferedReader br;
    private int len;
    private String doc;
    private static final int NORTH = 0;
    private static final int EAST = 1;
    private static final int SOUTH = 2;
    private static final int WEST = 3;

    public int getNextDirection(int curDirection, char turn){
        int nextDirection = curDirection;
//        System.out.println("curDirection : " + nextDirection);
        if(turn == 'R'){
            if(nextDirection == WEST){
                nextDirection = NORTH;
            }else{
                nextDirection++;
            }
        }else if(turn == 'L'){
            if(nextDirection == NORTH){
                nextDirection = WEST;
            }else{
                nextDirection--;
            }
        }

        return nextDirection;
    }

    public int[] getNextIdx(int[] curIdx, int direction){
        int[] nextIdx = curIdx;
        switch (direction){
            case NORTH :
                nextIdx[1] = nextIdx[1]+1;
                break;
            case EAST :
                nextIdx[0] = nextIdx[0]+1;
                break;
            case SOUTH :
                nextIdx[1] = nextIdx[1]-1;
                break;
            case WEST :
                nextIdx[0] = nextIdx[0]-1;
                break;

        }

        return nextIdx;
    }

    public void renewMaxIdx(int[] curIdx, int curDirection, Map<String, Integer> maxMap){
        if(curDirection == NORTH){
            int curIdxY = curIdx[1];
            int curMaxIdxY = maxMap.get("yPositive");
            if(curMaxIdxY < curIdxY){
                maxMap.put("yPositive", curIdxY);
            }
        }else if(curDirection == SOUTH){
            int curIdxY = curIdx[1];
            int curMinIdxY = maxMap.get("yNegative");
            if(curMinIdxY > curIdxY){
                maxMap.put("yNegative", curIdxY);
            }
        }else if(curDirection == EAST){
            int curIdxX = curIdx[0];
            int curMaxIdxX = maxMap.get("xPositive");
            if(curMaxIdxX < curIdxX){
                maxMap.put("xPositive", curIdxX);
            }
        }else if(curDirection == WEST){
            int curIdxX = curIdx[0];
            int curMinIdxX = maxMap.get("xNegative");
            if(curMinIdxX > curIdxX){
                maxMap.put("xNegative", curIdxX);
            }
        }
    }

    public int[] transCoord(int[] coord, int[] leftTop){
        int[] arrayIdx = new int[2];
//        System.out.println("coord : " + coord[0] + ", " + coord[1]);
//        System.out.println("leftTop : " + leftTop[0] + ", " + leftTop[1]);
        int coordY = coord[1];
        int topY = leftTop[1];
        arrayIdx[0] = (int)Math.abs(coordY - topY);
//        System.out.println("rowIdx : " + arrayIdx[0]);
        arrayIdx[1] = (int)Math.abs(coord[0] - leftTop[0]);
//        System.out.println("colIdx : " + arrayIdx[1]);

        return arrayIdx;
    }

    public Boj1347_221208() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setLen();
        setDoc();
        printMaze(this.doc);
    }

    public void setLen() throws IOException {
        this.len = Integer.parseInt(this.br.readLine());
    }

    public void setDoc() throws IOException {
        this.doc = this.br.readLine();
    }

    public void printMaze(String doc){
        int[] currentIdx = {0,0};
        Map<String, Integer> maxIdx = new HashMap<>();
        maxIdx.put("xPositive", 0);
        maxIdx.put("xNegative", 0);
        maxIdx.put("yPositive", 0);
        maxIdx.put("yNegative", 0);

        List<int[]> passedIdx = new ArrayList<>();
        int[] firstHistory = new int[2];
        firstHistory[0] = 0;
        firstHistory[1] = 0;
        passedIdx.add(firstHistory);

        int direction = SOUTH;
        for(int i = 0; i < doc.length(); i++){
            char c = doc.charAt(i);
//            System.out.println("given : " + c);
            switch (c){
                case 'R' :
//                    System.out.println("turn Right");
                    direction = getNextDirection(direction, 'R');
                    break;
                case 'L' :
//                    System.out.println("turn Left");
                    direction = getNextDirection(direction, 'L');
                    break;
                case 'F' :
//                    System.out.println("move Forward");
                    currentIdx = getNextIdx(currentIdx, direction);
                    int[] history = new int[2];
                    history[0] = currentIdx[0];
                    history[1] = currentIdx[1];
                    passedIdx.add(history);
                    renewMaxIdx(currentIdx, direction, maxIdx);
                    break;
            }
//            System.out.println("current Direction : " + direction);
//            System.out.println("current Idx : " + currentIdx[0] + " , " + currentIdx[1]);
        }

        int minY = maxIdx.get("yNegative"); int maxY = maxIdx.get("yPositive");
        int minX = maxIdx.get("xNegative"); int maxX = maxIdx.get("xPositive");
//        System.out.println("min X : " + minX + "max X : " + maxX);
//        System.out.println("min Y : " + minY + "max Y : " + maxY);

        int xSize = maxX - minX + 1;
        int ySize = maxY - minY + 1;
//        System.out.println("xSize : "+ xSize + "ySize : " + ySize);
        char[][] maze = new char[ySize][xSize];

        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                maze[i][j] = '#';
//                System.out.print('*');
            }
//            System.out.println();
        }

        int[] leftTop = new int[2];
        leftTop[0] = minX;
        leftTop[1] = maxY;
        for(int[] idx : passedIdx){
//            System.out.println("idx : " + idx[0] + " , " + idx[1]);
            int[] rowIdx = transCoord(idx, leftTop);
            maze[rowIdx[0]][rowIdx[1]] = '.';
        }

//        System.out.println("==========================");

        for(int i = 0; i < maze.length; i++){
            for(int j = 0; j < maze[0].length; j++){
                System.out.print(maze[i][j]);
            }
            System.out.println();
        }


    }


    public static void main(String[] args) throws IOException {
        Boj1347_221208 boj1347_221208 = new Boj1347_221208();

    }


}

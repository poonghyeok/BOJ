import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1491_221124 {

    private final static int FORWARD_EAST = 0;
    private final static int FORWARD_SOUTH = 1;
    private final static int FORWARD_WEST = 2;
    private final static int FORWARD_NORTH = 3;
    private final static int[][] MOVE_INDEX = {{0,1},{1,0},{0,-1},{-1, 0}};

    private BufferedReader br;
    private int row, col;
    private int[][] spiralRoad;

    public Boj1491_221124() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setSize();
        setSpiralRoad();
        printMatrix(this.spiralRoad);
        System.out.println();
        System.out.println(getLastIndex()[0]+" "+getLastIndex()[1]);
    }

    public void setSize() throws IOException {
        String[] temp = this.br.readLine().split(" ");
        this.row = Integer.parseInt(temp[0]);
        this.col = Integer.parseInt(temp[1]);
    }

    public void setSpiralRoad(){
        this.spiralRoad = new int[this.row + 2][this.col + 2];
        for(int i = 0; i < spiralRoad.length; i++){
            for(int j = 0; j < spiralRoad[0].length; j++){
                if( i == 0 || i == spiralRoad.length-1 || j == 0 ||  j == spiralRoad[0].length - 1){
                    this.spiralRoad[i][j] = 0;
                }else{
                    this.spiralRoad[i][j] = 1;
                }
            }
        }
    }

    public void printMatrix(int[][] matrix){
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                System.out.print(matrix[i][j] +  " ");
            }
            System.out.println();
        }
    }

    public int[] getLastIndex(){
        int[] lastIndex = new int[2];
        int[] currentIndex = {0, 0};
        int direction = FORWARD_EAST;

        int i = 1;
        int j = 1;

        int test = 0;
        while(true){
            System.out.println("i : " + i + ", j : " + j);

            if(direction == FORWARD_EAST){
                int next = this.spiralRoad[i + MOVE_INDEX[FORWARD_EAST][0]][j + MOVE_INDEX[FORWARD_EAST][1]];
                System.out.println("FORWARD_EAST");
                System.out.println("next : " + next);
                if(next == 0){
                    this.spiralRoad[i][j] = 0;

                    //index의 전환 없이 방향만 돌린다.
                    direction = FORWARD_SOUTH;
                }else{
                    this.spiralRoad[i][j] = 0;

                    //동쪽으로 한칸 전진한다.
                    currentIndex[0] += MOVE_INDEX[FORWARD_EAST][0];
                    currentIndex[1] += MOVE_INDEX[FORWARD_EAST][1];
                    i += MOVE_INDEX[FORWARD_EAST][0];
                    j += MOVE_INDEX[FORWARD_EAST][1];
                }
            }else if(direction == FORWARD_SOUTH){
                int next = this.spiralRoad[i + MOVE_INDEX[FORWARD_SOUTH][0]][j + MOVE_INDEX[FORWARD_SOUTH][1]];
                System.out.println("FORWARD_SOUTH");
                System.out.println("next : " + next);
                System.out.println("next index : " + (i + MOVE_INDEX[FORWARD_SOUTH][0]) + ", " + (j + MOVE_INDEX[FORWARD_SOUTH][1]));

                if(next == 0){
                    this.spiralRoad[i][j] = 0;
                    System.out.println("남쪽 이동 중단, 서쪽으로 방향전환");
                    //index의 전환 없이 방향만 돌린다.
                    direction = 2;
                }else{
                    this.spiralRoad[i][j] = 0;

                    //남쪽으로 한칸 전진한다.
                    currentIndex[0] += MOVE_INDEX[FORWARD_SOUTH][0];
                    currentIndex[1] += MOVE_INDEX[FORWARD_SOUTH][1];
                    i += MOVE_INDEX[FORWARD_SOUTH][0];
                    j += MOVE_INDEX[FORWARD_SOUTH][1];
                }

            }else if(direction == FORWARD_WEST){
                int next = this.spiralRoad[i + MOVE_INDEX[FORWARD_WEST][0]][j + MOVE_INDEX[FORWARD_WEST][1]];
                System.out.println("FORWARD_WEST");
                System.out.println("next : " + next);

                if(next == 0){
                    this.spiralRoad[i][j] = 0;

                    //index의 전환 없이 방향만 돌린다.
                    direction = FORWARD_NORTH;
                }else{
                    this.spiralRoad[i][j] = 0;

                    //서쪽으로 한칸 전진한다.
                    currentIndex[0] += MOVE_INDEX[FORWARD_WEST][0];
                    currentIndex[1] += MOVE_INDEX[FORWARD_WEST][1];
                    i += MOVE_INDEX[FORWARD_WEST][0];
                    j += MOVE_INDEX[FORWARD_WEST][1];
                }
            }else if(direction == FORWARD_NORTH){
                int next = this.spiralRoad[i + MOVE_INDEX[FORWARD_NORTH][0]][j + MOVE_INDEX[FORWARD_NORTH][1]];
                System.out.println("FORWARD_NORTH");
                System.out.println("next : " + next);

                if(next == 0){
                    this.spiralRoad[i][j] = 0;

                    //index의 전환 없이 방향만 돌린다.
                    direction = FORWARD_EAST;
                }else{
                    this.spiralRoad[i][j] = 0;

                    //북쪽으로 한칸 전진한다.
                    currentIndex[0] += MOVE_INDEX[FORWARD_NORTH][0];
                    currentIndex[1] += MOVE_INDEX[FORWARD_NORTH][1];
                    i += MOVE_INDEX[FORWARD_NORTH][0];
                    j += MOVE_INDEX[FORWARD_NORTH][1];
                }
            }

            if(this.spiralRoad[i + MOVE_INDEX[FORWARD_EAST][0]][j + MOVE_INDEX[FORWARD_EAST][1]] == 0
                    && this.spiralRoad[i + MOVE_INDEX[FORWARD_SOUTH][0]][j + MOVE_INDEX[FORWARD_SOUTH][1]] == 0
                    && this.spiralRoad[i + MOVE_INDEX[FORWARD_WEST][0]][j + MOVE_INDEX[FORWARD_WEST][1]] == 0
                    && this.spiralRoad[i + MOVE_INDEX[FORWARD_NORTH][0]][j + MOVE_INDEX[FORWARD_NORTH][1]] == 0
            ){
                System.out.println("0으로 둘러싸임");
                System.out.println(currentIndex[0]);
                System.out.println(currentIndex[1]);

                lastIndex =  currentIndex;
                break;
            }

        }


        /*for(int i = 1; i < this.spiralRoad.length - 1; i++){
            for(int j = 1; j < this.spiralRoad.length -1; j++){

            }
        }*/

        return currentIndex;
    }

    public static void main(String[] args) throws IOException {
        Boj1491_221124 boj1491_221124 = new Boj1491_221124();
    }

}

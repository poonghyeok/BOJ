import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1491_221129try2 {

    private static final int[] RIGHT_STEP = {1,0};
    private static final int[] UP_STEP = {0,1};
    private static final int[] LEFT_STEP = {-1,0};
    private static final int[] DOWN_STEP = {0,-0};
    private static final int[][] STEPS = {RIGHT_STEP, UP_STEP, LEFT_STEP, DOWN_STEP};
    private static final int RIGHT = 0;
    private static final int UP = 1;
    private static final int LEFT = 2;
    private static final int DOWN = 3;

    private int width, height;
    private BufferedReader br;

    public Boj1491_221129try2(){
        this.br = new BufferedReader(new InputStreamReader(System.in));
    }

    public void setRoad() throws IOException {
        String[] temp = this.br.readLine().split(" ");

        this.width = Integer.parseInt(temp[0]);
        this.height = Integer.parseInt(temp[1]);

        return;
    }

    public int[] getIntegCoord(int[] coord1, int[] coord2){
        int[] integ = new int[2];
        integ[0] = coord1[0] + coord2[0];
        integ[1] = coord1[1] + coord2[1];
        return integ;
    }




    public static void main(String[] args){


    }

}

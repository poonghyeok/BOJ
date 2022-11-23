package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1388_221123 {

    private BufferedReader br;
    private int row, col;
    private char[][] matrix;
    private final static int RIGHT_INDEX = 0;
    private final static int DOWN_INDEX = 1;
    private final static int UP_INDEX = 3;
    private final static int LEFT_INDEX = 2;

    private final static int[] ROW_INDEXES = {0, 1, 0, -1};
    private final static int[] COL_INDEXES = {1, 0, -1 , 0};


    public Boj1388_221123() throws IOException{
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setValue();
        setMatrix();
        System.out.println(getRequireSum());
    }

    public void setValue() throws IOException {
        String[] temp = this.br.readLine().split(" ");
        this.row = Integer.parseInt(temp[0]);
        this.col = Integer.parseInt(temp[1]);
        this.matrix = new char[this.row][this.col];
    }

    public void setMatrix() throws IOException {
        for(int i = 0; i < this.row; i++){
            String temp = this.br.readLine();
            for(int j = 0; j < this.col; j++){
                this.matrix[i][j] = temp.charAt(j);
            }
        }
    }

    public int getRequireSum(){

        int requiredSum = 0;

        for(int i = 0; i < this.row; i++){
            for(int j = 1; j < this.col; j++){
                char pivot = this.matrix[i][j];

                char left = this.matrix[i+ROW_INDEXES[LEFT_INDEX]][j+COL_INDEXES[LEFT_INDEX]];
                if(pivot == '-') {
                    if (left == '-') {
                        this.matrix[i + ROW_INDEXES[LEFT_INDEX]][j + COL_INDEXES[LEFT_INDEX]] = '0';
                    }
                }
            }
        }
        for(int j = 0; j < this.col; j++){
            for(int i = 1; i < this.row; i++){
                char pivot = this.matrix[i][j];
                char up = this.matrix[i+ROW_INDEXES[UP_INDEX]][j+COL_INDEXES[UP_INDEX]];

                if(pivot == '|') {
                    if (up == '|') {
                        this.matrix[i+ROW_INDEXES[UP_INDEX]][j+COL_INDEXES[UP_INDEX]] = '0';
                    }
                }
            }
        }

        for(int i = 0; i < this.row; i++){
            for(int j = 0; j < this.col; j++){
                if(this.matrix[i][j] != '0'){
                    requiredSum++;
                }
            }
        }

        return requiredSum;
    }


    public static void main(String[] args) throws IOException {
        Boj1388_221123 boj1388_221123 = new Boj1388_221123();
    }

}

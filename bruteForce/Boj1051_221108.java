package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1051_221108 {

    private BufferedReader br;
    private int row, col;
    private int[][] mat;


    public Boj1051_221108() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setRowCol();
        setMat();
//        printMat();
        getResult();

    }

    public void setRowCol() throws IOException {
        String[] str = this.br.readLine().split(" ");
        this.row = Integer.parseInt(str[0]);
        this.col = Integer.parseInt(str[1]);

    }

    public void setMat() throws IOException {
        this.mat = new int[this.row][this.col];
        for(int i = 0; i < this.row; i++){
            String str = this.br.readLine();
            for(int j = 0; j < this.col; j++){
                this.mat[i][j] = Integer.parseInt(str.substring(j, j+1));
            }
        }
    }

    public void printMat(){
        for(int i = 0; i < this.mat.length; i++){
            for(int j = 0; j < this.mat[0].length; j++){
//                System.out.print(this.mat[i][j]);
            }
//            System.out.println();
        }
    }

    public void getResult(){
        int maxSquareSize = this.row;
        if(this.col <  this.row){
            maxSquareSize = this.col;
        }

        //좌상단 좌표랑, 한변의 크기, mat 만 반복문으로 전달해주면 된다.
        while(maxSquareSize > 1){
            int maxLTRowIdx = this.mat.length - maxSquareSize;
            int maxLTColIdx = this.mat[0].length - maxSquareSize;

//            System.out.println("maxLTRowIdx : " + maxLTRowIdx + ",maxLTColIdx : " + maxLTColIdx + ", size : " +  maxSquareSize);

            for(int i = 0; i <= maxLTRowIdx; i++){
                for(int j = 0; j <= maxLTColIdx; j++){
//                    System.out.print("(" + i + "," + j + ") : " );
                    if(isSameFourPoints(i,j,maxSquareSize,this.mat)){
//                        System.out.println();
                        System.out.println(maxSquareSize * maxSquareSize);
                        return;
                    }
                }
//                System.out.println();
            }

            maxSquareSize--;

        }
        System.out.println(1);

    }

    public boolean isSameFourPoints(int leftTopIdxRow, int leftTopIdxCol, int rootSize, int[][] matrix){
        int[] valLTRTLBRB = new int[4];

        valLTRTLBRB[0] = matrix[leftTopIdxRow][leftTopIdxCol];
        valLTRTLBRB[1] = matrix[leftTopIdxRow][leftTopIdxCol + rootSize - 1];
        valLTRTLBRB[2] = matrix[leftTopIdxRow + rootSize - 1][leftTopIdxCol];
        valLTRTLBRB[3] = matrix[leftTopIdxRow + rootSize - 1][leftTopIdxCol + rootSize - 1];

        int pivot = 0;
        for(int k = 0; k < valLTRTLBRB.length; k++){
//            System.out.print("LTRTLBRB : " + k + " th ::  "+ valLTRTLBRB[k] + " ");
            if (k == 0){
                pivot = valLTRTLBRB[k];
            }else{
                if(pivot != valLTRTLBRB[k]){
                    return  false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        Boj1051_221108 boj1051_221108 = new Boj1051_221108();
    }

}

package bruteForce;

import java.util.Scanner;

public class Boj1018_221012 {

    public final int B = 0;
    public final int W = 1;
    private int row;
    private int col;
    private char[][] mat;
    private Scanner sc;

    public Boj1018_221012(){
        this.sc = new Scanner(System.in);
        setRow();
        setCol();
        setMat();
        getResult();
    }

    public void setRow(){
        this.row = this.sc.nextInt();
    }
    public int getRow(){
        return this.row;
    }

    public void setCol(){
        this.col = this.sc.nextInt();
    }
    public int getCol(){
        return this.col;
    }

    public void setMat(){
        int rowNum = getRow();
        int colNum = getCol();
        this.mat = new char[rowNum][colNum];

        this.sc.nextLine();
        //공백줄먹어버리기

        for(int i = 0; i < rowNum; i++){
            stringToCol(i, this.sc.nextLine());
        }
    }
    public char[][] getMat(){
        return this.mat;
    }

    public void stringToCol(int rowIdx, String str){
        for(int j = 0; j < str.length(); j++){
            this.mat[rowIdx][j] = str.charAt(j);
        }
    }

    public int checkNumPaint(char[][] matPart){
        //matPart에 8*8 matrix를 넣어주기만 하면된다.
        int paintNum = 0;
        char initColor = matPart[0][0];
        int length = matPart.length;

        for(int p = 0; p < length; p++){
            for(int q = 0; q < length; q++){
                char color = matPart[p][q];
                if(p == 0 && q ==0){
                    continue;
                }else{
                    //p와q 모두 짝수이거나 모두 홀수인경우 initColor랑 동일해야한다.
                    if( isSameInit(p,q) ){
                        //initColor랑 같아야 하는자리, initColor랑 다르다면 색을 다시 칠해야한다.
                        if( color != initColor ){
                            paintNum++;
                        }
                    }else{
                        //intiColor랑 달라야하는 자리, initColor랑 같다면 색을  다시 칠해야한다.
                        if( color == initColor ){
                            paintNum++;
                        }
                    }
                }
            }
        }

        return paintNum;
    }

    public boolean isEven(int num){
        if(num % 2 == 0){
            return true;
        }else{
            return false;
        }
    }

    public boolean isSameInit(int rowIdx, int colIdx){
        if( ( isEven(rowIdx) && isEven(colIdx) ) || ( !isEven(rowIdx) && !isEven(colIdx) )){
            return true;
        }else{
            return false;
        }
    }

    public void getResult(){
        int maxStartRowIdx = this.getMat().length - 8;
        int maxStartColIdx = this.getMat()[0].length - 8;
        int minPaintNum = -1;

        for(int k = 0; k <= maxStartRowIdx; k++){
            for(int m = 0; m <= maxStartColIdx; m++){
                char[][] matTemp =  getPartMatrix(k, m);

                if(k == 0 && m == 0){
                    minPaintNum = checkNumPaint(matTemp);
                }else{
                    int paintNum = checkNumPaint(matTemp);
                    if(paintNum < minPaintNum){
                        minPaintNum = paintNum;
                    }
                }
            }
        }

        System.out.print(minPaintNum);
    }

    public char[][] getPartMatrix(int startIdx, int endIdx){
        char[][] partMatrix = new char[8][8];

        for(int x = 0; x < 8; x++){
            for(int y = 0; y < 8; y++){
                partMatrix[x][y] = this.getMat()[x+startIdx][y+endIdx];
            }
        }

        return partMatrix;
    }


    public static void main(String[] args){

        Boj1018_221012 me = new Boj1018_221012();

    }

}

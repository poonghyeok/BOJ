package implementation;

import java.util.Scanner;

public class Boj1236_221025 {

    private Scanner sc;
    private int rowNum, colNum;
    private char[][] mat;

    public Boj1236_221025(){
        this.sc = new Scanner(System.in);
        setRowColNum();
        setMat();
        getResult();
    }

    public void setRowColNum(){
        this.rowNum = this.sc.nextInt();
        this.colNum = this.sc.nextInt();
    }

    public void setMat(){
        this.mat = new char[this.rowNum][this.colNum];
        for(int i = 0; i < this.rowNum; i++){
            String temp = this.sc.next();
//            System.out.println(i + " 번 째 : " + temp);
            //char 배열에 하나씩 입력할 수 없나.
            for(int j = 0; j < this.colNum; j++){
                this.mat[i][j] = temp.charAt(j);
            }
        }
    }

    public int checkEmptyRow(char [][] mat){
//        System.out.println("checkEmptyRow");
//        printMat(mat);
        int emptyRow = 0;
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] == 'X'){
                    break;
                }else{
                    if(j == mat[0].length-1){
                        emptyRow++;
                    }
                }
            }
        }

        return emptyRow;
    }

    public int checkEmptyCol(char [][] mat){
//        System.out.println("checkEmptyCol");
//        printMat(mat);
        int emptyCol = 0;
        for(int i = 0; i < mat[0].length; i++){
            for(int j = 0; j < mat.length; j++){
                if(mat[j][i] == 'X'){
                    break;
                }else{
                    if(j == mat.length-1){
                        emptyCol++;
                    }
                }
            }
        }

        return emptyCol;
    }

    public void getResult(){
        int emptyRowNum = checkEmptyRow(this.mat);
        int emptyColNum = checkEmptyCol(this.mat);

        if(emptyRowNum > emptyColNum){
            System.out.println(emptyRowNum);
        }else{
            System.out.println(emptyColNum);
        }
    }


    public void printMat(char[][] charMat){
        for(int i = 0; i < charMat.length; i++){
            for(int k = 0; k < charMat[0].length; k++){
                System.out.print(charMat[i][k]);
            }
            System.out.println();
        }
    }




    public static void main(String[] args){
        Boj1236_221025 boj1236_221025 = new Boj1236_221025();

    }

}

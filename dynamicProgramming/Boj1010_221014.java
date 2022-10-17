package dynamicProgramming;

import java.util.Scanner;

public class Boj1010_221014 {

    private int num;
    private int west;
    private int east;
    private Scanner sc;

    public Boj1010_221014(){
        this.sc = new Scanner(System.in);
        setNum();
        getResult();
    }

    //getter, setter
    public void setNum(){
        this.num = this.sc.nextInt();
    }
    public int getNum(){
        return this.num;
    }

    public void setWest(){
        this.west = this.sc.nextInt();
    }
    public int getWest(){
        return this.west;
    }

    public void setEast(){
        this.east = this.sc.nextInt();
    }
    public int getEast(){
        return this.east;
    }
    //
    public int factorial(int num){
        if(num == 1){
            return num;
        }else{
            return num * factorial(num -1);
        }
    }

    public int permutation(int left, int right){
        int result = 1;
        for(int i = right; i >= 1; i--){
            result *= left;
            left--;
        }

        return result;
    }

    public int combination(int left, int right){
        return permutation(left,right) / factorial(right);
    }

    public void getResult(){
        for(int i = 0; i < getNum(); i++){
            setWest();
            setEast();
            System.out.println(permutation(getEast(), getWest()));
        }
    }


    public static void main(String[] args){
        Boj1010_221014 me = new Boj1010_221014();
    }

}

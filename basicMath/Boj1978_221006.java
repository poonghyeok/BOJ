package basicMath;

import java.util.Scanner;

public class Boj1978_221006 {

    private int num;
    private int[] numbers;
    private Scanner sc;

    public Boj1978_221006(){
        this.sc = new Scanner(System.in);
        this.mainProcess();
    }

    public void setNum(){
        this.num = this.sc.nextInt();
    }
    public int getNum(){
        return this.num;
    }

    public void setNumbers(){
        this.numbers = new int[this.getNum()];
        for(int i = 0; i < this.getNum(); i++){
            this.numbers[i] = this.sc.nextInt();
        }
    }
    public int[] getNumbers(){
        return this.numbers;
    }

    public boolean isPrime(int num){
        boolean result =  true;
        if( num == 1 ){
            return false;
        }else{
            for(int i = 2; i <= Math.sqrt(num); i++){
                if((num % i) == 0 ){
                    return false;
                }
            }
        }

        return result;
    }

    public void getResult(){
        int initVal = 0;

        for(int j = 0; j < this.getNum(); j++){
            if(isPrime(this.getNumbers()[j])){
                initVal++;
            }
        }

        System.out.println(initVal);
    }

    public void mainProcess(){
        this.setNum();
        this.setNumbers();
        this.getResult();
    }

    public static void main(String[] args){
        Boj1978_221006 me = new Boj1978_221006();

    }

}

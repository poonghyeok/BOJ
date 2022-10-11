package Sorting;

import java.util.Scanner;

public class Boj1015_221011 {

    private int num;
    private int[] numbers;
    private int[] numbersOrigin;
    private Scanner sc;

    //Constructor
    public Boj1015_221011(){
        this.sc = new Scanner(System.in);
        this.setNum();
        this.setNumbers();
        getResult();
    }
    //

    //Getter,Setter
    public void setNum(){
        this.num = this.sc.nextInt();
    }
    public int getNum(){
        return this.num;
    }

    public void setNumbers(){
        this.numbers = new int[this.getNum()];
        for(int i = 0; i < numbers.length; i++){
            this.numbers[i] = this.sc.nextInt();
        }
        this.numbersOrigin = copyArray(this.numbers);
    }

    public int[] getNumbersOrigin(){
        return this.numbersOrigin;
    }

    public int[] getNumbers(){
        return this.numbers;
    }

    public void printNumbers(){
        for(int i = 0; i < this.getNumbers().length; i++){
            System.out.print(this.getNumbers()[i] + " ");
        }
    }
    //

    //copyArray
    public int[] copyArray(int[] arr){
        int[] arrTemp = new int[arr.length];
        for(int i = 0; i < arrTemp.length; i++){
            arrTemp[i] = arr[i];
        }

        return arrTemp;
    }
    //
    //Sorting
    public void bubbleSort(){
        for(int i = this.getNumbers().length-1; i > 0 ; i--){
            for(int j = 0; j < i; j++){
                if(this.getNumbers()[j] > this.getNumbers()[j+1]){
                    int temp = this.getNumbers()[j+1];
                    this.getNumbers()[j+1] = this.getNumbers()[j];
                    this.getNumbers()[j] = temp;
                }
            }
        }
    }
    //

    //get idx in sortedArray
    public int getIdx(int ele){
        int result = -1;
        for(int k = 0; k < this.getNumbers().length; k ++){
            if(ele == this.getNumbers()[k]){
                this.getNumbers()[k] = 0;
                result = k;
                return result;
            }
        }
        return result;
    }
    //

    //getResult
    //정렬먼저한다. quickSort를 할 줄 모른다.
    public void getResult(){
        bubbleSort();
//        printNumbers();
        for(int i = 0; i < this.getNumbersOrigin().length; i++){
            System.out.print(getIdx(this.getNumbersOrigin()[i])+" ");
        }
    }
    //

    public static void main(String[] args){
        Boj1015_221011 me = new Boj1015_221011();
    }

}

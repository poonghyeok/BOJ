package implementation;

import java.util.Scanner;

public class Boj1110_221024 {

    private int num;
    private int[] numArr;
    private Scanner sc;

    public Boj1110_221024(){
        this.sc = new Scanner(System.in);
        this.numArr = new int[2];
        setNum();
        getResult();
    }

    public void setNum(){
        this.num = this.sc.nextInt();
    }

    public void setNumArr(int number){
        //숫자는 항상 십의 자리 수와 일의 자리수 배열로 분해할 수 있다.
        int ten = number / 10;
        int one = (number - ten*10);
        this.numArr[0] = ten;
        this.numArr[1] = one;
//        System.out.println("setNumArr(int number) : " + this.numArr[0] +  " , " + this.numArr[1]);
    }

    public void setNumArr(int ten, int one){
        this.numArr[0] = ten;
        this.numArr[1] = one;

//        System.out.println("setNumArr : " + this.numArr[0] + ", " + this.numArr[1]);
    }

    public int getBackNum(int number){
        //수가 주어졌을 때 뒷자리 수를 return 하는 method.
        int ten = number / 10;
        int one = (number - ten*10);

//        System.out.println("getBackNum : " + one);
        return one;
    }

    public int arrToNum(int[] arr){
        int result = 0;
        result += (arr[0]*10);
        result += arr[1];

//        System.out.println("arrToNum : " + result);
        return result;
    }

    public int getSumArr(int[] arr){
        int ten = arr[0];
        int one = arr[1];

//        System.out.println("getSumArr : " + (ten + one));
        return ten+one;
    }

    public void getResult(){
        int initNum = this.num;
        setNumArr(initNum);
        int cycle = 0;
        while(true){
            //initNum이랑 같아져야한다.

            if(initNum == arrToNum(this.numArr) && (cycle != 0)){
                break;
            }else{
                cycle++;
                int newTen = getBackNum(arrToNum(this.numArr));
                int newOne = getBackNum(getSumArr(this.numArr));
                setNumArr(newTen, newOne);
            }
//            System.out.println("\n cycle : " + cycle);
//            System.out.println("arr to num : " + arrToNum(this.numArr));
        }

        System.out.println(cycle);

    }



    public static void main(String[] args){
        Boj1110_221024 boj1110_221024 = new Boj1110_221024();
    }

}

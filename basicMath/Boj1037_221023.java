package basicMath;

import java.util.Scanner;

public class Boj1037_221023 {

    private Scanner sc;
    private int num;
    private int[] subnums;

    public Boj1037_221023(){
        this.sc = new Scanner(System.in);
        setNum();
        setSubnums();
        bubbleSort(this.subnums);
        getResult();

    }

    public void setNum(){
        this.num = this.sc.nextInt();
    }

    public void setSubnums(){
        this.subnums = new int[this.num];

        for(int i = 0; i < this.num; i++){
            this.subnums[i] = this.sc.nextInt();
        }
    }

    public void bubbleSort(int[] arr){
        for(int j = arr.length - 1; j > 0; j--){
            for(int i = 0; i < j; i++){
                if(arr[i] > arr[i+1]){
                    int temp = arr[i+1];
                    arr[i+1] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }

    public void getResult(){
        if(this.num == 1){
            System.out.println(this.subnums[0]*this.subnums[0]);
        }else{
            System.out.println(this.subnums[0]*this.subnums[this.num-1]);
        }
    }

    public static void main(String[] args){
        Boj1037_221023 boj1037_221023  = new Boj1037_221023();
    }

}

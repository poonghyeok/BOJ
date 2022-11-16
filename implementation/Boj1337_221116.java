package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1337_221116 {

    private BufferedReader br;
    private int arrLen;
    private int[] arr;

    public Boj1337_221116() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setArrLen();
        setArr();
        bubbleSort(this.arr);
        System.out.println(5- getMaxContNumInSortedArr(this.arr));
    }

    public void setArrLen() throws IOException {
        this.arrLen = Integer.parseInt(this.br.readLine());
    }

    public void setArr() throws IOException {
        this.arr = new int[this.arrLen];

        for(int i = 0; i < this.arrLen; i++){
            this.arr[i] = Integer.parseInt(this.br.readLine());
        }
    }

    public void bubbleSort(int[] arr){
        for(int i = arrLen-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] >  arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public int getMaxContNumInSortedArr(int[] arr){
        int max = 1;

        int pivot = arr[0];
        int chain = 1;
        for(int k = 1; k < arr.length; k++){
            System.out.println("pivot : " + pivot );
            if((pivot + 1) == arr[k]){
                chain++;
            }else{
                chain = 1;
            }
            System.out.println("chain : " + chain);
            if(chain > max){
                max = chain;
            }
            pivot = arr[k];
            System.out.println("current max : " + max);
            System.out.println("newPivot : " + pivot);
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        Boj1337_221116 boj1337_221116 = new Boj1337_221116();
    }

}

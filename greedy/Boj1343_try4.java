package greedy;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Boj1343_try4 {

    private String str;
    private char[] arr;
    private Queue<Character> queue;
    private Scanner sc;

    public Boj1343_try4(){
        this.sc = new Scanner(System.in);
        setStr();
        setArrQueue();
        queueToArr(this.queue,this.arr);
        getResult(this.arr);
    }

    public void setStr(){
        this.str = this.sc.next();
    }
    public void setArrQueue(){
        int len = this.str.length();
        this.arr = new char[len];
        this.queue = new ArrayDeque<>();

        for(int i = 0; i < len; i++){
            this.queue.add(this.str.charAt(i));
        }
    }

    public void queueToArr(Queue<Character> queue, char[] arr){
        int initSize = queue.size();
        for(int i = 0; i < initSize; i++){
            arr[i] = queue.poll();
            exchangeElements(queue, arr);
        }

    }

    public void exchangeElements(Queue<Character> queue, char[] arr){
        //배열에 추가될 때마다 원소들을 교환하는 메소드를 호출한다.
        // + 항상 배열의 크기만큼 돌기엔 별로다.
        for(int i = 0; i < arr.length - queue.size(); i++){
            if(this.arr[i] == '.' || this.arr[i] == 'A'){
                continue;
            }else{
                if(i > 0){
                    //X가 두개 연속으로 이어진다면 B로 바꾸자.
                    if(this.arr[i] == 'X' && this.arr[i - 1] == 'X'){
                        this.arr[i] = 'B';
                        this.arr[i - 1] = 'B';
                        //BB로 변경됐으면 그 상태에서 AAAA로 바꿀 수 있는 애들이 있는지 찾아보자. 꼭 재귀로 불러야하는지는 의문이다. B로 변경하는거 A로 변경하는거 메소드로 나눠서 각 각 호출하는게 낫지 않나.
                        exchangeElements(queue, arr);
                    }

                    //B가 4개 연속으로 이어진다면 A로 바꾸자.
                    if(i > 2){
                        if(this.arr[i-3] == 'B' && this.arr[i-2] == 'B' && this.arr[i-1] == 'B' && this.arr[i] == 'B'){
                            this.arr[i-3] = 'A';
                            this.arr[i-2] = 'A';
                            this.arr[i-1] = 'A';
                            this.arr[i] = 'A';
                        }
                    }
                }
            }
        }

    }

    public void getResult(char[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == 'X'){
                System.out.println(-1);
                return;
            }
        }

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i]);
        }
    }


    public static void main(String[] args){
        Boj1343_try4 boj1343_try4 = new Boj1343_try4();
    }

}

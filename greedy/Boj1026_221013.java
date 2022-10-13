package greedy;

import java.util.Scanner;

public class Boj1026_221013 {

    //정수 배열 A,B 길이 N
    //S는 A*B ++++
    //S가 최소가 되도록 A를 재배열하자.
    //B는 재배열 하지 않는다.
    //출력은 S의 최솟값

    //풀이 방식 : B의 가장 큰 원소에 A에 가장 작은 원소를 붙이는 방식
    //어짜피 정렬된 A를 순서대로 출력하는 것이 아니라 S의 최소값을 RETURN 하는 것이기 때문에
    private int num;
    private int[] arr;
    private int[] brr;
    private Scanner sc;

    public Boj1026_221013(){
        this.sc = new Scanner(System.in);
        setNum();
        setArr();
        setBrr();
        getResult();
    }

    public void setNum(){
        this.num = sc.nextInt();
    }
    public int getNum(){
        return this.num;
    }

    public void setArr(){
        this.arr = new int[getNum()];
        for(int i = 0; i < getNum(); i++){
            this.arr[i] = this.sc.nextInt();
        }
    }
    public int[] getArr(){
        return this.arr;
    }

    public void setBrr(){
        this.brr = new int[getNum()];
        for(int i = 0; i < this.num; i++){
            this.brr[i] = this.sc.nextInt();
        }
    }
    public int[] getBrr(){
        return this.brr;
    }

    public void bubbleSort(int[] array, int order){
        //order가 1이면 오름차순
        //order가 -1이면 내림차순

        for(int i = array.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(order == 1){
                    if(array[j] > array[j+1]){
                        int temp = array[j+1];
                        array[j+1] = array[j];
                        array[j] = temp;
                    }
                }else if(order == -1){
                    if(array[j] < array[j+1]){
                        int temp = array[j+1];
                        array[j+1] = array[j];
                        array[j] = temp;
                    }
                }
            }
        }
    }

    public void getResult(){
        bubbleSort(getArr(), -1);
        bubbleSort(getBrr(),1);

        int total = 0;

        for(int i = 0; i < getNum(); i++){
            total += (getArr()[i]*getBrr()[i]);
        }

        System.out.print(total);
        return;
    }

    public static void main(String[] args){
        Boj1026_221013 me = new Boj1026_221013();
    }

}

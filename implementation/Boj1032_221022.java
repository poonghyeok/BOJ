package implementation;

import java.util.Scanner;

public class Boj1032_221022 {

    private int num;
    private String[] strArr;
    private Scanner sc;

    public Boj1032_221022(){
        this.sc = new Scanner(System.in);
        setNum();
        setStrArr();
        getResult();
    }

    public void setNum(){
        this.num = this.sc.nextInt();
    }

    public void setStrArr(){
        this.strArr = new String[this.num];
        for(int i = 0; i < num; i++){
            this.strArr[i] = this.sc.next();
        }
    }

    public void getResult(){

        for(int i =0; i < this.strArr[0].length(); i++){
            //문자열 배열에서 항상 0번쨰를 기준으로 나머지 문자열의 index char 들과 비교를 한다.
            char pivot = this.strArr[0].charAt(i);
            boolean allsame = true;

            for(int j = 1; j < this.strArr.length; j++){
                if(pivot != this.strArr[j].charAt(i)){
                    System.out.print('?');
                    allsame = false;
                    break;
                }
            }
            if(allsame){
                System.out.print(pivot);
            }
        }

    }

    public static void main(String[] args){
        Boj1032_221022 boj1032_221022 = new Boj1032_221022();

    }

}

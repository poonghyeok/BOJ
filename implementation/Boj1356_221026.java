package implementation;

import java.util.Scanner;

public class Boj1356_221026 {

    private String init;
    private Scanner sc;

    public Boj1356_221026(){
        this.sc = new Scanner(System.in);
        setInit();
        getResult();
    }

    public void setInit(){
        this.init = this.sc.next();
    }

    public void getResult(){
        int initSize = this.init.length();

        for(int j = 0; j < initSize-1; j++){
//            System.out.println(j +" th : ");
            String forer = this.init.substring(0, j+1);
//            System.out.println("forer : " + forer + " multVal : " + getMultStr(forer));
            String latter = this.init.substring(j+1, initSize);
//            System.out.println("latter : " + latter + " multVal : " + getMultStr(latter));

            if(getMultStr(forer) == getMultStr(latter)){
                System.out.println("YES");
                return;

            }
        }

        System.out.println("NO");
    }

    public int getMultStr(String subStr){
        int mult = 1;
        for(int i = 0; i < subStr.length(); i++){
            int num = Integer.parseInt(subStr.substring(i, i+1));
            mult *= num;
        }

        return mult;
    }

    public static void main(String[] args){
        Boj1356_221026 boj1356_221026 = new Boj1356_221026();
    }

}

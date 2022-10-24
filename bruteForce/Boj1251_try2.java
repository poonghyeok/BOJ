package bruteForce;

import java.util.Scanner;

public class Boj1251_try2 {

    private String str;
    private Scanner sc;

    public Boj1251_try2(){
        this.sc = new Scanner(System.in);
    }

    public void setStr(){
        this.str = this.sc.next();
    }

    public int compareReverseStr(String str1, String str2){
        int len1 = str1.length();
        int len2 = str2.length();
        int compareLen = len1;
        if(len2 < len1){
            compareLen = len2;
        }

        return 0;

    }

    public static void main(String[] args){

    }
}

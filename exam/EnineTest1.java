package exam;

import java.util.Scanner;

public class EnineTest1 {

    //Declaration
    private String str;
    private int midIdx;
    private Scanner sc;
    //

    //Generator
    public EnineTest1(){
        this.sc = new Scanner(System.in);
        this.setStr();
        this.getResult();
    }
    //

    //Getter,Setter
    public void setStr(){
        this.str = this.sc.next();
    }
    public String getStr(){
        return this.str;
    }
    //

    //main method about two cases
    //midIdx case
    public int getLenFromMid(){
        String strTemp = this.getStr();
        int len = 1;
        int maxLen = 1;

        for(int i = 1; i < strTemp.length()-1; i++){
            int left = i-1;
            int right = i+1;
            len = 1;

            while(left >= 0 && right < strTemp.length()){
                if(strTemp.charAt(left) == strTemp.charAt(right)){
                    len += 2;
                    left--;
                    right++;
                }else{
                    break;
                }
            }
            if(len > maxLen){
                maxLen = len;
            }
        }

        return maxLen;
    }
    //

    //no midIdx case
    public int getLenDecal(){
        String strTemp = this.getStr();
        int len = 0;
        int maxLen = 0;

        for(int i = 0; i < strTemp.length()-1; i++){
            len = 0;
            int left = i;
            int right = i+1;

            while(left >= 0 && right < strTemp.length()) {
                if (strTemp.charAt(left) == strTemp.charAt(right)) {
                    len += 2;
                    left--;
                    right++;
                }else{
                    break;
                }
            }

            if(len > maxLen){
                maxLen = len;
            }
        }

        return maxLen;
    }
    //

    //getResult
    public void getResult(){
        int totalMax = 0;
        int lenFromMid = this.getLenFromMid();
        int lenDecal = this.getLenDecal();

        if(lenFromMid > totalMax){
            totalMax = lenFromMid;
        }
        if(lenDecal > totalMax){
            totalMax = lenDecal;
        }

        System.out.println(totalMax);
        return;
    }
    //

    public static void main(String[] args){
        EnineTest1 me = new EnineTest1();
    }

}

package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1439_221106 {

    private BufferedReader br;
    private String str;

    public Boj1439_221106() throws IOException {

        this.br = new BufferedReader(new InputStreamReader(System.in));
        setStr();
        getResult();
    }

    public void setStr() throws IOException {
        this.str = this.br.readLine();
    }

    public int getConChar(String str, char c){
        int cntConZero = 0;
        boolean isCon = false;

        for(int i = 0; i < str.length(); i++){
            if(!isCon && str.charAt(i) == c){
                isCon = true;
                cntConZero++;
            }else if(str.charAt(i) != c){
                isCon = false;
            }
//            System.out.println(i + "th : " + cntConZero);
        }

        return cntConZero;
    }

    public void getResult(){
        int turnCntZero = getConChar(this.str, '0');
        int turnCntOne = getConChar(this.str, '1');
//        System.out.println("turnCntOne : " + turnCntOne);
//        System.out.println("turnCntZero : " + turnCntZero);

        if(turnCntZero < turnCntOne){
            System.out.println(turnCntZero);
        }else{
            System.out.println(turnCntOne);
        }
    }

    public static void main(String[] args) throws IOException {

        Boj1439_221106 boj1439_221106 = new Boj1439_221106();

    }

}

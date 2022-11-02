package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1436_221102 {

    private BufferedReader br;
    private int seq;

    public Boj1436_221102() throws IOException{
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setSeq();
        getResult();
    }

    public void setSeq() throws IOException {
        this.seq = Integer.parseInt(this.br.readLine());
    }

    public void getResult(){
        int endNum = 0;
        int i = 1;
        while(true){
            if(checkConSix(i)){
                endNum++;
            }
            if(endNum == this.seq){
                System.out.println(i);
                return;
            }else{
                i++;
            }
        }
    }

    public boolean checkConSix(int n){
        int conNum = 0;
        String str = Integer.toString(n);

        for(int j = 0; j < str.length(); j++){
            if(str.charAt(j) == '6'){
                conNum++;
            }else{
                conNum = 0;
            }
            if(conNum == 3){
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) throws IOException {
        Boj1436_221102 boj1436_221102 = new Boj1436_221102();

    }

}

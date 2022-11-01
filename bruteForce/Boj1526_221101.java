package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1526_221101 {

    private BufferedReader br;
    private String num;

    public Boj1526_221101() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setNum();
        getResult();
    }

    public void setNum() throws IOException {
        this.num = this.br.readLine();
    }

    public void setNum(int num){
        this.num = Integer.toString(num);
    }

    public void getResult(){
        for(int i = Integer.parseInt(this.num); i >=4; i--){
            if(isOnlyFourSeven(i)){
                System.out.println(i);
                return;
            }else{
                continue;
            }
        }
    }

    public boolean isOnlyFourSeven(int n){
        String str = Integer.toString(n);
        boolean result = true;

        for(int j = 0; j < str.length(); j++){
            char c = str.charAt(j);
            if(c != '4' && c != '7'){
                return false;
            }
        }

        return result;
    }



    public static void main(String[] args) throws IOException {
        Boj1526_221101 boj1526_221101 = new Boj1526_221101();
    }
}

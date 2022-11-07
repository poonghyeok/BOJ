package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1476_221107 {

    private BufferedReader br;
    private int e,s,m;

    public Boj1476_221107() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setNum();
        getResult();
    }

    private void setNum() throws IOException {
        String temp = this.br.readLine();
        String[] temps = temp.split(" ");
        this.e = Integer.parseInt(temps[0]);
        if( this.e == 15){
            this.e = 0;
        }
        s = Integer.parseInt(temps[1]);
        if( this.s == 28){
            this.s = 0;
        }
        m = Integer.parseInt(temps[2]);
        if( this.m == 19){
            this.m = 0;
        }
    }

    public void getResult(){
        int min = 1;
       while(true){
           if((min % 15 == this.e) && (min % 28 == this.s) && (min % 19 == this.m)){
               System.out.println(min);
               return;
           }else{
               min++;
           }
       }
    }
    public static void main(String[] args) throws IOException {
        Boj1476_221107 boj1476_221107 = new Boj1476_221107();
    }

}

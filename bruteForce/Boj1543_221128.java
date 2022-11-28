package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1543_221128 {

    private BufferedReader br;
    private String data, keyword;

    public Boj1543_221128() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setData();
        setKeyword();
        System.out.println(getSearchCount());
    }

    public void setData() throws IOException {
        this.data = this.br.readLine();
    }

    public void setKeyword() throws IOException {
        this.keyword =  this.br.readLine();
    }

    int count = 0;
    public int getSearchCount(){
        while(true){
            String old = this.data;
            this.data = this.data.replaceFirst(this.keyword, "0");

            if(old.equals(this.data)){
                break;
            }else{
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        Boj1543_221128 boj1543_221128 = new Boj1543_221128();
    }
}

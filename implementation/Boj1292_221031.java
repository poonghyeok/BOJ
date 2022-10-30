package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1292_221031 {

    private BufferedReader br;
    private int start,end;

    public Boj1292_221031() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        String[] brLine = this.br.readLine().split(" ");
        this.start = Integer.parseInt(brLine[0]);
        this.end = Integer.parseInt(brLine[1]);
        System.out.println(getTotalFromTo(this.start-1, this.end-1));

    }

    public int getTotalFromTo(int a, int b){
        int tot = 0;
        for(int i = a; i <= b; i++){
            tot += getNumByIndex(i);
        }

        return tot;
    }

    public int getNumByIndex(int idx){
        int startIdx = 0;
        int endIdx = 0;
        int num = 0;

        while(true){

            startIdx += num;
            endIdx = startIdx + num;
            num++;

            if(idx >= startIdx && idx <= endIdx){
                return num;
            }
        }
    }

    public static void main (String[] args) throws IOException{

        Boj1292_221031 boj1292_221031 = new Boj1292_221031();

    }

}

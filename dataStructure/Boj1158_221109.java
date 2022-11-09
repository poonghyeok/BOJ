package dataStructure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj1158_221109 {

    private BufferedReader br;
    private int N,K;
    private Queue<Integer> queue, tempQue;

    public Boj1158_221109() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setNK();
        setQueues();
        getResult();
    }

    public void setNK() throws IOException {
        String[] strNK = this.br.readLine().split(" ");
        this.N = Integer.parseInt(strNK[0]);
        this.K = Integer.parseInt(strNK[1]);
    }

    public void setQueues (){
        this.queue = new ArrayDeque<>();
        for(int i = 1; i <= this.N; i++){
            this.queue.add(i);
        }

    }

    public void getResult(){
        StringBuffer sb = new StringBuffer();
        int pollNum = 0;
        int selectNum = 0;

        sb.append("<");

        while(selectNum < this.N){
            int temp  = this.queue.poll();
            pollNum++;
            if( pollNum == this.K){
                selectNum++;
                pollNum = 0;
                if(selectNum == this.N) {
                    sb.append(temp);
                }else{
                    sb.append(temp+", ");
                }

            }else{
                this.queue.add(temp);
            }
        }
        sb.append(">");

        System.out.println(sb.toString());
    }

    public static void main(String[] args) throws IOException {
        Boj1158_221109 boj1158_221109 = new Boj1158_221109();
    }

}

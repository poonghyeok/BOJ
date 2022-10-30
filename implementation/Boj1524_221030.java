package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1524_221030 {
    public Boj1524_221030() throws IOException {
        getResult();
    }

    public void getResult() throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcaseNum = Integer.parseInt(br.readLine());
        br.readLine();
        for(int j = 0; j < testcaseNum; j++){
            String[] sejunSebiNum = br.readLine().split(" ");
            int sejunNum = Integer.parseInt(sejunSebiNum[0]);
            int sebiNum = Integer.parseInt(sejunSebiNum[1]);
            int sejunMax = getMaxNum(sejunNum, br);
            int sebiMax = getMaxNum(sebiNum, br);

            if(sebiMax > sejunMax){
                System.out.println("B");
            }else if(sebiMax < sejunMax){
                System.out.println("S");
            }else{
                System.out.println("S");
            }

            br.readLine();

        }
    }

    public int getMaxNum(int num, BufferedReader br) throws IOException {

        int max = 0;
        String[] stats = br.readLine().split(" ");
        for(int i = 0; i < num; i++){
            int next = Integer.parseInt(stats[i]);

            if(max < next){
                max = next;
            }
        }

        return max;
    }

    public static void main(String[] args) throws IOException {
        Boj1524_221030 boj1524_221030 = new Boj1524_221030();

    }
}

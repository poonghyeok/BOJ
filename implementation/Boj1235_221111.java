package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Boj1235_221111 {

    private BufferedReader br;
    private int studentNum;
    private String[] idNums;

    public Boj1235_221111() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setStudentNum();
        setStacks();
        System.out.println(getK());

    }

    public void setStudentNum() throws IOException {
        this.studentNum = Integer.parseInt(this.br.readLine());
    }

    public void setStacks() throws IOException {
        this.idNums = new String[this.studentNum];

        for(int j = 0; j < this.studentNum; j++){
            this.idNums[j] = this.br.readLine();
        }
    }

    public int getK(){
        int k = 1;
        while( k <= this.idNums[0].length()){
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < this.idNums.length; i++){
                String cur = this.idNums[i];

                int curNum = Integer.parseInt(cur.substring( cur.length() - k , cur.length()));
                /*System.out.println("curNum : " + curNum);
                System.out.println("list.indexOf(curNum) : " + list.indexOf(curNum));*/

                if( list.indexOf(curNum) >= 0){
//                    System.out.println("duplicated!");
                    k++;
                    break;
                }else{
//                    System.out.println("new!");
                    list.add(curNum);
                }

                if( i == this.idNums.length - 1 ){
                    return k;
                }
            }
        }
        return k;
    }

    public static void main(String[] args) throws IOException {
        Boj1235_221111 boj1235_221111 = new Boj1235_221111();
    }

}

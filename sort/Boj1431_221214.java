package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Boj1431_221214 {

    private BufferedReader br;
    private int num;
    private List<String> list;


    public Boj1431_221214() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setNum();
        setList();
        sortSerial();
        for(String serial : this.list){
            System.out.println(serial);
        }
    }

    public void setNum() throws IOException {
        this.num = Integer.parseInt(this.br.readLine());
    }

    public void setList() throws IOException {
        this.list = new ArrayList<>();
        for (int i = 0; i < this.num; i++) {
            this.list.add(this.br.readLine());
        }
    }

    public void sortSerial(){
        this.list = this.list.stream().sorted((s, t1) -> {
            int sumNum1 = getSumNumInStr(s);
            int sumNum2 = getSumNumInStr(t1);
            if(s.length() < t1.length())return -1;
            if(s.length() > t1.length())return 1;
            if((sumNum1 != 0 || sumNum2 != 0)&& (s.length() == t1.length()) && (sumNum1 != sumNum2))return sumNum1 - sumNum2;
            return s.compareTo(t1);

        }).collect(Collectors.toList());
    }

    public int getSumNumInStr(String str){
        char[] arr = str.toCharArray();
        int total = 0;
        for(char c : arr){
            if(c >= '0' && c <= '9')total += (c - '0');
        }
        return total;
    }

    public static void main(String[] args) throws IOException {
        Boj1431_221214 boj1431_221214 = new Boj1431_221214();



    }

}

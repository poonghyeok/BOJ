package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Boj1969_221201 {

    private BufferedReader br;
    private int num, len;
    List<String> list;

    public Boj1969_221201() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setNumLen();
        setList();
        printResult();
    }

    public void setNumLen() throws IOException {
        String[] temp = this.br.readLine().split(" ");
        this.num = Integer.parseInt(temp[0]);
        this.len = Integer.parseInt(temp[1]);

    }

    public void setList() throws IOException {
        this.list = new ArrayList<>();
        for(int i = 0; i < this.num; i++){
            this.list.add(this.br.readLine());
        }
    }

    public void printResult(){
        this.list = this.list.stream().sorted().collect(Collectors.toList());

        int distMin = 9999999;
        String minDna = null;

        for(String str : this.list){
            int sum = 0;
            System.out.println("==========================");
            System.out.println("pivot : " + str);
            for(int i = 0; i < this.list.size(); i++){
                String another = this.list.get(i);
                System.out.println("another : " + another);
                if(!str.equals(another)){
                    System.out.println("getHammingDistance : " + getHammingDistance(str, another));
                    sum += getHammingDistance(str, another);
                    System.out.println("sum : " + sum);
                }

                if(sum > distMin){
                    System.out.println("sum over : break!!");
                    break;
                }
            }
            if( sum < distMin){
                System.out.println("min case!");
                distMin = sum;
                minDna = str;
            }
            System.out.println();
            System.out.println("distMax : " + distMin);
            System.out.println("minDna : " + minDna);
            System.out.println("==================================");
        }
        System.out.println(minDna);
        System.out.println(distMin);
    }

    public int getHammingDistance(String str1, String str2){
        int dist = 0;
        for(int i = 0; i < str1.length(); i++){
            if(str1.charAt(i) != str2.charAt(i)){
                dist++;
            }
        }

        return dist;
    }

    public static void main(String[] args) throws IOException {
        Boj1969_221201 boj1969_221201 = new Boj1969_221201();
    }

}

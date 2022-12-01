package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1969_221201try2 {

    private BufferedReader br;
    private int num, len;
    List<Queue<String>> list;

    public Boj1969_221201try2() throws IOException{
        this.br = new BufferedReader(new InputStreamReader(System.in));

        setNumLen();
        setList();
        String minSumHamming = getMinSumHamming();
        System.out.println(minSumHamming);
        System.out.println(getHammingDistance(minSumHamming));

    }

    public void setNumLen() throws IOException {
        String[] temp = this.br.readLine().split(" ");
        this.num = Integer.parseInt(temp[0]);
        this.len = Integer.parseInt(temp[1]);

    }

    public void setList() throws IOException {
        this.list = new ArrayList<>();
        for(int i = 0; i < this.num; i++){
            Queue<String> queue = new ArrayDeque<>();
            String str = this.br.readLine();
            for(int j = 0; j < str.length(); j++){
                queue.add(str.substring(j, j+1));
            }
            list.add(queue);
        }
    }

    public String getMost(String str){
//        System.out.println("getMost : " + str);
        Map<String, Integer> countMap = new HashMap<>();
        countMap.put("A", 0);
        countMap.put("T", 0);
        countMap.put("C", 0);
        countMap.put("G", 0);

        for(int i = 0; i <str.length(); i++){
            String temp = str.substring(i, i+1);
//            System.out.println("temp :" + temp);

            countMap.put(temp, countMap.get(temp) + 1);
        }

        int most = 0;
        String mostKey = "";

        String acgt  = "ACGT";
//        System.out.println("A : "  + countMap.get("A"));
//        System.out.println("C : "  + countMap.get("C"));
//        System.out.println("G : "  + countMap.get("G"));
//        System.out.println("T : "  + countMap.get("T"));
        for(int i =0; i < acgt.length(); i++){
            String code = acgt.substring(i, i+1);
            if(countMap.get(code) > most){
                most = countMap.get(code);
                mostKey = code;
            }
        }

        return mostKey;
    }

    public String getMinSumHamming(){
        String min = "";


        for(int j = 0; j < this.len; j++){
            StringBuffer sb = new StringBuffer();
            for( int k = 0; k < this.list.size(); k++){
                String poll = this.list.get(k).poll();
                sb.append(poll);
                this.list.get(k).add(poll);
                //다시 넣어줘야됨.......
            }
//            System.out.println("most : " + getMost(sb.toString()));
            min += getMost(sb.toString());
        }
        // j 번째에 있는 애들 다 모아서 줌



        return min;
    }

    public int getHammingDistance(String min){
        int hamming = 0;
        for(int i = 0 ; i < min.length(); i++){
            String pivot = min.substring(i, i+1);
//            System.out.println("pivot : " + pivot);
            for(int j =0; j < this.list.size(); j++){
                String sameLoc = this.list.get(j).poll();
//                System.out.println("same Loc : " + sameLoc);
                if(!pivot.equals(sameLoc)){
                    hamming++;
                }
            }
        }

        return hamming;
    }




    public static void main(String[] args) throws IOException {
        Boj1969_221201try2 boj1969_221201try2 = new Boj1969_221201try2();
    }
}

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj1302_221115 {

    private BufferedReader br;
    private int num;
    private Map<String, Integer> map;
    private int maxNum;
    private String bestSeller;

    public Boj1302_221115() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setNum();
        setMapAndBestSeller();
        System.out.println(this.bestSeller);
    }

    public void setNum() throws IOException {
        this.num = Integer.parseInt(this.br.readLine());
    }

    public void setMapAndBestSeller() throws IOException {
        this.map = new HashMap<>();
        for(int i = 0; i < this.num; i++){

            String str = this.br.readLine();
            if(i == 0 ){
                this.map.put(str, 1);
                this.maxNum = 1;
                this.bestSeller = str;
            }else{
                if(map.containsKey(str)){
//                    System.out.println("이미 존재하는 타이틀입니다.");
                    int newNum = map.get(str) + 1;
//                    System.out.println("새로운 횟수 : " + newNum);

                    map.put(str, newNum);
//                    System.out.println("현재 maxNum : " + this.maxNum);

                    judgeBestSeller(newNum, str);

                }else{
                    map.put(str, 1);
                    judgeBestSeller(1, str);
                }
            }

        }
    }

    public void judgeBestSeller(int newNum, String str){
        if(newNum > this.maxNum){
            this.maxNum = newNum;
            this.bestSeller = str;
        }
        if(newNum == this.maxNum){
//            System.out.println(newNum + " >= " + this.maxNum);
            this.maxNum = newNum;
//            System.out.println("새로운 maxNum : " + this.maxNum);


            if( str != this.bestSeller){
                int compareResult = compareDictSeq(str, this.bestSeller);
//                                            System.out.println("compareReulst : " + compareResult);
                if(compareResult ==  -1) {
                    this.bestSeller = str;
                }
            }
//                            System.out.println("현재 best seller : " + bestSeller);
        }
    }

    public int compareDictSeq(String subjectStr, String objectStr){
        int iterLen = subjectStr.length();

        if(objectStr.length() < iterLen){
            iterLen =  objectStr.length();
        }

        for(int i = 0; i < iterLen; i++){
            if(subjectStr.charAt(i) < objectStr.charAt(i)){
//                System.out.println(subjectStr + " 이 " + objectStr + " 보다 사전순으로 앞섭니다.");
                return -1;
            }else if(subjectStr.charAt(i) > objectStr.charAt(i)){
//                System.out.println(subjectStr + " 이 " + objectStr + " 보다 사전순으로 늦습니다.");
                return 1;
            }
        }

        if( subjectStr.length() > objectStr.length()){
            return 1;
        }else{
            return -1;
        }

    }

    public static void main(String[] args) throws IOException {
        Boj1302_221115 boj1302_221115 = new Boj1302_221115();

    }

}

package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1120_221112 {
    //A의 길이는 B보다 작다. A의 앞뒤에 아무 문자나 추가하면서 차이를 최소화하는
    //전략 : A를 B에 여러번 대보면서
    //한자리씩 비교하려면, A가 3자리이고 B가 5자리라면 INDEX 출발 0,1,2 가능
    private BufferedReader br;
    private String str1,str2;

    public Boj1120_221112() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setStrs();
        System.out.println(getDiffNum(this.str1, this.str2));
    }

    public void setStrs() throws IOException {
        String[] strs = this.br.readLine().split(" ");
        this.str1 = strs[0];
        this.str2 = strs[1];

    }

    public int getDiffNum(String smallStr, String largeStr){
        int smallSize = smallStr.length();
        int largeSzie = largeStr.length();
        int maxIndex = largeSzie - smallSize;
        int diffMin = 0;

        for(int i = 0; i <= maxIndex; i++){
            int diff = 0;
            String largeStrSub = largeStr.substring(i, i+smallSize);

            for(int j = 0; j < smallStr.length(); j++){
                if(smallStr.charAt(j) != largeStrSub.charAt(j)){
                    diff++;
                }
                if( i != 0 && diff >= diffMin){
                    break;
                }
            }

            if(i == 0){
                diffMin = diff;
            }else{
                if(diff < diffMin){
                    diffMin = diff;
                }
            }
        }
        return diffMin;
    }


    public static void main(String[] args) throws IOException {
        Boj1120_221112 boj1120_221112 = new Boj1120_221112();
    }

}

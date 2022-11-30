package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1639_221130 {

    private BufferedReader br;
    private String ticket;

    public Boj1639_221130() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setTicket();
        System.out.println(getMaxLuckyLen());
    }

    public void setTicket() throws IOException {
        this.ticket = this.br.readLine();
    }

    public boolean isLucky(String str){
        //특정 부분의 문자열을 전달받았을때,
        if(str.length() % 2 != 0){
            return false;
        }else{
            int leftSum = 0;
            int rightSum = 0;
            for(int i = 0; i < str.length() / 2; i++){
                leftSum += (str.charAt(i) - '0');
                rightSum += (str.charAt(str.length() -1 -i) - '0');
            }
            if(leftSum ==  rightSum){
                return true;
            }else{
                return false;
            }
        }
    }

    public int getMaxLuckyLen(){
        int len = 0;
        int maxLen = this.ticket.length();

        for(int i = maxLen; i > 0; i--){
            //길이를 1까지 줄여가면서
            int maxStartIndex = maxLen - i;
            for(int j = 0; j <= maxStartIndex; j++){
                String substr = this.ticket.substring(j,j+i);
//                System.out.println("substr : " + substr);
                if(isLucky(substr)){
                    return i;
                }
            }
        }

        return len;

    }

    public static void main(String[] args) throws IOException {
        Boj1639_221130 boj1639_221130 = new Boj1639_221130();

    }

}

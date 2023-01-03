package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
* 검색한 내용들
 * 1. java string reverse : String Buffer를 이용하면 reversedString을 쉽게 얻을 수 있다.
 * 1-1. String 객체를 가지고 String Buffer의 객체 생성은 그냥 생성자 paramter로 전달하면 된다.
 * */

public class Boj1254_230103 {

    private BufferedReader br;
    private String str;

    public Boj1254_230103() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.str = this.br.readLine();
        System.out.println(getMinLenPelin(this.str));

    }

    public int getMinLenPelin(String givenStr) {
        int minLenPelin = 2 * (givenStr.length() - 1) + 1;

        for (int i = 0; i < givenStr.length() - 1; i++) {
            String testStr = givenStr.substring(i, givenStr.length());
            if(isAbleAnchor(testStr)){
                minLenPelin = (givenStr.length() - testStr.length()) * 2 + testStr.length();
                break;
            }
        }

        return minLenPelin;
    }

    public boolean isAbleAnchor(String str) {
        if(str.equals(new StringBuffer(str).reverse().toString()))return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        Boj1254_230103 boj1254_230103 = new Boj1254_230103();
    }

}

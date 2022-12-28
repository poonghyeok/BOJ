package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1213_try3_221227_fail {

    private BufferedReader br;
    private String str;
    private List<Character> charList;

    public Boj1213_try3_221227_fail() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.str = this.br.readLine();
        init();
    }

    public void init() throws IOException {
        char[] charArr = this.str.toCharArray();
        Arrays.sort(charArr);
        char[] pelinCharArr = new char[charArr.length];
        boolean oddUsed = false;
        char oddChar =  ' ';
        int oddCharCont = 0;

        for (int i = 0; i < charArr.length - 1; i++) {
            char targetChar = charArr[i];
            System.out.println("target char : " + targetChar);
            int cont = 1;


            while (i + cont < charArr.length &&charArr[i + cont] == targetChar) {
                cont++;
            }

            if (cont % 2 == 0) {
                int idx = 0;
                while (idx < cont / 2) {
                    pelinCharArr[i] = targetChar;
                    pelinCharArr[pelinCharArr.length - 1 - i] = targetChar;
                    idx++;
                }
            }else{
                if(oddUsed){
                    System.out.println("I'm Sorry Hansoo");
                    return;
                }else{
                    oddUsed = true;
                    oddChar = targetChar;
                    oddCharCont = cont;
                }
            }

            i += (cont -1);
        }

        if(oddUsed){
            int oddIdx = charArr.length / 2;
            pelinCharArr[oddIdx] = oddChar;
            int leftOddIdx = oddIdx - 1;
            int rightOddIdx = oddIdx + 1;
            while (rightOddIdx - leftOddIdx + 1 <= oddCharCont) {
                pelinCharArr[leftOddIdx--] = oddChar;
                pelinCharArr[rightOddIdx++] = oddChar;
            }
        }

        System.out.println(String.valueOf(pelinCharArr));
    }


    public static void main(String[] args) throws IOException {
        Boj1213_try3_221227_fail boj1213_try3_221227 = new Boj1213_try3_221227_fail();
    }

}

package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1251_try3_230103 {

    private BufferedReader br;
    private String str;

    public Boj1251_try3_230103() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.str = this.br.readLine();


        System.out.println(getFirstWord());
    }

    public String getFirstWord(){
        String first = null;

        for (int firstBite = 1; firstBite < this.str.length() - 1; firstBite++) {
            Stack<int[]> restBites = getLenOfRest(this.str, firstBite);
            while (!restBites.isEmpty()) {
                int idx = 0;
                String subStr1 = this.str.substring(idx, idx + firstBite);
                idx += firstBite;
                StringBuffer sb1 = new StringBuffer(subStr1).reverse();

                int[] bites = restBites.pop();
                String subStr2 = this.str.substring(idx, idx + bites[0]);
                idx += bites[0];
                sb1.append(new StringBuffer(subStr2).reverse());

                String subStr3 = this.str.substring(idx, this.str.length());
                sb1.append(new StringBuffer(subStr3).reverse());

                if (first == null) {
                    first = sb1.toString();
                }else{
                    if(sb1.toString().compareTo(first) < 0) first = sb1.toString();
                }
            }
        }

        return first;
    }

    public Stack<int[]> getLenOfRest(String givenStr, int firstBite) {
        Stack<int[]> lenRestStack = new Stack();
        int restLen = givenStr.length() - firstBite;
        for(int i = 1; i < restLen; i++){
            lenRestStack.push(new int[]{i, restLen - i});
        }

        return lenRestStack;
    }

    public static void main(String[] args) throws IOException {
        Boj1251_try3_230103 boj1251_try3_230103 = new Boj1251_try3_230103();
    }

}

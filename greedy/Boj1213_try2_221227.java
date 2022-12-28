package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Boj1213_try2_221227 {

    private BufferedReader br;
    private String str;

    public Boj1213_try2_221227() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
        if (!isAblePelin(this.str)) {
            System.out.println("I'm Sorry Hansoo");
        } else {

        }
    }
    public String getPelinStr(Map<Character, Integer> strInfo) {
        //홀수 개를 포함하고 있는지 아닌지 알아야 한다.
        //홀수 개를 포함하고 있다면 ,,
        boolean isContainOdd = false;
        String pelinStr = "";
        if(str.length() % 2 != 0) isContainOdd = true;
        char[] charArr = new char[this.str.length() / 2];

        if (isContainOdd) {
            //홀수 개가 존재하는 경우, 1개만 존재한다.

        } else {
            //짝수 개만 존재하는 경우
            int arrIdx = 0;
            strInfo.keySet().stream().sorted().forEach(key -> {
                int valCnt = strInfo.get(key);
                for (int i = 0; i < valCnt / 2; i++) {

                }
            });
        }

        return pelinStr;
    }

    public void init() throws IOException {
        this.str = this.br.readLine();

    }

    public boolean isAblePelin(String str) {
        //길이가 짝수면 모든 문자가 짝수개 존재해야 됨.
        //길이가 홀수면 등장 횟수가 홀수인 것은 하나만 존재해야 한다.
        int len = str.length();
        boolean able = true;
        Map<Character, Integer> strInfo = getStrInfo(str);

        Iterator<Integer> valIter = strInfo.values().iterator();
        if (len % 2 == 0) {
            while (valIter.hasNext()) {
                if (valIter.next() % 2 != 0) {
                    able = false;
                    break;
                }
            }
        } else {
            int oddNum = 0;
            while (valIter.hasNext()) {
                if (valIter.next() % 2 != 0) {
                    oddNum ++;
                }
                if (oddNum > 1) {
                    able = false;
                    break;
                }
            }
        }

        return able;
    }

    //문자열 안에서 < 문자 , 등장회수 > Map return
    public Map<Character, Integer> getStrInfo(String str) {
        Map<Character, Integer> strInfo = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (strInfo.containsKey(str.charAt(i))) {
                strInfo.put(str.charAt(i), strInfo.get(str.charAt(i)+1));
            }else{
                strInfo.put(str.charAt(i), 1);
            }
        }

        return strInfo;
    }

    public static void main(String[] args) {

    }
}

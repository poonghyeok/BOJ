package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Boj1213_try4_221229 {

    private BufferedReader br;
    private String str;
    private Map<String, Integer> strInfo;

    public Boj1213_try4_221229() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.str = this.br.readLine();
        setStrInfo();
        if(isAblePelin()){
            System.out.println(getPelin(this.strInfo));
        }else{
            System.out.println("I'm Sorry Hansoo");
        }
    }

    public void setStrInfo() {
        this.strInfo = new HashMap<>();
        for (int i = 0; i < this.str.length(); i++) {
            String aStr = this.str.substring(i, i + 1);
            if(this.strInfo.containsKey(aStr)) this.strInfo.put(aStr, this.strInfo.get(aStr) + 1);
            else this.strInfo.put(aStr, 1);
        }
    }

    public boolean isAblePelin() {
        boolean ablePelin = true;
        int oddCase = 0;
        Iterator<Integer> strInfoValIter = this.strInfo.values().iterator();
        while (strInfoValIter.hasNext()) {
            int alphaCaseNum = strInfoValIter.next();
            if(alphaCaseNum %2 != 0) oddCase++;
            if (oddCase > 1) {
                return false;
            }
        }

        return ablePelin;
    }

    public String getPelin(Map<String, Integer> strInfo) {
        StringBuffer frontStr = new StringBuffer();
        StringBuffer midStr = new StringBuffer();

        strInfo.keySet().stream().sorted()
                .forEach(str -> {
                    if (strInfo.get(str) % 2 != 0) {
                        for (int i = 0; i < strInfo.get(str) / 2 ; i++) {
                            frontStr.append(str);
                        }
                        midStr.append(str);
                    }else{
                        for(int i = 0; i < strInfo.get(str) / 2; i++){
                            frontStr.append(str);
                        }
                    }
                });

        String front = frontStr.toString();
        String mid = midStr.toString();
        String last = frontStr.reverse().toString();

        return front + mid + last;
    }

    public static void main(String[] args) throws IOException {
        Boj1213_try4_221229 boj1213_try4_221229 = new Boj1213_try4_221229();
    }

}

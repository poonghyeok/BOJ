package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1213_221206 {

    public class Alphabet{
        public char c;
        public boolean isFirst;
        public int count;

        public Alphabet(char c){
            this.c = c;
            this.isFirst = true;
            this.count = 0;
        }
    }

    private BufferedReader br;
    private Map<Character, Alphabet> infoMap;
    private String str;

    public Boj1213_221206() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.infoMap = new HashMap<>();
        init();
        System.out.println(getFirstPelin());
    }

    public void init() throws IOException {
        for(int i = 'A'; i <= 'Z'; i++){
            this.infoMap.put((char)i, new Alphabet((char)i));
        }

        this.str = this.br.readLine();
        for(int i = 0; i < this.str.length(); i++){
            char c = this.str.charAt(i);
            Alphabet alphaInfo = this.infoMap.get(c);
            alphaInfo.count = alphaInfo.count + 1;
        }
    }

    public String getFirstPelin(){
        //리스트 반복문을 돌리면서
        boolean isEven = this.str.length() % 2 == 0;
        int oddStack = 0;
        char[] charArr = new char[this.str.length()];
        int charArrIdx = 0;

        Iterator<Character> iter = this.infoMap.keySet().iterator();
        while(iter.hasNext()){
            Alphabet alpha = this.infoMap.get(iter.next());
            int count = alpha.count;
            char c = alpha.c;
            if(isEven){
                if(count % 2 != 0){
                    return "I'm Sorry Hansoo";
                }
            }else{
                if(count % 2 != 0){
                    oddStack++;
                    if(oddStack > 1){
                        return "I'm Sorry Hansoo";
                    }
                }
            }

            if(count > 0){
                for(int i = 0; i < ( count % 2 == 0 ? count / 2 : count / 2 + 1); i++){
                    charArr[charArrIdx++] = c;
                }
            }

            for(int i = charArrIdx; i < charArr.length; i++){
                charArr[i] = 'a';
            }
        }

        Arrays.sort(charArr);

        for(int i = charArr.length -1 ; i > 0; i--){
            if(charArr[i] != 'a'){
                break;
            }else{
                charArr[i] = charArr[charArr.length - i - 1];
            }
        }

        return String.valueOf(charArr);
    }

    public static void main(String[] args) throws IOException {
        Boj1213_221206 boj1213_221206 = new Boj1213_221206();
    }
}

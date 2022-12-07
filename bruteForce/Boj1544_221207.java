package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj1544_221207 {

    private BufferedReader br;
    private List<String> list, dict;

    private int num;

    public Boj1544_221207() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.num = Integer.parseInt(this.br.readLine());
        this.list = new ArrayList<>();
        this.dict = new ArrayList<>();
        this.dict.add("INIT");
        init();
        System.out.println(getDiffWords());
    }

    public void init() throws IOException {
        for(int i = 0; i < this.num; i++){
            String str = this.br.readLine();
            this.list.add(str);
        }
    }

    public int getDiffWords() throws IOException {
        int diffWords = 0;

//        System.out.println("list : " + this.list);

        for(String str : this.list){

//            System.out.println("dict : " + this.dict);
            int dictSize = this.dict.size();
            for(int i = 0; i < dictSize; i++){
                String dictWord = this.dict.get(i);
                if(str.length() == dictWord.length()){
                    if(getIsSame(str, dictWord)){
                        //같다!
                        break;
                    }
                }
                if(i == dictSize -1){
                    this.dict.add(str);
                }

            }

        }

//        System.out.println(this.dict);

        return this.dict.size() - 1;
    }

    public boolean getIsSame(String str1, String str2){
//        System.out.println(str1 + ", " + str2);
        boolean isSame = false;
        char start = str2.charAt(0);
//        System.out.println("start char : " + start);
        if(str1.indexOf(start) < 0){
            return false;
        }else{
            char[] charArr = new char[str1.length()];
            int startIdx = str1.indexOf(str2.charAt(0));
//            System.out.println("startIdx : " + startIdx);

            for(int i = 0; i < str1.length(); i++){
                if(startIdx > str1.length() - 1){
                    startIdx = 0;
                }
                charArr[i] = str1.charAt(startIdx++);
//                System.out.printf(" %c", charArr[i]);
            }
            String loopedStr1 = String.valueOf(charArr);

            if(loopedStr1.equals(str2)){
                isSame = true;
//                System.out.println("\t same!");
            }

        }

        return isSame;
    }

    public static void main(String[] args) throws IOException {
        Boj1544_221207 boj1544_221207 = new Boj1544_221207();
    }

}

package sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Boj1141_230101 {

    private BufferedReader br;
    private int num;
    private List<String> strList;

    public Boj1141_230101() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
        System.out.println(getXSetMaxNum(this.strList));
    }

    public void init() throws IOException {
        this.num = Integer.parseInt(this.br.readLine());
        this.strList = new ArrayList<>();
        for (int i = 0; i < this.num; i++) {
            this.strList.add(this.br.readLine());
        }

        this.strList = this.strList.stream().sorted((str1, str2) ->{
            if(str1.length() > str2.length())return -1;
            else if(str1.length() == str2.length())return str1.compareTo(str2);
            else return 1;
        }).collect(Collectors.toList());
    }
    //길이 순으로 정렬해 놓고 가장 긴 문자열을 집어넣고 접두어가 되지 않는 다른 문자열들만 추가
    //정렬할 때 길이가 동일하다면 그냥 사전 순?

    public int getXSetMaxNum(List<String> strList){
        //N은 50보다 작다.
        List<String> xSetList = new ArrayList<>();
        xSetList.add(strList.get(0));
        for (int i = 0; i < strList.size(); i++) {
            String target = strList.get(i);
            boolean ableXset = true;
            for (int j = 0; j < xSetList.size(); j++) {
                String pivot = xSetList.get(j);
                if (pivot.startsWith(target)) {
                    ableXset = false;
                    break;
                }
            }
            if(ableXset)xSetList.add(target);
        }

        return xSetList.size();
    }


    public static void main(String[] args) throws IOException {
        Boj1141_230101 boj1141_230101 = new Boj1141_230101();
    }

}

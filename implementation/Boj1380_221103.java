package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Boj1380_221103 {

    private BufferedReader br;
    private int caseNum;
    private List<String> list;

    public Boj1380_221103() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        getResult();
    }

    public void setCaseNum() throws IOException {
        this.caseNum = Integer.parseInt(this.br.readLine());
    }

    public void setList() throws IOException {
        this.list = new ArrayList<>();
        for(int i = 0; i < this.caseNum; i++){
            this.list.add(this.br.readLine());
        }
        //이름 입력완료
    }

    public void getResult() throws IOException {
        //Map에 순서랑 돌려받은 횟수 > 다 돌려주고 나서 하나가 없는 사람의 순서
        int scenario = 1;
        while(true){
            setCaseNum();
            if(this.caseNum == 0){
                System.exit(0);
            }else{
                setList();
                Map<Integer, Integer> recallMap = getInitMap(this.caseNum);
                for(int j = 0; j < (this.caseNum*2 - 1); j++){
                    String recallStr = this.br.readLine();
                    int stuSeq = Integer.parseInt(recallStr.split(" ")[0]);
                    recallMap.put(stuSeq, recallMap.get(stuSeq)+1);
                }
                for(int i = 1; i <= this.caseNum; i++){
                    if(recallMap.get(i) != 2){
                        System.out.println(scenario + " " + this.list.get(i-1));
                    }
                }

            }
            scenario++;
        }
    }

    public Map<Integer, Integer> getInitMap(int lastIdx){
        Map<Integer, Integer> initMap = new HashMap<>();
        for(int i = 1; i <= lastIdx; i++){
            initMap.put(i, 0);
        }

        return initMap;
    }

    public static void main(String[] args) throws IOException {
        Boj1380_221103 boj1380_221103 = new Boj1380_221103();
    }

}

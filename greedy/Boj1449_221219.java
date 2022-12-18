package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Boj1449_221219 {

    private BufferedReader br;
    private int sankNum, tapeLen;
    private List<Integer> sankIdx;

    public Boj1449_221219() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
        System.out.println(getTapeNum());
    }

    public void init() throws IOException {
        String[] initTemp = this.br.readLine().split(" ");
        this.sankNum = Integer.parseInt(initTemp[0]);
        this.tapeLen = Integer.parseInt(initTemp[1]);

        this.sankIdx = new ArrayList<>();
        initTemp = this.br.readLine().split(" ");
        for (int i = 0; i < this.sankNum; i++) {
            this.sankIdx.add(Integer.parseInt(initTemp[i]));
        }

        this.sankIdx = this.sankIdx.stream().sorted().collect(Collectors.toList());
    }

    public int getTapeNum(){
        int tapeNum = 1;
        double startIdx = this.sankIdx.get(0) - 0.5;
        double endIdx = startIdx + this.tapeLen;

        for(int idx : this.sankIdx){
//            System.out.println("idx : " + idx);
            if(idx >= startIdx && idx <= endIdx)continue;
            else{
                //endIdx가 -0.5 부분까지 커버 해줬을 수도 있음. 커버된 부분 부터 다시 시작
//                System.out.println("more tape");
                startIdx = endIdx;
                if(idx - 0.5 > startIdx)startIdx = idx - 0.5;
                endIdx = startIdx + this.tapeLen;
//                System.out.println("startIdx : " + startIdx + ", endIdx : " + endIdx);
                tapeNum++;
            }
        }

        return tapeNum;
    }

    public static void main(String[] args) throws IOException {
        //물이 새는 곳의 위치는 1000보다 작은 자연수이다.
        //겹쳐서 붙이는 것도 가능하다.
        //몇개씩 묶이는 지 판단해야 한다.
        //1,2랑 묶일 수 있었던 이유는 1-0.5 부터 시작해서 2.5까지 길이 2짜리로 커버가 됐기 때문에
        Boj1449_221219 boj1449_221219 = new Boj1449_221219();

    }

}

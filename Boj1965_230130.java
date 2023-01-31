import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Boj1965_230130 {

    private BufferedReader br;
    private int boxNum;
    private String[] boxSizeArr;
    private static final int ASC = 1;
    private static final int DESC = -1;

    public Boj1965_230130() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
        System.out.println(getMaxBoxesNum(this.boxNum, this.boxSizeArr));
    }

    public void init() throws IOException {
        this.boxNum = Integer.parseInt(this.br.readLine());
        this.boxSizeArr = this.br.readLine().split(" ");

    }

    public int getMaxBoxesNum(int boxNum, String[] boxSizeArr) {
        List<Integer> leftParts = new ArrayList<>();
        List<Integer> rightParts = new ArrayList<>();

        leftParts.add(0);
        rightParts.add(boxSizeArr.length - 1);
        //가장 왼쪽이랑 가장 오른쪽은 left right part로 두는게 낫지 않을까요.

        for (int i = 1; i < boxSizeArr.length - 1; i++) {
            int current = Integer.parseInt(boxSizeArr[i]);
            int next = Integer.parseInt(boxSizeArr[i + 1]);
            //값이 아닌 idx를 넣어줘야 한다.
            if (current < next) {
                rightParts.add(i);
            }else if(current > next){
                leftParts.add(i);
            }
        }

        System.out.println("left idx : " + leftParts);
        System.out.println("right idx : " + rightParts);

        int maxBoxesNum = 1;
        for (int leftIdx : leftParts) {
            for (int rightIdx : rightParts) {
                int total = getTotalBoxNum(boxSizeArr, leftIdx, rightIdx);
                if(total > maxBoxesNum)maxBoxesNum = total;
            }
        }

        return maxBoxesNum;
    }

    public int getTotalBoxNum(String[] boxSizeArr, int startIdx, int endIdx){
        System.out.println("start idx : " + startIdx);
        System.out.println("end idx : " + endIdx);

        if(startIdx >= endIdx)return 1;
        int totalBoxNum = 1;
        int max = Integer.parseInt(boxSizeArr[startIdx]);
        for (int i = startIdx + 1; i <= endIdx; i++) {
            //startIdx는 무조건 넣고시작
            if (Integer.parseInt(boxSizeArr[i]) > max) {
                max = Integer.parseInt(boxSizeArr[i]);
                totalBoxNum++;
            }
        }

        return totalBoxNum;
    }



    public static void main(String[] args) throws IOException {
        Boj1965_230130 boj1965_230130 = new Boj1965_230130();
    }

}

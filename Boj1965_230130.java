import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj1965_230130 {

    private BufferedReader br;
    private int boxNum;
    private String[] boxSizeArr;

    public Boj1965_230130() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
        System.out.println(getMaxBoxesNum());
    }

    public void init() throws IOException {
        this.boxNum = Integer.parseInt(this.br.readLine());
        this.boxSizeArr = this.br.readLine().split(" ");

    }

    public int getMaxBoxesNum() {
        int maxBoxNum = 1;
        int max = -1;
        int startIdx = -1;
        int prev = -1;
        for(int i = 0; i < this.boxSizeArr.length - 1; i++){
            if(Integer.parseInt(this.boxSizeArr[i]) < Integer.parseInt(this.boxSizeArr[i+1])){
                max = Integer.parseInt(this.boxSizeArr[i]);
                startIdx = i;
                prev = max;
                break;//시작점을 찾았으면 break한다.
            }
        }
        if (max == -1) {
            System.out.println("only descent...!");
            return maxBoxNum; //계속 박스사이즈가 작아져도 마지막 한개는 넣을 수 있으므로 1을 return 해야한다.
        }

        List<Integer> boxSizeList = new ArrayList<>();
        boxSizeList.add(prev);

        System.out.println("start idx : " + startIdx);
        System.out.println("start max : " + max);

        for (int i = startIdx + 1; i < this.boxSizeArr.length; i++) {
            //일단 prev보다 크다면 박스에 넣어버릴 수 있다.
            int currentSize = Integer.parseInt(this.boxSizeArr[i]);
            if(currentSize > prev){
                if(boxSizeList.size() > 1 && boxSizeList.get(boxSizeList.size() - 1) > currentSize){
                    boxSizeList.remove(boxSizeList.size() - 1);
                }
                //무조건 하나에서 시작한다. prev부터.
                boxSizeList.add(currentSize);
                prev = boxSizeList.get(boxSizeList.size() - 2);
            }

        }


        return  boxSizeList.size();
    }


    public static void main(String[] args) throws IOException {
        Boj1965_230130 boj1965_230130 = new Boj1965_230130();
    }

}

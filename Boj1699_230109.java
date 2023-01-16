import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Boj1699_230109 {

    private BufferedReader br;
    private int num;

    public Boj1699_230109() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.num = Integer.parseInt(this.br.readLine());
        System.out.println(getMinSumEls(this.num));
    }

    public int getMinSumEls(int goal) {
        int minNum = 0;
        boolean isInitMinVal = true;

        Queue<List<Integer>> queue = new LinkedList<>();
        //init
        for (int i = (int) Math.floor(Math.sqrt(goal)); i >= 1; i--) {
            List<Integer> initList = new ArrayList<>();
            initList.add(i);
            queue.offer(initList);
        }
        //

        while (!queue.isEmpty()) {
            //맨 뒤에 있는 수 이하의 추가 수를 넣어줘야 한다.
            List<Integer> target = queue.poll();
//            System.out.println("target : " + target);
            int last = target.get(target.size() - 1);
            int squareSum = target.stream().mapToInt(i -> i * i).sum();
            if (squareSum == goal) {
                if(isInitMinVal){
                    minNum = target.size();
                    isInitMinVal = false;
                }else {
                    if(minNum > target.size()) minNum = target.size();
                }
            }
            for (int i = last; i >= 1; i--) {
                boolean isPutAble = squareSum + (i*i) > goal ? false : true;
                if (isPutAble) {
                    target.add(i);
                    queue.offer(target);
                }
            }
        }

        return minNum;
    }

    public List<Integer> clone(List<Integer> pivot) {
        List<Integer> clonedList = new ArrayList<>();
        for (int el : pivot) {
            clonedList.add(el);
        }
        return clonedList;
    }


    public static void main(String[] args) throws IOException {
        Boj1699_230109 boj1699_230109 = new Boj1699_230109();

    }
}

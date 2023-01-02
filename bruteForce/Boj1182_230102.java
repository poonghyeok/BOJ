package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Boj1182_230102 {

    public class Subset{

        public List<Integer> extendedIdxes;

        public Subset() {
            this.extendedIdxes = new ArrayList<>();
        }

        public Subset(List<Integer> extendedIdxes) {
            this.extendedIdxes = new ArrayList<>();
            for (int idx : extendedIdxes) {
                this.extendedIdxes.add(idx);
            }
        }

        public int getCurrentSum(List<Integer> intList) {
            int sum = 0;
            for (int el : this.extendedIdxes) {
                sum += intList.get(el);
            }

            return sum;
        }

        public int getCurrentMax() {
            int max = 0;
            for (int el : this.extendedIdxes) {
                if(el > max)max = el;
            }
            return max;
        }
    }

    private BufferedReader br;
    private int N,S;
    private List<Integer> list;

    public Boj1182_230102() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
        System.out.println(getSetNumMeetingRequiredNum());
    }

    public void init() throws IOException {
        String[] strTemp = this.br.readLine().split(" ");
        this.N = Integer.parseInt(strTemp[0]);
        this.S = Integer.parseInt(strTemp[1]);
        this.list = Arrays.stream(this.br.readLine().split(" ")).mapToInt(str -> Integer.parseInt(str)).boxed().collect(Collectors.toList());
    }

    public int getSetNumMeetingRequiredNum() {
        int num = 0;

        Queue<Subset> sets = new LinkedList<>();

        //초기화
        for (int i = 0; i < this.list.size(); i++) {
            Subset subset = new Subset();
            subset.extendedIdxes.add(i);
            sets.offer(subset);
        }

        while (!sets.isEmpty()) {
            Subset subset = sets.poll();
//            System.out.println("subset.extendedIdxes : " + subset.extendedIdxes);
//            System.out.println("current sum : " + subset.getCurrentSum(this.list));
            if(subset.getCurrentSum(this.list) == this.S) num++;
            int subsetMax = subset.getCurrentMax();
            for (int i = 0; i < this.list.size(); i++) {
                if (subsetMax < i) {
                    Subset childSet = new Subset(subset.extendedIdxes);
                    childSet.extendedIdxes.add(i);
                    sets.offer(childSet);
                }
            }
        }

        return num;
    }

    public static void main(String[] args) throws IOException {
        Boj1182_230102 boj1182_230102 = new Boj1182_230102();

    }

}

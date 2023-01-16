package dynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Boj1699_230109 {

    public class SquareSum{
        public int stack;
        public List<Integer> vals;
        public final int goal;
        public int min;
        public SquareSum(int stack, int initVal, int goal) {
            this.stack = stack;
            this.vals = new ArrayList<>();
            this.vals.add(initVal);
            this.goal = goal;
            this.min = initVal;
        }

        public void pushVal(int input) {
            this.vals.add(input);
            if (input < min) {
                this.min = input;
            }
        }

        public int getSum(){
            int sum = 0;
            for (int val : vals) {
                sum += val;
            }

            return sum;
        }

        public int getRestToGoal(){
            return this.goal - this.getSum();
        }

        public int getMaxSqrt(){
            return (int) Math.floor(Math.sqrt(this.getRestToGoal()));
        }

    }
    private BufferedReader br;
    private int num;
    private Queue<SquareSum> queue;

    public Boj1699_230109() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.num = Integer.parseInt(this.br.readLine());
        this.queue = new LinkedList<>();
    }

    public int getMinSquareSum() {
        boolean initMin = true;
        int minVal = -1;

        int startSqrt = (int)Math.floor(Math.sqrt(this.num));
        //init;
        for (int i = startSqrt; i >= 1; i--) {
            SquareSum squareSum = new SquareSum(1, i, this.num);
            queue.offer(squareSum);
        }

        while (!queue.isEmpty()) {
            SquareSum currentComb = queue.poll();
            if (currentComb.getRestToGoal() > 0) {
                for (int i = currentComb.getMaxSqrt(); i >= 1; i--) {

                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {

    }

}


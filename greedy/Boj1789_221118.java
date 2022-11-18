package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1789_221118 {

    private BufferedReader br;

    private Long sum;
    private Stack<Integer> stack;

    public Boj1789_221118() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.sum = Long.parseLong(this.br.readLine());
        this. stack = new Stack<>();
        System.out.println(getMin());
    }

    public int getMin(){
        Long currentSum = 0L;
        this.stack.add(0);
        Long goal = this.sum;
        int addNext = 1;
        while(true){
            int currentNum = stack.peek();
//            System.out.println("currentNum : " + currentNum);
            int nextNum = currentNum + addNext;
//            System.out.println("nextNum : "+nextNum);
//            System.out.println("goal - ( currentSum + nextNum) : " + (goal - ( currentSum + nextNum)));
            if( goal - ( currentSum + nextNum) == 0 ){
                this.stack.add(nextNum);
                break;
            }else if( (currentSum + nextNum) < goal){
                this.stack.add(nextNum);
                currentSum += nextNum;
            }else{
                int pop = stack.pop();
                currentSum -= pop;
                addNext++;
            }
        }

        return stack.size() -1;
    }

    public static void main(String[] args) throws IOException {
        Boj1789_221118 boj1789_221118 = new Boj1789_221118();
    }

}

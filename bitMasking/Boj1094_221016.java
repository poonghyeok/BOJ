package bitMasking;

import java.util.*;

public class Boj1094_221016 {

    private int legnth;
    private Scanner sc;
    private Stack<Integer> binaryStack;

    public Boj1094_221016(){
        this.sc = new Scanner(System.in);
        this.binaryStack = new Stack<>();
        getResult();

    }

    public void setLength(){
        this.legnth = this.sc.nextInt();
    }
    public int getLegnth() {
        return this.legnth;
    }

    public void setBinaryStack(){

        int val = getLegnth();
        while(val > 0 ){
            this.binaryStack.add(val % 2);
            val =  (val/2);
        }
    }

    public Stack<Integer> getBinaryStack(){
        return this.binaryStack;
    }

    public int getStackIntegration() {
        int sum = 0;
        Iterator<Integer> stackIter = getBinaryStack().iterator();

        while(stackIter.hasNext()) {
            sum += stackIter.next();
        }

        return sum;
    }

    public void getResult(){
        setLength();
        setBinaryStack();
        System.out.println(getStackIntegration());
    }

    public static void main(String[] args){
        Boj1094_221016  me = new Boj1094_221016();

    }

}

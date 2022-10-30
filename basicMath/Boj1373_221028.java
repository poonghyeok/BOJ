package basicMath;

import java.util.Scanner;
import java.util.Stack;

public class Boj1373_221028 {

    private Scanner sc;
    private Stack<Integer> octalStack;
    private Stack<Integer> binaryStack;
    private String binaryStr;

    public Boj1373_221028(){
        this.sc = new Scanner(System.in);
        this.octalStack = new Stack<>();
        this.binaryStack = new Stack<>();

        setBinaryStr();
        setBinaryStack();
        setOctalStack();
        printOctalStack(this.octalStack);
    }

    public void setBinaryStr(){
        this.binaryStr = this.sc.next();
    }

    public void setBinaryStack(){
        for(int i = 0; i <this.binaryStr.length(); i++){
            int element = Integer.parseInt(this.binaryStr.substring(i,i+1));
            this.binaryStack.push(element);
        }
    }

    public void setOctalStack(){
        int popNum = 0;
        int binToOct = 0;
        while(this.binaryStack.size() > 0){
            int binNum = this.binaryStack.pop();
            popNum++;

            if(popNum == 1){
                binToOct += binNum*Math.pow(2,0);
            }else if (popNum == 2){
                binToOct += binNum*Math.pow(2,1);
            }else if (popNum == 3){
                binToOct += binNum*Math.pow(2,2);
                this.octalStack.push(binToOct);
                popNum = 0;
                binToOct = 0;

                if(this.binaryStack.size() == 0){
                    //다 꺼냈다면 즉시종료.
                    return;
                }
            }

            if(this.binaryStack.size() == 0) {
                //다 꺼냈다면 계산하던 것을 넣어줘야 한다.
                this.octalStack.push(binToOct);
            }
        }
    }

    public void printOctalStack(Stack<Integer> octalStack){
        while(octalStack.size() > 0){
            System.out.print(octalStack.pop());
        }
    }

    public static void main(String[] args){
        Boj1373_221028 boj1373_221028 = new Boj1373_221028();
    }

}

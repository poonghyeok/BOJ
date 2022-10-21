package greedy;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Boj1343_221020 {

    //X를 덮는다.
    //.은 덮으면 안된다.
    //2개연속으로 이어지면 일단 B로 덮는다.
    //근데 4개연속이 된다면 A로 덮는다.
    //BB BB가 되면 AAAA로 교체해야되는거죠.
    private Queue<Character> queue;
    private String str;
    private Scanner sc;

    public Boj1343_221020(){
        this.queue = new ArrayDeque<>();
        this.sc = new Scanner(System.in);

        setStr();
        setQueue();
        Queue<Character> midQueue = getSecondQueue('B', this.queue);
        Queue<Character> lastQueue = getSecondQueue('A', midQueue);
        printQueue(lastQueue);

    }
    public void setStr(){
        this.str = this.sc.next();
    }

    public void setQueue(){
        for(int i = 0; i < this.str.length(); i++){
            queue.add(this.str.charAt(i));
        }
    }

    public Queue<Character> getSecondQueue(char afterChar, Queue<Character> paramQue){
        Queue<Character> temp = new ArrayDeque<>();
        int initSize = paramQue.size();

        char latest = 'a';
        boolean nonx = true;
        int changeNum = 0;

        for(int i = 0 ; i < initSize; i++){
            if(paramQue.peek() == '.'){
                temp.add(paramQue.poll());
            }else{
                if(nonx){
                    char pick = paramQue.poll();
                    latest = pick;
                    nonx = false;
                }else{
                    if(latest == paramQue.peek()){
                        paramQue.poll();
                        temp.add(afterChar);
                        changeNum++;
                        latest = '!';
                    }else{
                       latest = paramQue.poll();
                       if(afterChar == 'A'){
                           temp.add(latest);
                       }

                    }
                }
            }
        }

        if(afterChar == 'B'){
            if(initSize != temp.size()+changeNum){
                System.out.println(-1);
                System.exit(0);
            }
        }

        return temp;
    }

    /*public Queue<Character> getLastQueue(Queue<Character> midQueue){
        int initsize = midQueue.size();

        for(int i = 0; i < initsize; i++){
            if(queue.peek() == '.'){
                System.out.print(queue.poll());
            }else{

            }
        }
    }*/

    public void printQueue(Queue<Character> queue){
        int initSize = queue.size();

        for(int i = 0; i < initSize; i++){
            if(queue.poll() == 'A'){
                System.out.print("AAAA");
            }else if(queue.poll() == 'B'){
                System.out.print("BB");
            }else{
                System.out.print(".");
            }

        }
    }


    public static void main(String[] args){
        Boj1343_221020 boj1343_221020 = new Boj1343_221020();
    }

}

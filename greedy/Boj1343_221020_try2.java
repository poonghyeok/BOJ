package greedy;

import java.util.*;

public class Boj1343_221020_try2 {

    private Scanner sc;
    private String str;
    private Queue<Character> queue;
    private List<Character> list;

    public Boj1343_221020_try2(){
        this.sc = new Scanner(System.in);


    }

    public void setStr(){
        this.str = this.sc.next();
    }

    public void setQueue(){
        this.queue = new ArrayDeque<>();
        for(int i = 0; i < this.str.length(); i++){
            this.queue.add(this.str.charAt(i));
        }
    }

    public void setList(){
        this.list = new ArrayList<>();
        int initQueueSize = this.queue.size();

        while(this.queue.size() > 0){
            this.list.add(this.queue.poll());
        }

    }

    public void checkList(List<Character> paramList){
        char before = '!';
        for(int i = 0; i < paramList.size(); i++){
            if(paramList.get(i) == before){
                char c= paramList.get(i);
            }

        }
    }

    public static void main(String[] args){
        List<Character> temp = new ArrayList<>();
        temp.add('a');
        temp.add('b');
        temp.add('c');
        temp.add('c');
        System.out.println((char)temp.remove(0));
    }

}

package sep07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Boj1620_220907 {
    private int originNum, callNum;
    private Map<String, Integer> pocketBook;
    private Map<Integer, String> reverseBook;
    private Scanner sc;

    //Generator
    public Boj1620_220907(){
        this.pocketBook = new HashMap<>();
        this.reverseBook = new HashMap<>();
        this.sc = new Scanner(System.in);
    }
    //

    //Getter, Setter
    public void setOriginNum() {
        this.originNum = sc.nextInt();
    }
    public int getOriginNum(){
        return this.originNum;
    }

    public void setCallNum(){
        this.callNum = sc.nextInt();
    }
    public int getCallNum(){
        return this.callNum;
    }

    public void setPocketBook(){
        for(int i = 0; i < this.getOriginNum(); i++){
            String input = sc.next();
            this.pocketBook.put(input, i+1);
            this.reverseBook.put(i+1, input);
        }
    }
    public Map<String, Integer> getPocketBook(){
        return this.pocketBook;
    }

    public Map<Integer, String> getReverseBook(){
        return this.reverseBook;
    }

    //
    public void getResponse(){
        for(int i = 0; i < this.getCallNum(); i++){
            String call = sc.next();
            char first = call.charAt(0);
            if(first < 65){
                //number call case
                System.out.println(this.getReverseBook().get(Integer.parseInt(call)));
            }else{
                //string call case
                System.out.println(this.getPocketBook().get(call));
            }
        }
    }

    public void mainProcess(){
        this.setOriginNum();
        this.setCallNum();
        this.setPocketBook();
        this.getResponse();
    }

    public static void main(String[] args){
        Boj1620_220907 me = new Boj1620_220907();
        me.mainProcess();
    }
}

package bruteForce;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj1251_221018 {

    private String str;
    private Scanner sc;
    private List<Character> list;

    public Boj1251_221018(){
        this.sc = new Scanner(System.in);
        this.list = new ArrayList<>();
        setStr();
        setList();
        getResult();
    }

    public void setStr(){
        this.str = this.sc.next();
    }
    public String getStr(){
        return this.str;
    }

    public void setList(){
        for(int i = 0; i < getStr().length(); i++){
            list.add(getStr().charAt(i));
        }
    }
    public List<Character> getList(){
        return this.list;
    }

    public void getResult(){
        int first = 0;
        int second = 0;
        //0번부터 first까지 첫번째
        //first+1 부터 second까지 두번째
        //second+1 부터 list.length-1 까지 세번째
        //

        //firstGroup
        char firstGroupMin = getList().get(0);
        for(int i = 0; i < getList().size() - 2; i++){
            if(firstGroupMin > getList().get(i)){
                firstGroupMin = getList().get(i);
                first = i;
            }
        }

        second = first + 1;
        char secondGroupMin = getList().get(first+1);
        for(int i = first+1; i < getList().size() - 1; i++){
            if(secondGroupMin > getList().get(i)){
                secondGroupMin = getList().get(i);
                second = i;
            }
        }

        StringBuffer sb = new StringBuffer();

        for(int i = first; i >= 0; i--){
            sb.append(getList().get(i));
        }
        for(int i = second; i >= first+1; i--){
            sb.append(getList().get(i));
        }
        for(int i = getList().size()-1; i >= second+1; i--){
            sb.append(getList().get(i));
        }

        System.out.println(sb.toString());
    }



    public static void main(String[] args){

        Boj1251_221018 boj1251_221018 = new Boj1251_221018();

    }

}

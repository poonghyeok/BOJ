package setAndMap;

import java.util.*;

public class Baek10815_2209906 {

    private int cardNum, tryNum;
    private Map<Integer, Integer> cardList, tryList, resultList;
    private Scanner sc;

    //Generator
    public Baek10815_2209906(){
        this.cardList = new HashMap<>();
        this.tryList = new HashMap<>();
        this.resultList = new HashMap<>();
        this.sc = new Scanner(System.in);
    }
    //

    //getter,setter
    public void setCardNum(){
        int cardNum = sc.nextInt();
        this.cardNum = cardNum;
    }
    public int getCardNum() {
        return this.cardNum;
    }
    public void setTryNum(){
        int tryNum = sc.nextInt();
        this.tryNum = tryNum;
    }
    public int getTryNum(){
        return this.tryNum;
    }

    public void setCardList(){
        for(int i = 0 ; i < this.getCardNum(); i++){
            this.cardList.put(sc.nextInt(), 1);
        }
    }

    public Map<Integer, Integer> getCardList(){
        return this.cardList;
    }

    public void setTryList(){
        for(int i = 0 ; i < this.getTryNum(); i++){
            this.tryList.put(i, sc.nextInt());
        }
    }

    public Map<Integer, Integer> getTryList(){
        return this.tryList;
    }

    public void printResult(){
        for(int i = 0; i < this.getTryNum(); i++){
            int tryEle = this.getTryList().get(i);
            Optional<Integer> optional = Optional.ofNullable(this.getCardList().get(tryEle));
            if(optional.isPresent()){
                System.out.print(1+" ");
            }else{
                System.out.print(0+" ");
            }
        }
    }
    public void mainProcess(){
//        System.out.println("card num : ");
        this.setCardNum();
//        System.out.println("card list : ");
        this.setCardList();
//        System.out.println("try num : ");
        this.setTryNum();
//        System.out.println("try list : ");
        this.setTryList();
//        System.out.println("\n 결과 : ");
        this.printResult();
    }

    public static void main(String[] args){
        Baek10815_2209906 me = new Baek10815_2209906();
        me.mainProcess();
    }
}

package sep06;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Baek10815_2209906 {

    private int cardNum, tryNum;
    private List<Integer> cardList, tryList, resultList;
    private Scanner sc;

    //Generator
    public Baek10815_2209906(){
        this.cardList = new LinkedList<>();
        this.tryList = new LinkedList<>();
        this.resultList = new LinkedList<>();
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
            this.cardList.add(sc.nextInt());
        }
    }

    public List<Integer> getCardList(){
        return this.cardList;
    }

    public void setTryList(){
        for(int i = 0 ; i < this.getTryNum(); i++){
            this.tryList.add(sc.nextInt());
        }
    }

    public List<Integer> getTryList(){
        return this.tryList;
    }

    public void setResultList(){
        for(int i = 0; i < this.getTryNum(); i++){
            int tryEle = this.getTryList().get(i);
            if(this.getCardList().indexOf(tryEle) > -1){
                this.resultList.add(1);
            }else{
                this.resultList.add(0);
            }
        }
    }
    //

    public void toStringResultList(){
        for(int i = 0; i < this.getTryNum(); i++){
            System.out.print(this.resultList.get(i)+" ");
        }
    }

//    public void printResult(){
//        for(int i = 0; i < this.getTryNum(); i++){
//            int tryEle = this.getTryList().get(i);
//            if(this.getCardList().indexOf(tryEle) > -1){
//                System.out.print(1+" ");
//            }else{
//                System.out.print(0+" ");
//            }
//        }
//    }
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
//        this.printResult();
        this.setResultList();
        this.toStringResultList();
    }

    public static void main(String[] args){
        Baek10815_2209906 me = new Baek10815_2209906();
        me.mainProcess();
//        Scanner scTmp = new Scanner(System.in);
//        List<Integer> listTmp = new ArrayList<>();
//        int numtemp = 0;
//        System.out.println("num : ");
//        numtemp = scTmp.nextInt();
//        System.out.println("card list : ");
//        for(int i = 0; i < numtemp; i++){
//            listTmp.add(scTmp.nextInt());
//        }
//        for(int i = 0; i < numtemp; i++){
//            System.out.print(listTmp.get(i)+" ");
//        }
    }
}

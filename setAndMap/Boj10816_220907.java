package setAndMap;

import java.util.*;

public class Boj10816_220907 {

    //Declaration
    private int callNum, cardNum;

    private Map<Integer, Integer> callMap, cardMap, cardKeyList;

    private Scanner sc;
    //

    //Generator
    public Boj10816_220907(){
        this.callMap = new HashMap<>();
        this.cardMap = new LinkedHashMap<>();
        this.sc = new Scanner(System.in);
        this.mainProcess();
    }

    //

    //Getter, Setter
    public void setCallNum() {
        this.callNum = sc.nextInt();
    }

    public int getCallNum() {
        return callNum;
    }

    public void setCardNum() {
        this.cardNum = sc.nextInt();
    }
    public int getCardNum(){
        return this.cardNum;
    }

    public void setCallMap() {
        for(int i = 0; i < this.getCallNum(); i++){
            this.callMap.put(i, sc.nextInt());
        }
    }

    public Map<Integer, Integer> getCallMap() {
        return callMap;
    }

    public void setCardMap() {
        for(int i = 0 ; i < this.getCardNum(); i++){
            int inputNum = sc.nextInt();
            this.cardMap.put(inputNum, 0);
        }
    }

    public Map<Integer, Integer> getCardMap() {
        return this.cardMap;
    }
    //

    //main
    public void getResult(){

        for(int i = 0; i < this.getCallNum(); i++){
            int checkNum = this.getCallMap().get(i);
            Optional<Integer> optional = Optional.ofNullable(this.getCardMap().get(checkNum));
            if(optional.isPresent()){
                int curCount = optional.get();
                this.cardMap.put(checkNum, ++curCount);
            }
        }

        Iterator<Integer> cardMapKeyIter = this.getCardMap().keySet().iterator();
        while(cardMapKeyIter.hasNext()){
            int key = cardMapKeyIter.next();
            System.out.print(this.getCardMap().get(key)+" ");
        }

    }

    public void mainProcess(){
        this.setCallNum();
        this.setCallMap();
        this.setCardNum();
        this.setCardMap();
        this.getResult();
    }
    //

    public static void main(String[] args){
        Boj10816_220907 me = new Boj10816_220907();
    }
}

package sep07;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;

public class Boj14425_220907 {

    private int originNum, tryNum, checkNum;
    private Map<String, Boolean> originMap, tryMap;
    //Scanner
    private Scanner sc;

    //Generator
    public Boj14425_220907(){
        this.checkNum = 0;
        this.originMap = new HashMap<>();
        this.tryMap = new HashMap<>();
        this.sc = new Scanner(System.in);
    }

    //getter, setter
    public void setOriginNum(){
        this.originNum = sc.nextInt();
    }
    public int getOriginNum(){
        return this.originNum;
    }

    public void setTryNum(){
        this.tryNum = sc.nextInt();
    }
    public int getTryNum(){
        return this.tryNum;
    }

    public void setOriginMap() {
        for(int i = 0; i < this.getOriginNum(); i++){
            this.originMap.put(sc.next(), true);
        }
    }
    public Map<String, Boolean> getOriginMap(){
        return this.originMap;
    }

    public void setTryMap() {
        for(int i = 0 ; i < this.getTryNum(); i++){
            this.tryMap.put(sc.next(), true);
        }
    }
    public Map<String,Boolean> getTryMap(){
        return this.tryMap;
    }
    //

    //mainProcess
    public void mainProcess(){
        for(int i = 0; i < this.getTryNum(); i++){
            String keyword = sc.next();
            Optional<Boolean> optional = Optional.ofNullable(this.getOriginMap().get(keyword));
            if(optional.isPresent()){
                this.checkNum++;
            }
        }
        System.out.println(this.checkNum);
    }
    //


    //print result
    public void printResult(){
        setOriginNum();
        setTryNum();
        setOriginMap();
        mainProcess();
    }
    //

    public static void main(String[] args){
        Boj14425_220907 me = new Boj14425_220907();
        me.printResult();
    }

}

package bruteForce;

import java.util.*;

public class Boj7568_220910 {

    //Declaration
    private int num, topX, topY, botX, botY;
    private Map<Integer, Integer> rankMap;
    private Scanner sc;
    //

    //Generator
    public Boj7568_220910(){
        this.sc = new Scanner(System.in);
        this.rankMap = new HashMap<>();
    }
    //

    //Setter,Getter
    public void setNum(){
        this.num = this.sc.nextInt();
    }
    public int getNum() {
        return this.num;
    }

    public void setTopX(int x){
        this.topX = x;
    }
    public int getTopX(){
        return this.topX;
    }

    public void setTopY(int y){
        this.topY = y;
    }
    public int getTopY(){
        return this.topY;
    }

    public void setBotX(int x){
        this.botX = x;
    }
    public int getBotX(){
        return this.botX;
    }

    public void setBotY(int y){
        this.botY = y;
    }
    public int getBotY(){
        return this.botY;
    }

    public void setRankMap(){
        for(int i = 0; i < this.getNum(); i++){
            rankMap.put(i, 1);
        }
    }
    public Map<Integer,Integer> getRankMap(){
        return this.rankMap;
    }
    //

    //increaseRank
    public void increaseRank(int curIdx){
        for(int i =  0; i < curIdx; i++){
            int curVal = this.getRankMap().get(i);
            this.getRankMap().put(i, ++curVal);
        }
    }

    //


    //getResult
    public void getResult(){
        int botRank = 1;

        int stack = 1;
        for(int i = 0; i < this.getNum(); i++){
            if(i == 0){
                int initTopX = sc.nextInt();
                int initTopY = sc.nextInt();
                this.setTopX(initTopX);
                this.setTopY(initTopY);
                this.setBotX(initTopX);
                this.setBotY(initTopY);
            }else{
                int nextX = sc.nextInt();
                int nextY = sc.nextInt();

                if(nextX > this.getTopX() && nextY > this.getTopY()){
                    this.setTopX(nextX);
                    this.setTopY(nextY);
                    increaseRank(i);
                    botRank++;
                }else if(nextX < this.getBotX() && nextY < this.getBotY()){
                    this.setBotX(nextX);
                    this.setBotY(nextY);
                    this.getRankMap().put(i, botRank+stack);
                    stack++;
                }else{
                    this.getRankMap().put(i, botRank);
                    if(nextX > this.getTopX()){
                        this.setTopX(nextX);
                    }else{
                        this.setBotX(nextX);
                    }

                    if(nextY > this.getTopY()){
                        this.setTopY(nextY);
                    }else{
                        this.setBotY(nextY);
                    }
                    stack++;
                }
            }


        }

        for(int i = 0; i < this.getNum(); i++){
            System.out.println(this.getRankMap().get(i)+" ");
        }
    }
    //

    //mainProcess
    public void mainProcess(){
        this.setNum();
        this.setRankMap();
        this.getResult();
    }
    //

    public static void main(String[] args){
        Boj7568_220910 me = new Boj7568_220910();
        me.mainProcess();
    }

}

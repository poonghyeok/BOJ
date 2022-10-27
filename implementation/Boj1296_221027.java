package implementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Boj1296_221027 {

    private String name;
    private int canNum;
    private List<String> candidate;
    private Scanner sc;

    public Boj1296_221027(){
        this.sc = new Scanner(System.in);
        this.candidate = new ArrayList<>();

        setName();
        setCanNum();
        setCandidate();
        getResult();
    }

    public void setName(){
        this.name = this.sc.next();
    }

    public void setCanNum(){
        this.canNum = this.sc.nextInt();
    }

    public void setCandidate(){
        for(int i = 0; i < this.canNum; i++){
            this.candidate.add(this.sc.next());
        }
    }

    public int getWinRate(String main, String candid){
        int numL = 0;
        int numO = 0;
        int numV = 0;
        int numE = 0;

        for(int i = 0; i < main.length(); i++){
            if(main.charAt(i) == 'L'){
                numL++;
            }
            if(main.charAt(i) == 'O'){
                numO++;
            }
            if(main.charAt(i) == 'V'){
                numV++;
            }
            if(main.charAt(i) == 'E'){
                numE++;
            }
        }
        for(int i = 0; i < candid.length(); i++){
            if(candid.charAt(i) == 'L'){
                numL++;
            }
            if(candid.charAt(i) == 'O'){
                numO++;
            }
            if(candid.charAt(i) == 'V'){
                numV++;
            }
            if(candid.charAt(i) == 'E'){
                numE++;
            }
        }

        return ((numL+numO) * (numL+numV) * (numL+numE) * (numO+numV) * (numO+numE) * (numV+numE)) % 100;
    }

    public void getResult(){
        String best = null;
        int bestRate = 0;
        for(int j = 0; j < this.candidate.size(); j++){

            String candi = this.candidate.get(j);

            if( j == 0){
                best = candi;
                bestRate = getWinRate(this.name, candi);
            }else{
                int winRate = getWinRate(this.name, candi);
                if(winRate > bestRate){
                    bestRate = winRate;
                    best = candi;
                }else if(winRate == bestRate){
                    if(compareStr(candi, best) == -1){
                        best = candi;
                        bestRate = winRate;
                    }
                }
            }
        }
        System.out.println(best);
    }

    public int compareStr(String sbj, String obj){
        int len = sbj.length();
        if(obj.length() < len){
            len = obj.length();
        }

        for(int k = 0; k < len; k++){
            if(sbj.charAt(k) < obj.charAt(k)){
                return -1;
            }else if(sbj.charAt(k) > obj.charAt(k)){
                return 1;
            }else{
                continue;
            }

        }
        return 0;
    }



    public static void main(String[] args){
        Boj1296_221027 boj1296_221027 = new Boj1296_221027();
    }

}

package setAndMap;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Boj1269_221005 {

    //Declaration
    private int numA, numB, ambNum, bmaNum;
    private Set<Integer> setA, setB;

    private Scanner sc;
    //

    //Constructor
    public Boj1269_221005(){
        this.sc = new Scanner(System.in);
        this.mainProcess();
    }
    //

    //Getter, Setter
    public void setNumA(){
        this.numA = this.sc.nextInt();
    }
    public int getNumA(){
        return this.numA;
    }

    public void setNumB(){
        this.numB = this.sc.nextInt();
    }
    public int getNumB(){
        return this.numB;
    }

    public void setSetA(){
        this.setA = new HashSet<>();
        for(int i = 0; i < this.getNumA(); i++){
            this.setA.add(sc.nextInt());
        }
    }
    public Set<Integer> getSetA(){
        return this.setA;
    }

    public void setSetB(){
        this.setB = new HashSet<>();
        for(int i = 0; i < this.getNumB(); i++){
            this.setB.add(sc.nextInt());
        }
    }
    public Set<Integer> getSetB(){
        return this.setB;
    }

    public Set<Integer> getCopiedSet(Set<Integer> set){
        Set<Integer> reusultSet = new HashSet<>();
        Iterator<Integer> setIter = set.iterator();

        while(setIter.hasNext()){
            reusultSet.add(setIter.next());
        }

        return reusultSet;
    }

    public void setAmbNum(){
        Iterator<Integer> ambIter = this.getSetB().iterator();
        Set<Integer> tempA = getCopiedSet(this.getSetA());
        //tempA라서 새로운 객체를 생성시킨 뒤에 지울 줄 알았는데, 생성이 아니라 그냥 참조네
        //복사해놓을 방법

        while(ambIter.hasNext()){
            tempA.remove(ambIter.next());
        }

        this.ambNum = tempA.size();
    }

    public int getAmbNum(){
        return this.ambNum;
    }

    public void setBmaNum(){
        Iterator<Integer> bmaIter = this.getSetA().iterator();
        Set<Integer> tempB = getCopiedSet(this.getSetB());

        while(bmaIter.hasNext()){
            tempB.remove(bmaIter.next());
        }

        this.bmaNum = tempB.size();
    }
    public int getBmaNum(){
        return this.bmaNum;
    }
    //

    //getResult
    public void getResult(){
        this.setAmbNum();
        this.setBmaNum();
        System.out.println(this.getAmbNum() + this.getBmaNum());
    }
    //

    //mainProcess
    public void mainProcess(){
        this.setNumA();
        this.setNumB();
        this.setSetA();
        this.setSetB();
        this.getResult();
    }
    //

    public static void main(String[] args){
        Boj1269_221005 me = new Boj1269_221005();
    }

}

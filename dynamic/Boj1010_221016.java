package dynamic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Boj1010_221016 {

    private int caseNum, leftSite, rightSite;
    private List<Integer> combLeft, combRight;
    private Scanner sc;

    public Boj1010_221016() {
        this.sc = new Scanner(System.in);
        setCaseNum();
        getResult();
    }

    public void setCaseNum(){
        this.caseNum = this.sc.nextInt();
    }
    public int getCaseNum(){
        return this.caseNum;
    }

    public void setLeftSite(){
        this.leftSite = this.sc.nextInt();
    }
    public int getLeftSite(){
        return this.leftSite;
    }

    public void setRightSite(){
        this.rightSite = this.sc.nextInt();
    }
    public int getRightSite(){
        return this.rightSite;
    }

    public void setCombLeft(){
        this.combLeft = new ArrayList<>();

        int addNum = 0;
        int rightSiteNum = getRightSite();

        while(addNum < getLeftSite()){
            this.combLeft.add(rightSiteNum);
            rightSiteNum--;
            addNum++;
        }
    }
    public List<Integer> getCombLeft(){
        return this.combLeft;
    }

    public void setCombRight(){
        this.combRight = new ArrayList<>();

        int leftSiteNum = getLeftSite();

        while(leftSiteNum >= 1){
            this.combRight.add(leftSiteNum);
            leftSiteNum--;
        }
    }
    public List<Integer> getCombRight(){
        return this.combRight;
    }

    public int getCombination(){
        setCombLeft();
        setCombRight();

        Iterator<Integer> combRightIter = getCombRight().iterator();
        List<Integer> leftPostDiv = copyList(getCombLeft());
        List<Integer> rightPostDiv = copyList(getCombRight());

        while(combRightIter.hasNext()){

            int compare = combRightIter.next();
            int gob = 1;
            for(int j = compare; j <= getRightSite(); j += compare){

                if(leftPostDiv.indexOf(j) > 0){
                    int rmIdx = leftPostDiv.indexOf(j);
                    leftPostDiv.remove(rmIdx);
                    leftPostDiv.add(gob);
                    int rmIdxRight = rightPostDiv.indexOf(compare);
                    rightPostDiv.remove(rmIdxRight);
                    rightPostDiv.add(1);

                    break;
                }else{
                    gob++;
                }

            }

        }

        return (int)(getListMult(leftPostDiv) / getListMult(rightPostDiv));
    }

    public List<Integer> copyList(List<Integer> listOrigin){
        List<Integer> listNew = new ArrayList<>();
        Iterator<Integer> iter = listOrigin.iterator();

        while (iter.hasNext()){
            listNew.add(iter.next());
        }

        return listNew;
    }

    public Long getListMult(List<Integer> list){
        Long result = 1L;
        Iterator<Integer> multIter = list.iterator();
        while(multIter.hasNext()){
            result *= multIter.next();
        }

        return result;
    }

    public void getResult(){
        for(int i =0; i < getCaseNum(); i++){
            setLeftSite();
            setRightSite();
            System.out.println(getCombination());
        }

    }

    public static void main(String[] args){

        Boj1010_221016 me = new Boj1010_221016();
    }

}

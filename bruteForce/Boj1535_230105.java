package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * [[검색 내용]]
 * 1. List stream max 사용법
 * */
public class Boj1535_230105 {

    private BufferedReader br;
    private int num;
    private List<int[]> coupleList;

    public Boj1535_230105() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
        System.out.println(getMaxPleasure());
    }

    public void init() throws IOException {
        this.coupleList = new ArrayList<>();
        this.num = Integer.parseInt(this.br.readLine());
        String[] stamina = this.br.readLine().split(" ");
        String[] pleasure = this.br.readLine().split(" ");

        for (int i = 0; i < stamina.length; i++) {
            int[] stamPlzCouple = new int[2];
            stamPlzCouple[0] = Integer.parseInt(stamina[i]); //0번이 잃는 체력
            stamPlzCouple[1] = Integer.parseInt(pleasure[i]); //1번이 얻는 기쁨
            this.coupleList.add(stamPlzCouple);
        }

    }

    public int getMaxPleasure(){
        int maxPleasure = 0;

        Stack<List<Integer>> allComb = getAllCombFromIdxZero(this.num);
        while (!allComb.isEmpty()) {
            List<Integer> comb = allComb.pop();

            int futureStamina = 0;
            int futurePleasure = 0;

            for (int i = 0; i < comb.size(); i++) {
                int coupleIdx = comb.get(i);
                int[] couple = this.coupleList.get(coupleIdx);
                futureStamina += couple[0];
                if (futureStamina < 100) {
                    futurePleasure += couple[1];
                }else{
                    break;
                }

                if (i == comb.size() - 1) {
                    //조합에서 끝 idx까지 간 경우만 조합이 의미가 있다.
                    if(futurePleasure > maxPleasure) maxPleasure = futurePleasure;
                }
            }
        }

        return maxPleasure;
        //
    }

    public Stack<List<Integer>> getAllCombFromIdxZero(int lastNum) {
        Stack<List<Integer>> allComb = new Stack<>();

        Queue<List<Integer>> queue = new LinkedList<>();
        for (int i = 0; i < lastNum; i++) {
            List<Integer> initComb = new ArrayList<>();
            initComb.add(i);
            queue.offer(initComb);
        }

        while (!queue.isEmpty()) {
            List<Integer> pivotList = queue.poll();
//            System.out.println(pivotList);
            allComb.push(pivotList);

            for (int i = pivotList.get(pivotList.size() - 1) + 1; i < lastNum; i++) {
                List<Integer> newComb = listClone(pivotList);
                newComb.add(i);
                queue.offer(newComb);
            }
        }

        return allComb;
    }

    public List<Integer> listClone(List<Integer> givenList){
        List<Integer> clonedList = new ArrayList<>();
        for (int i : givenList) {
            clonedList.add(i);
        }

        return clonedList;
    }

    public static void main(String[] args) throws IOException {
        Boj1535_230105 boj1535_230105 = new Boj1535_230105();

    }

}

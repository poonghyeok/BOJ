package basicMath;

import java.util.*;

public class Boj1500_230126 {

    private Scanner sc;
    private int S,K;

    public Boj1500_230126(){
        this.sc = new Scanner(System.in);
        init();
//        System.out.println(getMaxSum(this.S, this.K));
    }

    public void init() {
        this.S = this.sc.nextInt();
        this.K = this.sc.nextInt();
    }

    public Long getMaxSum(int sum, int elNum) {
        Long maxSum = 0l;
        //elNum의 수만큼 원소 개수가 있고 합이 sum인 조합들을 이루고 있는 List 들을 담은 queue를 return 해주자.
        Queue<int[]> combi = new LinkedList<>();

        int initLast = (this.S / this.K);
        for (int i = 1; i <= initLast; i++) {
            int[] initArr = new int[1];
            initArr[0] = i;
            combi.offer(initArr);
        }//초기화 완료.

        while (!combi.isEmpty()) {
            int[] target = combi.poll();
            if(target.length < this.K){
                int pivot = target[target.length - 1];
                while(isAddAble())
            }else{

            }
        }
    }



    public boolean isAddAble(int[] originArr, int newEl) {
        boolean addAble = false;
        int basicSum = (this.K - originArr.length) * newEl;
        int sumOrigin = Arrays.stream(originArr).sum();

        if( sumOrigin + basicSum <= this.S )addAble = true;

        return addAble;
    }

    public static void main(String[] args) {
        Boj1500_230126 boj1500_230126 = new Boj1500_230126();
    }

}

package basicMath;

import java.util.*;

public class Boj1500_230126 {

    private Scanner sc;
    private int S,K;

    public Boj1500_230126(){
        this.sc = new Scanner(System.in);
        init();
        System.out.println(getMaxMulti());
    }

    public void init() {
        this.S = this.sc.nextInt();
        this.K = this.sc.nextInt();
    }

    public long getMaxMulti(){
        long maxMuliti = 1l;
        while (this.K > 0) {
            int partMax = this.S / this.K--; //채워야하는 K에서 하나를 채웠음로 K를 연산과 동시에 줄인다.
            this.S -= partMax; //SUM을 채우는 몫 partMax가 등장했으므로 앞으로 partMax를 빼준만큼의 값을 채우면 된다.
            maxMuliti *= partMax;

        }

        return maxMuliti;
    }

    public static void main(String[] args) {
        Boj1500_230126 boj1500_230126 = new Boj1500_230126();
    }

}

package adhoc;

import java.util.Scanner;

public class Boj1420_221022 {

    private int num;
    private Long long1;
    private Long long2;
    private Scanner sc;

    public Boj1420_221022(){
        this.sc = new Scanner(System.in);
    }

    public void setNum(){
        this.num = this.sc.nextInt();
    }

    public void setLong1(){
        this.long1 = this.sc.nextLong();
    }
    public void setLong2(){
        this.long2 = this.sc.nextLong();
    }

    //어떻게 푸는 것이 좋을까. Queue에 담았다가 다시 풀어내면서 확인한다?
    public boolean canChange(Long l1, Long l2){
        //1은 곱해도 자기 자신이다. 1은 와일드카드로 사용한다.
        //그럼 2*a
        // 3*b, 4*c 근데 4는 a1,a2,a3가 같지 않다라는 말은 나와있지 않기 때문에 1의 사용에 제한이 없어서 자기보다 큰 수는 얼마든지 만들 수 있다.
        // 그럼 자기보다 작은 수를 만들 수 있는 지를 물어보겠지 1*2*3
        // 트리 구조로 쪼개서 가능성을 확인한다? 그 큰수를 ? 1은 1이 될 수 있다. 2는 2가 될 수 있다. 3은 4가 될 수 있따. 4는 4,5가 될 수 있다. 6은, 5,6,7
        // 7은 8, 8은 9,7,6이 될 수 있다. 또 9,7,6 자신보다 큰 것은 관심이 없다. 얼만든지 만들 수 있으니깐
        // 자기보다 작은거 7,6
        boolean result = false;


        return result;
    }

    public static void main(String[] args){

    }

}

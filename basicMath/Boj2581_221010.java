package basicMath;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Boj2581_221010 {

    private int m;
    private int n;
    private Set<Integer> primeNums;

    private Scanner sc;

    public Boj2581_221010(){
        this.sc = new Scanner(System.in);
        this.setM();
        this.setN();
        this.setPrimeNums();
        getResult();

    }

    //Getter,Setter
    public void setM(){
        this.m = sc.nextInt();
    }
    public int getM(){
        return this.m;
    }

    public void setN(){
        this.n = sc.nextInt();
    }
    public int getN(){
        return this.n;
    }

    public void setPrimeNums(){
        this.primeNums = new HashSet<>();
    }
    public Set<Integer> getPrimeNums(){
        return this.primeNums;
    }
    //

    //isiPrime, 소수인지 판별하기
    public boolean isPrime(int num){
        boolean result = true;

        if(num == 1){
            return false;
        }else{
            for(int i = 2; i <= Math.sqrt(num); i++){
                if(num % i == 0){
                    result = false;
                }
            }
        }

        return result;
    }
    //

    //getResult
        //m 이상, n이하의 자연수 중에서 소수들을 찾아서 합과 최소값을 return 해라.
        //소수가 없다면 1을 return 해라.
    public void getResult(){
        int start = this.getM();
        int end = this.getN();

        for(int j = start; j <= end; j++){
            if(isPrime(j)){
                this.primeNums.add(j);
            }
        }

        if(this.getPrimeNums().size() > 0){
            printResult();
        }else{
            System.out.println(-1);
            return ;
        }
    }

    public void printResult(){
        Iterator<Integer> primeIter = this.getPrimeNums().iterator();
        int iterNum = 0;
        int min = 0;
        int tot = 0;
        while(primeIter.hasNext()){
            iterNum++;
            int next = primeIter.next();

            if(iterNum == 1){
                min = next;
            }else{
                if(next < min){
                    min = next;
                }
            }

            tot += next;

        }
        System.out.println(tot);
        System.out.println(min);

        return;
    }
    //

    public static void main(String[] args){
        Boj2581_221010 me = new Boj2581_221010();
    }

}

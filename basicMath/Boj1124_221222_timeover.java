package basicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1124_221222_timeover {

    private BufferedReader br;
    private int a,b;

    public Boj1124_221222_timeover() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        String[] arrTemp = this.br.readLine().split(" ");
        this.a = Integer.parseInt(arrTemp[0]);
        this.b = Integer.parseInt(arrTemp[1]);
        System.out.println(getUnderPrime(this.a, this.b));
    }


    public boolean isPrime(int num) {
        if(num == 1)return false;//1은 소수가 아니다.
        if(num <= 3){
//            System.out.println(num + " is prime! " );
            return true;
        }

        int floorSqrtNum = (int)Math.floor(Math.sqrt(num));

        while(floorSqrtNum > 1){
            if(Math.sqrt(num) == floorSqrtNum)return false; //sqrt가 정수라면 소수가 아니다.
            if(num % floorSqrtNum == 0)return false;
            floorSqrtNum--;
        }

//        System.out.println(num + "is prime!");
        return true;
        //반복문을 돌리지 않고 소수인지 판별했다.
    }

    public boolean isUnderPrime(int num) {
//        System.out.println("@@@@@@@@@ " + num + " underpirme test@@@@@@@@");
        int primeEls = 0;
        int given = num;
        if(isPrime(given)){
//            System.out.println(num + "is so prime that is not underprime..!");
            return false; //소수면 소인수 분해했을 때 소인수 개수가 1개이기 때문에 바로 false가 된다.
        }
        int divStart = (int) Math.floor(Math.sqrt(given));
//        System.out.println("divStart : " + divStart);

        while (given > 1 && divStart > 1) {
            if(!isPrime(divStart)){
                divStart--;
            }else{
                //소수인데 나눠지면 소인수 분해가 된 것이다.
                if (given % divStart == 0) {
                    primeEls++;
                    given /= divStart;
                    if(isPrime(given)){
                        primeEls++;
                        break;
                    }
                    divStart = (int) Math.floor(Math.sqrt(given));
                }else{
                    divStart--;
                }
            }
        }
        //divStart에서 1씩 내리는 것이 맞나. 극단적으로 한 10200에 왔을때 114.xx 정도 일텐데
//        System.out.println("num : " + num);
//        System.out.println("primeEls : " + primeEls);

        if(isPrime(primeEls))return  true;
        else return false;

    }

    public int getUnderPrime(int numA, int numB) {
        int underPrimeNum = 0;
        for (int j = numA; j <= numB; j++) {
            if (isUnderPrime(j)) {
                underPrimeNum++;
            }
        }
        return underPrimeNum;
    }

    public static void main(String[] args) throws IOException {
        Boj1124_221222_timeover boj1124_221222 = new Boj1124_221222_timeover();
    }
}

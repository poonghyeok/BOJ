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

    //소수 2,3, 5,7,9 소수인지 가장 빠르게 아는 방법
    public boolean isPrime(int num) {
        //1과 자신 뿐
        if(num == 1)return false;
        boolean result = false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if(i != num && num % i == 0){
                return result;
            }
        }
        return true;
    }

    public boolean isUnderPrime(int num) {
        //소인수 분해를 할 수 있어야 한다.
        int el = 2;
        int elNum = 0;
        boolean underPrime = false;
//        System.out.print(num );
        while (true) {
            if ( isPrime(el) && num % el == 0) {
                num /= el;
                elNum++;
            }else{
                el++;
            }

            if(num < el){
                break;
            }
        }
//        System.out.println( "소인수 분해 개수 : " + elNum );
        if (isPrime(elNum)) {
//            System.out.println(num + " is underPrime,,!");
            underPrime = true;
        }

        return underPrime;
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

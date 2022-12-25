package basicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Boj1735_221225 {

    private BufferedReader br;
    private List<Integer> fractionA, fractionB;

    public Boj1735_221225() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.fractionA = new ArrayList<>();
        this.fractionB = new ArrayList<>();
        init();
        List<Integer> result = getResultFraction(this.fractionA, this.fractionB);

        System.out.println(result.get(0) + " " + result.get(1));
    }

    public void init() throws IOException {
        Arrays.stream(this.br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).forEach(s -> this.fractionA.add(s));
        Arrays.stream(this.br.readLine().split(" ")).mapToInt(s -> Integer.parseInt(s)).forEach(s -> this.fractionB.add(s));
    }

    public List<Integer> getResultFraction(List<Integer> fractionA, List<Integer> fractionB) {
        //첫번째 인덱스에는 분자가 들어있다. 두번째 인덱스에는 분모가 들어있다. 둘이 더하게 된다. 일단 분수를 기약분수로 만들어주는 메서드가 필요하다.
        List<Integer> lastFractionA = getLastFraction(fractionA);
        List<Integer> lastFractionB = getLastFraction(fractionB);

        int top = lastFractionA.get(0)*lastFractionB.get(1) + lastFractionB.get(0)*lastFractionA.get(1);
        int bot = lastFractionA.get(1) * lastFractionB.get(1);

        List<Integer> initFrac = new ArrayList<>();

        initFrac.add(top);
        initFrac.add(bot);

        return getLastFraction(initFrac);
    }

    public List<Integer> getLastFraction(List<Integer> fraction) {
        //어떻게 하면 효율적으로 기약분수를 return 받을 수 있을까. 소수가 아닌 수로 나누어지면 되는 거 아닌가. queue를 활용한다?
//        System.out.println("fraction : " + fraction);
        int top = fraction.get(0);
        int bot = fraction.get(1);
        int min = top > bot ? bot : top;
        List<Integer> lastFraction = new ArrayList<>();

        int initEl = 2;

        while (initEl <= min) {
            if (top % initEl == 0 && bot % initEl == 0) {
                top /= initEl;
                bot /= initEl;
            } else {
                initEl++;
            }
        }

        lastFraction.add(top);
        lastFraction.add(bot);

//        System.out.println("last fraction : " + lastFraction);
        return lastFraction;
    }


    public static void main(String[] args) throws IOException {
        Boj1735_221225 boj1735_221225 = new Boj1735_221225();

    }

}

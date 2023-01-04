package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

/**
검색해 본 내용
 1. java regex
 */
public class Boj1541_230104 {

    private BufferedReader br;
    // - 뒤로 묶는데, 빼주는 값이 최대가 되어야 한다.
    // 숫자 n개 , 연산 기호 n-1개
    private String exp;

    public Boj1541_230104() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.exp = this.br.readLine();
        System.out.println(getMinResult(this.exp));
    }

    public int getMinResult(String exp) {
        String[] splitedNums = exp.split("[+-]");
        List<Integer> splitedSigns = new StringBuffer(exp).chars().boxed().filter(c -> (c == '+' || c == '-')).collect(Collectors.toList());
        int minResult = Integer.parseInt(splitedNums[0]);
        boolean minusConst = false;

        for (int i = 1; i < splitedNums.length; i++) {
            int num = Integer.parseInt(splitedNums[i]);
            int sign = splitedSigns.get(i - 1);
            if (!minusConst && sign == '-') {
                minusConst = true;
            }
            if(minusConst)minResult -= num;
            else minResult += num;
        }

        return minResult;
    }

    public static void main(String[] args) throws IOException {

        Boj1541_230104 boj1541_230104 = new Boj1541_230104();

    }

}

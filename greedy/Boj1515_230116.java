package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/**
 * 찾아봄 : java char array to stream
* */
public class Boj1515_230116 {

    private BufferedReader br;
    private String erasedNum;
    private Map<Character, Integer> mostMap;

    public Boj1515_230116() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
    }

    public void init() throws IOException {
        this.erasedNum = this.br.readLine();
        this.mostMap = getMostFrequent(this.erasedNum);
    }

    public Map<Character, Integer> getMostFrequent(String numStr){
        Map<Character, Integer> frequency = new HashMap<>();
        for (int i = 0; i < numStr.length(); i++) {
            char c = numStr.charAt(i);
            if(frequency.containsKey(c)) frequency.put(c, frequency.get(c) + 1);
            else frequency.put(c, 1);
        }

        char max = frequency.keySet().stream().max( (key1, key2) -> {
            if(frequency.get(key1) > frequency.get(key2))return 1;
            else return -1;
        }).get();

        Map<Character, Integer> mostMap = new HashMap<>();
        mostMap.put(max, frequency.get(max));

        return mostMap;
    }

    public static void main(String[] args) throws IOException {
        Boj1515_230116 boj1515_230116 = new Boj1515_230116();

        /**
         * try1. 23.01.16 fail 논리적인 접근을 못하겠다.
        * */
    }
}

/*
0부터가 아니라 1부터 이므로 0은 하나 제외시키고 생각해야하고,,
        1자리에서 첫번째 자리에 대해서 1부터 9까지 순환
        2자리에 대해서 첫번째 자리 1부터 9까지 에 대해서 두번째 자리가 0부터 9까지 순환
        3자리에 대해서 첫번째 자리 1부터 9까지에 대해서 두번째 자리 0 부터 9까지 순환, 세번째 자리 0 부터 9까지 순환

        담당자리면 1부터 9까지 순환하고 담당자리가 아니면 0부터 9까지 순환하게 된다. > 이렇게 수를 누적시켜 나간다.> 주어진 max의 수를 가지고 어떤 수를 쓰게 될 것인지 판단해야한다.



        0 1 2 3 4 5 6 7 8 9  -> 0 1 2 3 4 5 6 7 8 9 은 매 턴마다 쌓인다.  (1라운드 제외 )
        10 11 12 13 14 15 16 17 18 19 20 -> 0 1 2 3 4 5 6 7 8 9 가 쌓였는데 1이 10번 쌓였다.
        20 21 22 23 24 25 26 27 28 29 30

        1. max만 구하면 되는거 아닌가.

        모든 수에는 뒤에 0 1 2 3 4 5 6 7 8 9 가 붙는다
        100 101 102 103 104 105 106 107 108 109

        0은 당연히 가장 적게 나올 텐데 가중치가 필요하지 않나. 일단 가중치 생각하지 않고 갔을 때
        - 가장 많이 나온 수가 뭔지 알려줘야 됨.

        어디서 걸리는 지 어떻게 판단할 수 있지..
        - 턴이 몇번 돌았는지 확인한다 ? 첫번째

        모두 똑같다면 그냥 최대값 출력하면 되기, ㅣ*/

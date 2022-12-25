package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Boj1138_221226 {

    private BufferedReader br;
    private int num;
    private List<Integer> list;

    public Boj1138_221226() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
        Arrays.stream(getSequence()).forEach(i -> System.out.print(i+ " "));
    }

    public void init() throws IOException {
        this.list = new ArrayList<>();
        this.num = Integer.parseInt(this.br.readLine());
        Arrays.stream(this.br.readLine().split(" ")).mapToInt(str -> Integer.parseInt(str)).forEach(i -> this.list.add(i));

    }

    public int[] getSequence() {
        int[] sequence = new int[this.num];
        List<Integer> emptyIdx = IntStream.range(0, this.num).boxed().collect(Collectors.toList());
        //1 2 3 4
        int tall = 1;

        for (int i = 1; i <= this.num; i++) {
            int idx = this.list.get(i - 1);
            sequence[emptyIdx.get(idx)] = i;
            emptyIdx.remove(idx);
        }

        return sequence;
    }

    public static void main(String[] args) throws IOException {
        Boj1138_221226 boj1138_221226 = new Boj1138_221226();
    }

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj2290_230111 {

    private BufferedReader br;
    private int num;
    private String disp;
    private static final char HORIZONTAL = '-';
    private static final char VERTICAL = '|';

    private static final int HORIZONTAL_FIRST = 1;
    private static final int VERTICAL_FISRT = 2;
    private static final int HORIZONTAL_SECOND = 3;
    private static final int VERTICAL_SECOND = 4;
    private static final int HORIZONTAL_THIRD = 5;

    //풀려면 풀겠는데 너무 어렵다.

    public Boj2290_230111() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = this.br.readLine().split(" ");
        this.num = Integer.parseInt(input[0]);
        this.disp = input[1];
    }

    public boolean isDrawable(int step, char goalNum){
        //일단 가장 비효율적인 방법으로 풀고 리팩터링을 하는게 베스트다. 일단 어떻게든 풀어야 돼.
        switch(goalNum){
            case '0' :
                switch (step){
                    case HORIZONTAL_FIRST :
                        break;
                    case VERTICAL_FISRT :
                        break;
                    case HORIZONTAL_SECOND:
                        break;
                    case VERTICAL_SECOND:
                        break;
                    case HORIZONTAL_THIRD:
                        break;
                }
                break;
            case '1' :
                break;
            case '2' :
                break;
            case '3' :
                break;
            case '4' :
                break;
            case '5' :
                break;
            case '6' :
                break;
            case '7' :
                break;
            case '8' :
                break;
            case '9' :
                break;

        }
        return false;

    }


    public static void main(String[] args) {

    }

}

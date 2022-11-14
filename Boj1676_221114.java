import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1676_221114 {

    private BufferedReader br;
    private int num;
    private Stack<Integer> stackTwo, stackFive;

    public Boj1676_221114() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.stackTwo = new Stack<>();
        this.stackFive = new Stack<>();
        setNum();
        setStackTwoFive();
        System.out.println(getResult());
    }

    public void setNum() throws IOException {
        this.num = Integer.parseInt(this.br.readLine());
    }

    public void setStackTwoFive(){
        for(int i = 2; i <= this.num; i++){
            int temp = i;
            while( temp % 5 == 0){
                this.stackFive.add(5);
                temp /= 5;
            }
            while ( temp % 2 == 0){
                this.stackTwo.add(2);
                temp /= 2;
            }
        }
    }

    public int getResult(){
        int twoNum = this.stackTwo.size();
        int fiveNum = this.stackFive.size();
        if(twoNum < fiveNum){
            return twoNum;
        }else{
            return fiveNum;
        }
    }

    public static void main(String[] args) throws IOException {
        Boj1676_221114 boj1676_221114 = new Boj1676_221114();
    }

}

package function;

import java.util.Scanner;

public class Boj1065_221005 {

    //각 수마다 자릿수 구해서
    //자릿수 구하는 함수,

    //Declaration
    private int num;
    private Scanner sc;
    //

    //Constructor
    public Boj1065_221005(){
        this.sc = new Scanner(System.in);
        mainProcess();
    }
    //

    //Getter,Setter
    public void setNum(){
        this.num = sc.nextInt();
    }
    public int getNum(){
        return this.num;
    }
    //

    //getNumbers
    public int getNumbers(int num){
        String numstr = Integer.toString(num);
        return numstr.length();
    }
    //

    //checkHan
    public boolean isHan(int num){
        int numTemp = num;
        int numbers = getNumbers(num);
        boolean boolHan = true;
        int first = numTemp / (int)Math.pow(10, numbers-1);
        numTemp = numTemp - first * (int)Math.pow(10, numbers-1);
        int diff = 0;

        for(int i = numbers-1; i > 0; i--){
            int next = numTemp / (int)Math.pow(10, i-1);
            numTemp = numTemp - next * (int)Math.pow(10, i-1);

            if( i == numbers-1){
                diff = first - next;
                first = next;
            }else{
                int diffTemp = first - next;
                if(diff != diffTemp){
                    return false;
                }else{
                    first = next;
                }
            }
        }

        return boolHan;
    }
    //

    //getResult
    public void getResult(int num){
        int result = 0;
        for(int j = 1; j <= num; j++){
            if(isHan(j)){
                result++;
            }
        }
        System.out.println(result);

        return;
    }
    //

    //mainProcess
    public void mainProcess(){
        this.setNum();
        getResult(this.getNum());
    }
    //

    public static void main(String[] args){
        Boj1065_221005 me = new Boj1065_221005();

    }

}

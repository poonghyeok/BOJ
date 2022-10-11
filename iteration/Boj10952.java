package iteration;

import java.util.Scanner;

public class Boj10952 {

    //두 정수라서 합이 0이 안나올리는 없고
    //0 두 개 들어오면 quit해야됨. 그럼 0 0이 들어오거나 다음 입력이 없을 때 까지 반복문을 돌린다.
    //한 줄 입력 받고 출력하고, 초기화 하고 한 줄 입력 받고 초기화 하고 이건 초기화는 0으로 만든다. 근데 0 0에서 변경되지 않으면 중지
    //0 0
    //일단 쭉 빨아들인다?

    //Declaration
    private Scanner sc;
    //

    public Boj10952(){
        this.sc = new Scanner(System.in);
        getResult();
    }

    public void getResult(){
        while( sc.hasNextLine() ){
            int a = sc.nextInt();
            int b = sc.nextInt();
            if(a == 0 && b == 0){
                break;
            }
            System.out.println(a+b);
        }
    }

    public static void main(String[] args){
        Boj10952 me = new Boj10952();
    }

}

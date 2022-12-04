package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj1057_221204 {

    public BufferedReader br;
    public int num, kim, lim;

    public Boj1057_221204() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
        System.out.println(getRound());
    }

    public void init() throws IOException {
        String[] temp = this.br.readLine().split(" ");
        this.num = Integer.parseInt(temp[0]);
        this.kim = Integer.parseInt(temp[1]);
        this.lim = Integer.parseInt(temp[2]);
    }

    public int getRound(){
        //결승전은 무조건하게 되기 때문에 둘이 안만날 수가 없음. 둘은 항상 이기기 때문에 만나게 되어있음.
        //매치의 기준이 중요하다. 단순하게 차이 기준이 아니라 바로 옆에 있는 지를 확인해야 된다. 5명이라고 하면 12/34 단순학
        //일단 큰 사람은 무조건 짝수여야 돼 아니면 매치가 안돼.
        int initRound = 1;
        while(true){
            /*System.out.println("initRound : " + initRound);
            System.out.println("this.num : " + this.num);
            System.out.println("this.kim : " + this.kim);
            System.out.println("this.lim : " + this.lim);*/

            if(this.kim > this.lim ? ((this.kim % 2 == 0) && (this.kim - this.lim == 1)) : ((this.lim % 2 == 0) && (this.lim - this.kim == 1))){
                break;
            }
            //홀수 이면서 제일 끝자리에 있냐가 중요하잖아. 맞다면 /2 + 1로 줄여야되고 아니라면 그냥 /2로 줄이면 됨.
            initRound++; //라운드가 진행된다.
            if( ((this.num % 2 != 0) &&this.kim == this.num) || this.kim % 2 != 0){
                this.kim = this.kim / 2 + 1;
            }else{
                this.kim = this.kim / 2;
            }
            //kim은 올라가게 된다.

            if( (this.num % 2 != 0 && this.lim == this.num) || this.lim % 2 != 0){
                this.lim = this.lim / 2 + 1;
            }else{
                this.lim = this.lim / 2;
            }
            //lim은 올라가게 된다.

            if(this.num % 2 == 0){
                 this.num = this.num/2;
            }else{
                this.num = this.num/2 + 1;
            }
        }

        return initRound;
    }


    public static void main(String[] args) throws IOException {
        Boj1057_221204 boj1057_221204 = new Boj1057_221204();
    }
}

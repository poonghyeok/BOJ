package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class Boj1475_221104 {

    private BufferedReader br;
    private Set<Character> setWithoutSixNine;
    private Stack<Character> stackSix,stackNine;


    public Boj1475_221104() throws IOException{
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.setWithoutSixNine = new HashSet<>();
        this.stackSix = new Stack<>();
        this.stackNine = new Stack<>();
        getResult();

    }

    public int getCountWithoutSixNine() throws IOException {

        int count = 0;
        String str = this.br.readLine();
        for(int i = 0; i <str.length(); i++){
            char c = str.charAt(i);
//            System.out.println(" character : " + c);
            if( c == '6'){
                this.stackSix.add(c);
            }else if(c == '9'){
                this.stackSix.add(c);
            }else{
                if( this.setWithoutSixNine.size() == 0 ){
                    count++;
                }
                if(this.setWithoutSixNine.contains(c)){
                    count++;
                }else{
                    this.setWithoutSixNine.add(c);
                }
            }

        }

        return count;
    }

    public void getResult() throws IOException {
        int countWithoutSixNine = getCountWithoutSixNine();
        int stackSixSize = this.stackSix.size();
        int stackNineSize = this.stackNine.size();
        int countSixNine = stackNineSize + stackSixSize;

//        System.out.println("countWithoutSixNine : "+ countWithoutSixNine  + "countSixNine : " + countSixNine);
        if(countWithoutSixNine * 2  < countSixNine){
            System.out.print(countWithoutSixNine +  (int)(Math.ceil( (countSixNine - countWithoutSixNine*2) / 2.0 )) );
        }else{
            System.out.print(countWithoutSixNine);
        }

    }



    public static void main(String[] args) throws IOException{

        Boj1475_221104 boj1475_221104 = new Boj1475_221104();

    }

}

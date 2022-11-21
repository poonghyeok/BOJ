package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Boj1817_221120 {

    private BufferedReader br;
    private int bookNum, maxWeight;
    private Queue<Integer> books;

    public Boj1817_221120() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        String[] temp = this.br.readLine().split(" ");
        this.bookNum = Integer.parseInt(temp[0]);
        if(this.bookNum == 0){
            System.out.println(0);
            System.exit(0);
        }
        this.maxWeight = Integer.parseInt(temp[1]);
        setBooks();
        System.out.println(getBoxNum());
    }

    public void setBooks() throws IOException {
        this.books = new ArrayDeque<>();
        String[] temp = this.br.readLine().split(" ");
        for(int i = 0; i < this.bookNum; i++){
            this.books.add(Integer.parseInt(temp[i]));
        }
    }

    public int getBoxNum(){
        int load = 0;
        int boxNum = 0;
        int initSize = this.books.size();
        while(this.books.size() > 0){
            if(this.books.size() == initSize){
                boxNum++;
                load += this.books.poll();
            }else{
                int nextLoad = load + this.books.peek();
//                System.out.println("nextLoad : " + nextLoad);
                if(nextLoad > this.maxWeight){
                    boxNum++;
                    load = this.books.poll();
                }else{
                    load = nextLoad;
                    this.books.poll();
                }

            }
//            System.out.println("boxNum : " + boxNum);
//            System.out.println("load : " + load);

        }

        return boxNum;
    }

    public static void main(String[] args) throws IOException {
        Boj1817_221120 boj1817_221120 = new Boj1817_221120();
    }

}

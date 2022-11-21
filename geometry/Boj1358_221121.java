package geometry;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj1358_221121 {

    private BufferedReader br;
    private int W,H,X,Y,P;
    private Stack<int[]> stack;

    public Boj1358_221121() throws IOException{
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.stack = new Stack<>();
        setInitValue();
        setStack();
        System.out.println(getInPlayer());

    }

    public void setInitValue() throws IOException {
        String[] temp = this.br.readLine().split(" ");
        this.W = Integer.parseInt(temp[0]);
        this.H = Integer.parseInt(temp[1]);
        this.X = Integer.parseInt(temp[2]);
        this.Y = Integer.parseInt(temp[3]);
        this.P = Integer.parseInt(temp[4]);
    }

    public void setStack() throws IOException {

        for(int i = 0; i < this.P; i++){
            int[] tempArr = new int[2];
            String[] temp = this.br.readLine().split(" ");
            tempArr[0] = Integer.parseInt(temp[0]);
            tempArr[1] = Integer.parseInt(temp[1]);

            stack.add(tempArr);
        }
    }

    public int getInPlayer(){
        int inPlayer = 0;
        while(this.stack.size() > 0){
            int[] locationXY = this.stack.pop();
            //아 map으로 받을 걸 아아 다 map으로 받을걸!
//            System.out.println("X : " + locationXY[0] + ", Y : " + locationXY[1]);
            if(isInRectangle(locationXY[0], locationXY[1], this.X, this.Y, this.W, this.H)
                ||isInLeftCircle(locationXY[0], locationXY[1], this.X, this.Y, this.W, this.H)
                ||isInRightCircle(locationXY[0], locationXY[1], this.X, this.Y, this.W, this.H)
            ){
                inPlayer++;
            }
        }
        return inPlayer;
    }

    public boolean isInRectangle(int locX, int locY,int x, int y, int w, int h){
        if((x <= locX && locX <= (x+w)) && ((y <= locY && locY <= (y+h)))){
//            System.out.println("isInRectangle");
            return true;
        }else{
            return false;
        }
    }

    public boolean isInLeftCircle(int locX, int locY, int x, int y, int w, int h){
        int r = h/2;
        int left = (locX - x)*(locX - x) + (locY - (y+r))*(locY - (y+r));
        int right = (r*r);
        if(left <= right){
            return true;
        }else{
            return false;
        }
    }

    public boolean isInRightCircle(int locX, int locY, int x, int y, int w, int h){
        int r = h/2;
        int left = ( locX - ( x+ w ))*( locX - ( x+ w )) + ( locY - ( y + r ))*( locY - ( y + r ));
        int right = (r*r);
        if(left <= right){
//            System.out.println("isInRightCircle");
            return true;
        }else{
            return false;
        }
    }




    public static void main(String[] args) throws IOException {
        Boj1358_221121  boj1358_221121 = new Boj1358_221121();
    }

}

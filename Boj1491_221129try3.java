import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Boj1491_221129try3 {

    private BufferedReader br;

    private int width, height;
    private List<Integer> widthList , heightList;

    public Boj1491_221129try3(){
        this.br = new BufferedReader(new InputStreamReader(System.in));
        this.widthList = new ArrayList<>();
        this.heightList = new ArrayList<>();
    }

    public void setRoad() throws IOException {
        String[] temp = this.br.readLine().split(" ");
        this.width = Integer.parseInt(temp[0]);
        this.height = Integer.parseInt(temp[1]);
    }

    public void setList(){
        for(int i = 0; i < this.width; i++){
            this.widthList.add(i);
        }
        for(int i = 0; i < this.height; i++){
            this.widthList.add(i);
        }
    }

    public void getResult(){
        boolean isMoveWidth = true;

        while(this.widthList.size() > 1 && this.heightList.size() > 1 ){
            if(isMoveWidth){

            }
        }
    }



    public static void main(String[] args){

    }

}

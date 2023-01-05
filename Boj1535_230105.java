import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Boj1535_230105 {

    private BufferedReader br;
    private int num;
    private List<int[]> coupleList;

    public Boj1535_230105() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
        System.out.println(getMaxPleasure());
    }

    public void init() throws IOException {
        this.coupleList = new ArrayList<>();
        this.num = Integer.parseInt(this.br.readLine());
        String[] stamina = this.br.readLine().split(" ");
        String[] pleasure = this.br.readLine().split(" ");

        for (int i = 0; i < stamina.length; i++) {
            int[] stamPlzCouple = new int[2];
            stamPlzCouple[0] = Integer.parseInt(stamina[i]);
            stamPlzCouple[1] = Integer.parseInt(pleasure[i]);
            this.coupleList.add(stamPlzCouple);
        }

        this.coupleList = this.coupleList.stream().sorted((coupleA, coupleB) -> {
            if(coupleA[1] > coupleB[1]){
                //기쁨이 크면 앞에 오게 정렬한다.
                return -1;
            }else if(coupleA[1] < coupleB[1]){
                //기쁨이 작으면 뒤로 간다.
                return 1;
            }else{
                //기쁨이 같다면 잃는 체력이 적은 쌍이 앞으로 오게 한다.
                if(coupleA[0] < coupleB[0]){
                    return -1;
                }else{
                    return 1;
                }
            }
        }).collect(Collectors.toList());
    }

    public int getMaxPleasure(){
        int maxPleasure = 0;
        for (int i = 0; i < this.coupleList.size(); i++) {
            int stackedPleasure = 0;
            int lostStamina = 0;

            for (int j = i; j < this.coupleList.size(); j++) {
                lostStamina += this.coupleList.get(j)[0];
                if (lostStamina >= 100) {
                    break;
                }else{
                    stackedPleasure += this.coupleList.get(j)[1];
                }
            }

            if(stackedPleasure > maxPleasure)maxPleasure = stackedPleasure;
        }

        return maxPleasure;
        //
    }

    public static void main(String[] args) throws IOException {
        Boj1535_230105 boj1535_230105 = new Boj1535_230105();
    }

}

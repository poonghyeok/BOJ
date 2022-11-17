import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Boj1487_221117 {

    private BufferedReader br;
    private int num;
    private List<int[]> callPriceWithDeliverCost;

    public Boj1487_221117() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setNum();
        setList();
        System.out.println(getMinPrice());
    }

    public void setNum() throws IOException {
        this.num = Integer.parseInt(this.br.readLine());

    }

    public void setList() throws IOException {
        this.callPriceWithDeliverCost = new ArrayList<>();
        for(int i = 0; i < this.num; i++){
            String[] strs = this.br.readLine().split(" ");
            int callPrice = Integer.parseInt(strs[0]);
            int deliverCost = Integer.parseInt(strs[1]);
            int[] arrTemp = new int[2];
            arrTemp[0] = callPrice;
            arrTemp[1] = deliverCost;

            this.callPriceWithDeliverCost.add(arrTemp);
        }
    }

    public int getMinPrice(){
        int minPrice = 0;
        int maxRevenue = 0;

        for(int i = 0; i < this.callPriceWithDeliverCost.size(); i++){
            int pivotPrice = this.callPriceWithDeliverCost.get(i)[0];
//            System.out.println("pivotPrice : " + pivotPrice);
            int revenue = 0;

            for(int j = 0; j < this.callPriceWithDeliverCost.size(); j++){
                int[] callInfo = this.callPriceWithDeliverCost.get(j);
                int callPrice = callInfo[0];
                int deliverCost = callInfo[1];
                if(pivotPrice <= callPrice){
                    if(pivotPrice >= deliverCost){
//                        System.out.println("callPirce : " + callPrice + " , deliverCost : " + deliverCost);
//                        System.out.println("new Revenue : " + (pivotPrice - deliverCost));
                        revenue += (pivotPrice - deliverCost);
//                        System.out.println("total revenue : " + revenue);
                    }
                }
            }



            if(revenue >= maxRevenue && revenue > 0){
                if(maxRevenue == 0){
                    minPrice = pivotPrice;
                    maxRevenue = revenue;
                }else{
                    if(revenue > maxRevenue){
                        maxRevenue =  revenue;
                        minPrice = pivotPrice;
                    }else if(revenue == maxRevenue){
                        if(pivotPrice < minPrice){
                            minPrice = pivotPrice;
                        }
                    }
                }
            }
        }

        return minPrice;
    }




    public static void main(String[] args) throws IOException {
        Boj1487_221117 boj1487_221117 = new Boj1487_221117();
    }
}

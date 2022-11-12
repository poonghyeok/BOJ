package greedy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Boj1246_221112 {

    private int egg, customer;
    private int[] prices;
    private BufferedReader br;

    public Boj1246_221112() throws IOException{
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setEggCustomer();
        setPrices();
        bubbleSortPrices(this.prices);
        System.out.println(getMaxSales().get("price")+" "+ getMaxSales().get("maxSales"));
    }

    public void setEggCustomer() throws IOException {
        String[] strs = this.br.readLine().split(" ");
        this.egg = Integer.parseInt(strs[0]);
        this.customer = Integer.parseInt(strs[1]);
    }

    public void setPrices() throws IOException {
        this.prices = new int[this.customer];
        for(int i = 0 ; i < this.prices.length; i++){
            prices[i] = Integer.parseInt(this.br.readLine());
        }
    }

    public void bubbleSortPrices(int[] arr){
        for(int i = arr.length-1; i > 0; i--){
            for(int j = 0; j < i; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public Map<String,Integer> getMaxSales(){
        Map<String, Integer> map = new HashMap<>();
        map.put("price", 0);
        map.put("maxSales", 0);

        for(int i = 0; i < this.prices.length; i++){
            int price = this.prices[i];
            int sales = 0;
            int realCustomer = this.prices.length - i;
//            System.out.println("price : " + price + " ,realCustomer :  " + realCustomer + " ,egg : " + egg);
            if( this.egg < realCustomer){
                sales = (this.egg * price);
            }else{
                sales = (realCustomer * price);
            }

            if(sales > map.get("maxSales")){
                map.put("price", price);
                map.put("maxSales", sales);
            }
        }

        return map;
    }

    public static void main(String[] args) throws IOException{
        Boj1246_221112 boj1246_221112 = new Boj1246_221112();
    }

}

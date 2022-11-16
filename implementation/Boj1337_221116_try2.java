package implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj1337_221116_try2 {

    private BufferedReader br;
    private int length;
    private Set<Integer> set;

    public Boj1337_221116_try2() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        setLength();
        setSet();
        System.out.println(getMinSupple(this.set));
    }

    public void setLength() throws IOException {
        this.length = Integer.parseInt(this.br.readLine());
    }

    public void setSet() throws IOException {
        this.set = new HashSet<>();
        for(int i = 0; i < this.length; i++){
            this.set.add(Integer.parseInt(this.br.readLine()));
        }
    }

    public int getMinSupple(Set<Integer> set){
        Iterator<Integer> setIter = set.iterator();
        int min = 4;

        while(setIter.hasNext()){
            int pivot = setIter.next();
            List<Integer> listTemp = getListFromNum(pivot);
            int supple = 5;
            for(int i = 0; i < listTemp.size(); i++){
                int ele = listTemp.get(i);
                if(set.contains(ele)){
                    supple--;
                }
            }

            if(supple < min){
                min = supple;
            }

        }

        return min;
    }

    public List<Integer> getListFromNum(int num){
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < 5; i++){
            list.add(num +i);
        }
        return list;
    }

    public static void main(String[] args) throws IOException {
        Boj1337_221116_try2 boj1337_221116_try2 = new Boj1337_221116_try2();
    }
}

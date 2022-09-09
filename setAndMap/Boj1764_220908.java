package setAndMap;

import java.util.*;

public class Boj1764_220908 {
    //Declaration
    private int n,m;
    private Set<String> hashSetN, hashSetM;
    private Scanner sc;
    Iterator<String> setIter;

    //

    //Generator
    public Boj1764_220908(){
        this.hashSetN = new HashSet<>();
        this.hashSetM = new HashSet<>();
        this.sc = new Scanner(System.in);
        this.mainProcess();
    }
    //

    //Getter, Setter
    public void setN(){
        this.n = sc.nextInt();
    }
    public int getN(){
        return this.n;
    }

    public void setM(){
        this.m = sc.nextInt();
    }
    public int getM() {
        return this.m;
    }

    public void setHashSetN(){
        for(int i = 0 ; i < this.getN(); i++){
            this.hashSetN.add(sc.next());
        }
    }
    public Set<String> getHashSetN(){
        return this.hashSetN;
    }

    public void setHashSetM(){
        for(int i = 0; i < this.getM(); i++){
            this.hashSetM.add(sc.next());
        }
    }
    public Set<String> getHashSetM(){
        return this.hashSetM;
    }
    //

    //getResult
    public void getResult(){
        int smaller = this.getN();
        if(this.getM() < this.getN()){
            smaller = this.getN();
        }

        int bothCheck = 0;
        Map<Integer, String> resultMap= new LinkedHashMap<>();
        if(smaller == this.getN()){
            //setN의 size가 더 작은 경우

            this.setIter = this.getHashSetN().iterator();
            this.getHashSetN().isEmpty()
            while(setIter.hasNext()){
                String word = setIter.next();
                if(this.getHashSetM().contains(word)){
                    resultMap.put(bothCheck, word);
                    bothCheck++;
                }
            }
            System.out.println(bothCheck);
            for(int i= 0 ; i < resultMap.size(); i++){
                System.out.println(resultMap.get(i));
            }

        }else{
            //mapM의 size가 더 작은 경우
            this.setIter = this.getHashSetN().iterator();

            while(setIter.hasNext()){
                String word = setIter.next();
                if(this.getHashSetN().contains(word)){
                    bothCheck++;
                    this.hashSetM.remove(word);
                }
            }
            System.out.println(bothCheck);
            Iterator<String> resultIter = this.getHashSetM().iterator();
            while(resultIter.hasNext()){
                System.out.println(resultIter.next());
            }
        }
    }

    public void mainProcess(){
        this.setN();
        this.setM();
        this.setHashSetN();
        this.setHashSetM();
        this.getResult();
    }

    public static void main(String[] args){
        Boj1764_220908 me = new Boj1764_220908();
        Set<String> testSet = new LinkedHashSet<>();
//        List<String> testList = new ArrayList<>();
//        Collection<String> col = testSet;
    }
}

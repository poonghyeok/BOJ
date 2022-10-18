package sort;

import java.util.*;

public class Boj1181_221017 {

    //단어가 2만개까지 주어질 수 있다. 시간 복잡도 고려해야한다.
    //List가 있다치고 정렬을 어떻게 할 것인가 .
    private int num;
    private int maxLen;
    private Set<String> strSet;
    private List<String>[] lists;
    private Scanner sc;

    public Boj1181_221017(){
        this.sc = new Scanner(System.in);
        this.maxLen = 0;

        setNum();
        setStrSet();
        setLists();
        insertIntoEachStack();
        getResult();
    }

    public void setNum(){
        this.num = this.sc.nextInt();
    }
    public int getNum(){
        return this.num;
    }

    public void setMaxLen(int maxLen){
        this.maxLen = maxLen;
    }
    public int getMaxLen(){
        return maxLen;
    }


    //set객체에 넣으면서 중복을 먼저 제거한다.
    public void setStrSet(){
        this.strSet = new HashSet<>();

        for(int i = 0; i < getNum(); i++){
            String str = this.sc.next();
            this.strSet.add(str);
            if(str.length() > maxLen){
                setMaxLen(str.length());
            }
        }

    }
    //

    public Set<String> getStrSet(){
        return this.strSet;
    }

    public void setLists(){
        //index를 str의 길이랑 똑같이 사용할 것이기 때문에 +1 을 해준다. index 는 -1 작기 때문에
        this.lists = new ArrayList[getMaxLen()+1];

        //각 list초기화해준다.
        for(int i = 0; i < lists.length; i++){
            lists[i] = new ArrayList<>();
        }
    }

    public List<String>[] getLists(){
        return this.lists;
    }

    //중복이 제거된 set에서 여러개의 Stack에 사전순으로 집어넣는다.
    public void insertIntoEachStack(){
        Iterator<String> iter = getStrSet().iterator();

        while(iter.hasNext()){
            String str = iter.next();
            int listIdx = str.length();
            addToList(str, getLists()[listIdx]);
        }

    }
    //

    //String크기비교, 같은 길이다.
    public int compareSequence(String str1, String str2){

        for(int i = 0; i < str1.length(); i++){
            char a = str1.charAt(i);
            char b = str2.charAt(i);
            if( a > b ){
                //str1 이 str2 보다 사전순으로 뒤인 경우
                return 1;
            }else if(a < b){
                //str1이 str2 보다 사전순으로 앞인 경우
                return -1;
            }else{
                //같은건 이미 중복제거 했으므로 비교하지 않게 된다.
                continue;
            }
        }

        return 0;
    }
    //

    public void addToList(String str, List<String> list){
        int initSize = list.size();
        if(initSize == 0){
            list.add(str);
        }else{
            for(int j = 0; j <= initSize; j++){
                //list에 존재하는 모든 데이터와 비교해도 continue만 나왔다면 마지막에 add해주면 된다.
                if(j == initSize){
                    list.add(str);
                    break;
                }
                String compareStr = list.get(j);
                int compareResult = compareSequence(str, compareStr);

                if(compareResult == 1){
                    //str이 더 큰 경우 다음과 비교해야한다.
                    continue;
                }else if(compareResult == -1){
                    //str이 사전순으로 앞서는 경우
                    list.add(j, str);
                    break;
                }else{
                    System.out.println("wrong!");
                    System.exit(0);
                }
            }
        }
    }

    public void getResult(){
        for(int k = 0; k < getLists().length; k++){
            List<String> listTemp = getLists()[k];
            for(int p = 0; p < listTemp.size(); p++){
                System.out.println(listTemp.get(p));
            }
        }
    }


    public static void main(String[] args){
        Boj1181_221017 me = new Boj1181_221017();
    }

}

package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj1058_221220 {

    private BufferedReader br;
    private int num;
    private List<String> list;

    public Boj1058_221220() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
    }

    public void init() throws IOException {
        this.num = Integer.parseInt(this.br.readLine());
        this.list = new ArrayList<>();
        for (int i = 0; i < this.num; i++) {
            this.list.add(this.br.readLine());
        }//문제에서 주어지는 데이터 모두 입력 완료
    }

    public int getChainFriendNum(){
        int maxFriendNum = 0;
        for (int i = 0; i < this.list.size(); i++) {
            int friendNum = 0;
            //1차 친구 구하기 나랑 직접 친구인 애들
            String myFriend = this.list.get(i);
            friendNum += getCountMyFriend(myFriend);
            //나의 친구들을 지목하고 있는 다른 사람들도 내 친구가 된다. 이렇게 반복문 2500인데 분명 다른 방법이 있을거야

        }

        return maxFriendNum;
    }

    public int getCountMyFriend(String str){
        int count = 0;
        for(int j = 0; j < str.length(); j++){
            if(str.charAt(j) == 'Y')count++;
        }

        return count;
    }


    /*public int getChainFriendNum(){
        int maxChainNum = 0;
        for (int i = 0; i < this.list.size(); i++) {

            Queue<Integer> queue = new LinkedList<>();
            List<Integer> friendIdxes = new ArrayList<>();
            queue.add(i);
            friendIdxes.add(i);

            while (!queue.isEmpty()) {
                String infoStr = this.list.get(queue.poll());
                while(infoStr.indexOf('Y') > -1){
                    //이미 추가했던 idx가 아니라면 전부 추가, 1기준으로 1은 idx가 0일 수 없다. 3,6 정도로만 나온다면 3추가 6추가, 3번으로가서 1을 제외하고 Y인 idx를 찾는다.
                    int idx = infoStr.indexOf('Y');
                    if(!(friendIdxes.indexOf(idx) > -1)){
                        friendIdxes.add(idx); //이미 넣지 않은 값만 넣어준다.
                        queue.add(idx);
                    }
                    infoStr = infoStr.replaceFirst("Y","N");

                }
                //1번 info로가서
            }

            if(friendIdxes.size() - 1 > maxChainNum) maxChainNum = friendIdxes.size() - 1;
        }
        return maxChainNum;
    }*/

    public static void main(String[] args) throws IOException {
        Boj1058_221220 boj1058_221250 = new Boj1058_221220();
//        System.out.println("NYNNYNN".replaceFirst("Y","N"));

        //1트 실패 문제 잘못파악함. 그냥 체인으로 이어지는 게 아니라, 직접 친구이거나 공동의 친구가 있어야 한다.

        //2트 : 직접 친구 1차로 큐에 놓고 큐 소진 시켜가면서 2차 친구 찾기 그냥 중복 생각하지 않고 넣은 다음에 마지막에 중복제거 해도 됨. stream distinct

    }


}

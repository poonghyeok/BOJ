package graphSearch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj1058_221221_try2 {


    public class PersonInfo{
        public int idx;
        public List<Integer> likeInIdx;
        public List<Integer> likeOutIdx;

        public PersonInfo(int idx, List<Integer> likeOutIdx) {
            this.idx = idx;
            this.likeInIdx = new ArrayList<>();
            this.likeOutIdx = likeOutIdx;
        }

        public void sendMyLike(List<PersonInfo> people){
            for(int likeIdx : this.likeOutIdx){
                people.get(likeIdx).likeInIdx.add(this.idx);
            }
        }

    }
    private BufferedReader br;
    private int num;
    private List<PersonInfo> people;

    public Boj1058_221221_try2() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
        System.out.println(getMaxFriendNum());
    }

    public void init() throws IOException {
        this.num = Integer.parseInt(this.br.readLine());
        this.people = new ArrayList<>();

        for(int i = 0; i < this.num; i++){
            String likeStr = this.br.readLine();
            PersonInfo personInfo = new PersonInfo(i, getMyLikeIdxes(likeStr));
            this.people.add(personInfo);
        }

        for(int i = 0; i < this.num; i++){
            people.get(i).sendMyLike(this.people);
        }

    }

    public int getMaxFriendNum() {
        int maxFriendNum = 0;
        for (PersonInfo person : this.people) {

            List<Integer> myFriend = new ArrayList<>();

            person.likeOutIdx.stream().forEach(idx -> myFriend.add(idx));
            int[] myFriendIdx = myFriend.stream().mapToInt(i -> i).toArray();
            for(int friendIdx : myFriendIdx){
                for (int secondIdx : this.people.get(friendIdx).likeInIdx) {
                    if(myFriend.indexOf(secondIdx) < 0 && secondIdx != person.idx)myFriend.add(secondIdx);
                }
            }

            if(myFriend.size() > maxFriendNum)maxFriendNum = myFriend.size();
        }

        return maxFriendNum;
    }

    public List<Integer> getMyLikeIdxes(String likeStr){
        List<Integer> likeList = new ArrayList<>();
        for (int j = 0; j < likeStr.length(); j++) {
            if(likeStr.charAt(j) == 'Y') likeList.add(j);
        }

        return likeList;
    }

    public static void main(String[] args) throws IOException {
        Boj1058_221221_try2 boj1058_221221_try2 = new Boj1058_221221_try2();
    }

}

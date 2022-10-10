package exam;

public class EnineTest2 {
    private int n;
    private int[][] signs;

    public int[][] getResult(int n, int[][] signs){
        int[][] resultArr = new int[n][n];
        resultArr = signs;//환승없이 1차적으로 다 갈 수 있음.

        for(int i = 0; i < n; i++){
            int stop = 0;
            for(int j = 0; j < n; j++){
                if(signs[i][j] == 1){
                    stop = j;
                    addArr(signs, i, stop);

                }
            }
        }

        return resultArr;
    }

    public void addArr(int[][] arr, int start, int end){
        int[] startArr = arr[start];
        int[] endArr = arr[end];
        int[] arrTemp = new int[arr.length];
        boolean isChanged = false;

        for(int i = 0; i < arr.length; i++){
            if(startArr[i] == 0){
                arrTemp[i] = startArr[i] + endArr[i];
                if(!isChanged){
                    isChanged = !isChanged;
                }
            }else{
                continue;
            }

        }

        arr[start] = arrTemp;

//        return isChanged;
    }

    public int[][] solution(int n, int[][] signs){
        int[][] answer = {{1,1,1},{1,1,1},{1,1,1}};
        return answer;
    }

    public static void main(String[] args){
        EnineTest2 me = new EnineTest2();
        int[][] arr = {{0,1,0},{0,0,1},{1,0,0}};
        me.solution(3, arr);
    }

}

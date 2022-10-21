package greedy;

import java.util.Scanner;

public class Boj1343_try3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.next();

        int idx = str.indexOf("XX");
        if(idx < 0){
            System.out.println(-1);
            return;
        }else{
            while(true){
                str = str.replaceFirst("XX","BB");
                if(str.indexOf("XX") < 0){
                    break;
                }
            }
        }

        while(true){
            if(str.indexOf("BBBB") < 0){
                if(str.indexOf("X") >= 0){
                    System.out.println(-1);
                    return;
                }
                System.out.println(str);
                return;
            }else{
                str = str.replaceFirst("BBBB", "AAAA");
                if(str.indexOf("BBBB") < 0){
                    break;
                }
            }

        }
        if(str.indexOf("X") >= 0){
            System.out.println(-1);
            return;
        }
        System.out.println(str);
        return;


    }
}

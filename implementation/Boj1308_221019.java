package implementation;

import java.util.Scanner;

public class Boj1308_221019 {

    //SWITCH BREAK은 항상 까먹으니깐 그냥 쓰지 말고 IF나 쓰자.

    //4로 나누어 떨어지는 해는 윤년
    //100으로 나누어 떨어지는 평년
    //400으로 나누어 떨어지는 해는 윤년
    //윤년은 2월 29일까지 있다.
    //풀이 방법 주어진 날짜를 수로 계산한다?
    //그냥 년도 * 365
    //근데 윤년
    private int[] dateOne,dateTwo;
    private Scanner sc;

    public Boj1308_221019(){
        this.sc = new Scanner(System.in);
        this.dateOne = new int[3];
        this.dateTwo = new int[3];
        setDateOne();
        setDateTwo();

        int DayOne = dateToDayUnit(this.dateOne[0], this.dateOne[1], this.dateOne[2]);
        int DayTwo = dateToDayUnit(this.dateTwo[0], this.dateTwo[1], this.dateTwo[2]);
        int dday = (DayTwo-DayOne);

        if(isGG(dateOne, dateTwo)){
            System.out.println("gg");
        }else{
            System.out.println("D-"+(dday));
        }

    }

    public boolean isGG(int[] date1, int[] date2){
        boolean result = false;
        if(date2[0] >= date1[0] + 1000){
            if(date2[1] >= date1[1]){
                if(date2[2] >= date1[2]){
                    result = true;
                }
            }
        }

        return result;
    }
    public void setDateOne(){
        for(int i = 0; i < this.dateOne.length; i++){
            this.dateOne[i] = this.sc.nextInt();
        }
    }

    public void setDateTwo(){
        for(int i = 0; i < this.dateTwo.length; i++){
            this.dateTwo[i] = this.sc.nextInt();
        }
    }

    private int dateToDayUnit(int year, int month, int day){
        //첫 날이 0년이 아니라 1년 1월 1일이다.
        //1년 1월 1일 기준으로 시간이 며칠이나 흘렀는가.
        int yearToDay = (year - 1) * 365;

        int monthToDay = getMonthToDay(month);

        int dayNew = day - 1;

        int additionalDay = getAdditionalLeapYearDay(year, month, day);

        return (yearToDay + monthToDay + dayNew + additionalDay);
    }

    public int getMonthToDay(int month){
        int daySum = 0;
        for(int i = 1; i < month; i++){
            switch(i){
                case 1: daySum += 31;break;
                case 2: daySum += 28;break;
                case 3: daySum += 31;break;
                case 4: daySum += 30;break;
                case 5: daySum += 31;break;
                case 6: daySum += 30;break;
                case 7: daySum += 31;break;
                case 8: daySum += 31;break;
                case 9: daySum += 30;break;
                case 10: daySum += 31;break;
                case 11: daySum += 30;break;
            }
        }

        return daySum;
    }

    public boolean isLeapYear(int year){
        boolean result = false;

        if (year % 4 == 0){
            result = true;
        }
        if(year % 100 == 0){
            result = false;
        }
        if(year % 400 == 0){
            result = true;
        }

        return result;
    }

    public int getAdditionalLeapYearDay(int year, int month, int day){
        //1년 부터 year 까지의 윤년에 대한 추가적인 날짜를 return 한다.
        //윤년이라도 2월 29일이 되기 전까지는 1일이 추가되지 않는다.
        int addDay = 0;
        for(int i = 4; i <= year; i++){
            if(isLeapYear(i)){
                addDay++;
            }
        }

        if(isLeapYear(year) && (month <= 2) && (day <= 28)){
            //주어진 날짜가 윤년인데 2월 28일과 같거나 이전이면 윤년으로 계산된 1일을 빼준다.
            addDay--;
        }

        return addDay;
    }

    public static void main(String[] args){

        Boj1308_221019 boj1308_221019 = new Boj1308_221019();

    }

}

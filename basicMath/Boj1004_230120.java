package basicMath;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Boj1004_230120 {

    public class Coord{
        public int x,y;
        public Coord(int x, int y){
            this.x = x;
            this.y = y;
        }

    }

    public class Planet{
        public Coord center;
        public int radius;

        public Planet(Coord coord, int radius) {
            this.center = coord;
            this.radius = radius;
        }
    }

    private BufferedReader br;
    private int testCase;
    private Coord from, to;

    public Boj1004_230120() throws IOException {
        this.br = new BufferedReader(new InputStreamReader(System.in));
        init();
        for (int i = 0; i < this.testCase; i++) {


            String[] coordArr= this.br.readLine().split(" ");
            this.from = new Coord(Integer.parseInt(coordArr[0]), Integer.parseInt(coordArr[1]));
            this.to = new Coord(Integer.parseInt(coordArr[2]), Integer.parseInt(coordArr[3]));

            int planetNum = Integer.parseInt(this.br.readLine());

//            System.out.println("planetNum : " + planetNum);
            List<Planet> planetList = getPlanetListAsGivenNum(planetNum);
            System.out.println(getInOutNum(planetList));
        }
    }

    public void init() throws IOException {
        this.testCase = Integer.parseInt(this.br.readLine());


    }

    public List<Planet> getPlanetListAsGivenNum(int planetNum) throws IOException {
        List<Planet> planetList = new ArrayList<>();
        for (int j = 0; j < planetNum; j++) {
            String[] planetInfoArr = this.br.readLine().split(" ");
            Coord planetCenter = new Coord(Integer.parseInt(planetInfoArr[0]), Integer.parseInt(planetInfoArr[1]));
            Planet planet = new Planet(planetCenter, Integer.parseInt(planetInfoArr[2]));
            planetList.add(planet);
        }
//        System.out.println(" planetList : " + planetList);

        return planetList;
    }

    public int getInOutNum(List<Planet> planetList){
        int fromOuter = 0;
        int toOuter = 0;

        for (Planet planet : planetList) {
            if(isIn(this.from, planet) && isIn(this.to, planet))continue; //같은 행성에 들어있는 경우
            if(isIn(this.from, planet))fromOuter++;
            if(isIn(this.to, planet))toOuter++;
        }

        return fromOuter + toOuter;
    }

    public boolean isIn(Coord coord, Planet planet) {
        int leftX = (coord.x - planet.center.x);
        int leftY = (coord.y - planet.center.y);

        int eqLeft= (leftX*leftX) + (leftY*leftY);
        int eqRight = planet.radius * planet.radius;

        if(eqLeft < eqRight)return true;
        else return false;
    }

    public static void main(String[] args) throws IOException {
        Boj1004_230120 boj1004_230120 = new Boj1004_230120();
    }

}

const fs = require("fs");
const inputs:Array<string> = fs.readFileSync('./dev/stdn/inputs.txt').toString().split(' ');

interface Coord{
    x:number,
    y:number
}

const getInitCoord = ():Coord => {return {x : 0, y : 0}};

interface Calc{
    currLoc : Coord
    rightTopLoc : Coord
    leftDownLoc : Coord
    init(currLoc : Coord, rightTopLoc : Coord) : void
    transformTxt2Coord(txts : string[]):Array<Coord>
    getExitMinDis() : number
    getMinDistInLine(start : number, curr : number, end : number) : number
}

class Boj implements Calc {
    constructor(
        public currLoc :Coord,
        public rightTopLoc : Coord,
        public leftDownLoc : Coord
    ){}

    init(currLoc:Coord, rightTopLoc : Coord){
        this.currLoc = currLoc;
        this.rightTopLoc = rightTopLoc;
    }

    transformTxt2Coord(txts: string[]): Coord[] {
        const coords : Coord[] = new Array<Coord>;
        coords.push({x : Number(txts[0]), y : Number(txts[1])});
        coords.push({x : Number(txts[2]), y : Number(txts[3])});
        
        return coords;
    }

    getMinDistInLine(start: number, curr: number, end: number): number {
        return Math.min(Math.abs(curr - start), Math.abs(end - curr));
    }

    getExitMinDis(): number {
       return Math.min(this.getMinDistInLine(this.leftDownLoc.x, this.currLoc.x, this.rightTopLoc.x)
       , this.getMinDistInLine(this.leftDownLoc.y, this.currLoc.y, this.rightTopLoc.y));
    }
}

const boj = new Boj(getInitCoord(), getInitCoord(), getInitCoord());
const coords = boj.transformTxt2Coord(inputs);
boj.init(coords[0], coords[1]);
console.log(boj.getExitMinDis());
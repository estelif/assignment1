package models;

public class Points {
    private int x;
    private int y;

    public Points(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public double getDistance(Points dest){
        return Math.sqrt(Math.pow(dest.x - x, 2) + Math.pow(dest.y - y, 2));
    }
}

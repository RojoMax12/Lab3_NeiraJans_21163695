package org.example.TDASection;
import org.example.TDAStation.Station;

public class Section {
    private Station point1;
    private Station point2;
    private float distance;
    private float cost;

    public Section(Station point1, Station point2, float distance, float cost) {
        this.point1 = point1;
        this.point2 = point2;
        this.distance = distance;
        this.cost = cost;
    }

    public Station getPoint1() {
        return point1;
    }
    public Station getPoint2() {
        return point2;
    }

    public float getDistance() {
        return distance;
    }

    public float getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return "[" + point1.toString()+ "," + point2.toString() +"," + "Distancia entre estaicones: " + distance + "," + cost +
                ']';
    }
}

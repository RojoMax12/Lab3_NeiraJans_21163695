package org.example;

public class Section {
    private Station point1;
    private Station point2;
    private float distance;
    private float cost;

    /**
     * Nombre Section
     * Descripcion  Método que obtiene la capacidad de una Section
     * @param point1
     * @param point2
     * @param distance
     * @param cost
     */
    public Section(Station point1, Station point2, float distance, float cost) {
        this.point1 = point1;
        this.point2 = point2;
        this.distance = distance;
        this.cost = cost;
    }

    /**
     * Nombre getPoint1
     * Descripcion Método que obtiene el point1 de una Section
     * @return point1
     */
    public Station getPoint1() {
        return point1;
    }

    /**
     * Nombre getPoint2
     * Descripcion Método que obtiene el point2 de una Section
     * @return point2
     */
    public Station getPoint2() {
        return point2;
    }

    /**
     * Nombre getDistance
     * Descripcion Método que obtiene la distancia de una Section
     * @return distance
     */
    public float getDistance() {
        return distance;
    }

    /**
     * Nombre getCost
     * Descripcion Método que obtiene el costo de una Section
     * @return cost
     */
    public float getCost() {
        return cost;
    }


    /**
     * Nombre toString
     * Descripcion Método que muestra una Section
     */
    @Override
    public String toString() {
        return "[" + point1.toString()+ "," + point2.toString() +"," + "Distancia entre estaicones: " + distance + "," + cost +
                ']';
    }
}

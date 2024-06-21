package org.example.TDADriver;

public class Driver {
    private int id;
    private String nombre;
    private String trainMaker;

    public Driver(int id, String nombre, String trainMaker) {
        this.id = id;
        this.nombre = nombre;
        this.trainMaker = trainMaker;
    }

    public int getId() {
        return id;
    }

    public String getTrainMaker() {
        return trainMaker;
    }

    @Override
    public String toString() {
        return "[" +
                 id +
                "," + nombre  +
                "," + trainMaker +
                ']';
    }

}

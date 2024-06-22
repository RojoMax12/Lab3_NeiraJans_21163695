package org.example;

public class Driver {
    private int id;
    private String nombre;
    private String trainMaker;


    /**
     * Nombre Driver
     * Descripcion Metodo que construye un Driver
     * @param id
     * @param nombre
     * @param trainMaker
     */
    public Driver(int id, String nombre, String trainMaker) {
        this.id = id;
        this.nombre = nombre;
        this.trainMaker = trainMaker;
    }

    /**
     * Nombre getId
     * Descripcion Metodo que obtiene el Id de un Driver
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Nombre getTrainMaker
     * Descripcion Metodo que obtiene el TrainMaker de un tren
     * @return trainMaker
     */
    public String getTrainMaker() {
        return trainMaker;
    }


    /**
     * Nombre toString
     * Descripcion Metodo que muestra el contenido de Driver
     */
    @Override
    public String toString() {
        return "[" +
                 id +
                "," + nombre  +
                "," + trainMaker +
                ']';
    }

}

package org.example;

public class Station {
    private int id;
    private String name;
    private StationType type;
    private int stop_time;

    /**
     * Nombre Station
     * Descripcion Método que crea una Station
     * @param id
     * @param name
     * @param type
     * @param stop_time
     */
    public Station(int id, String name, StationType type, int stop_time) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.stop_time = stop_time;
    }

    /**
     * Nombre getStop_time
     * Descripcion Método que obtiene el StopTime de una Station
     * @return stop_time
     */
    public int getStop_time() {
        return stop_time;
    }

    /**
     * Nombre getId
     * Descripcion Método que obtiene el Id de una Station
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Nombre getType
     * Descripcion Método que obtiene el type de una Station
     * @return type
     */
    public StationType getType() {
        return type;
    }

    /**
     * Nombre getName
     * Descripcion Método que obtiene el name de una Station
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Nombre toString
     * Descripcion Método que muestra una Station
     */
    @Override
    public String toString() {
        return "[" + id +
                "," + name  +
                "," + type +
                "," + "TiempoDeParada: " + stop_time +
                ']';
    }
}

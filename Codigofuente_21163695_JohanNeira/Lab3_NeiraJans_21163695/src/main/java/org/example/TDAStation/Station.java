package org.example.TDAStation;

public class Station {
    private int id;
    private String name;
    private StationType type;
    private int stop_time;


    @Override
    public String toString() {
        return "[" + id +
                "," + name  +
                "," + type +
                "," + "TiempoDeParada: " + stop_time +
                ']';
    }

    public Station(int id, String name, StationType type, int stop_time) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.stop_time = stop_time;
    }

    public int getStop_time() {
        return stop_time;
    }

    public int getId() {
        return id;
    }


    public StationType getType() {
        return type;
    }


    public String getName() {
        return name;
    }

}

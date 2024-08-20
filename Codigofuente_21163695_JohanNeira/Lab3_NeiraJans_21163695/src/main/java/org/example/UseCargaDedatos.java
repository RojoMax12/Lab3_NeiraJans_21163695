package org.example;

import java.util.Scanner;

public interface UseCargaDedatos {

    /**
     * Nombre loadFromFileTrain
     * Descripcion Metodo que carga las lineas a la Red de metro y el la Red de Metro
     * @param scanner
     * @param subway
     * @return Subway
     */
    public Subway loadFromFileSubway(Scanner scanner, Subway subway);

    /**
     * Nombre loadFromFileTrain
     * Descripcion Metodo que carga datos los trenes a la Red de metro y a la lineas correspondientes
     * @param scanner
     * @param subway
     * @param cargaDedatos
     * @return Subway
     */
    public Subway loadFromFileTrain(Scanner scanner, Subway subway, CargaDedatos cargaDedatos);

    /**
     * Nombre loadFromFileDriver
     * Descripcion Metodo que carga datos los conductores a la Red de metro y los trenes correspondientes
     * @param scanner
     * @param subway
     * @return Subway
     */
    public Subway loadFromFileDriver(Scanner scanner, Subway subway);

    /**
     * Nombre loadFromFileCombination
     * Descripcion Metodo que carga datos las combinaciones a la Red de metro
     * @param scanner
     * @param subway
     * @return Subway
     */
    public Subway loadFromFileCombination(Scanner scanner, Subway subway);


}

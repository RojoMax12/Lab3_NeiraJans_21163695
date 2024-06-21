package org.example.TDACargadedatos;

import org.example.TDASubway.Subway;

import java.util.Scanner;

public interface UseCargaDedatos {

    public Subway loadFromFileSubway(Scanner scanner, Subway subway);

    public Subway loadFromFileTrain(Scanner scanner, Subway subway, CargaDedatos cargaDedatos);

    public Subway loadFromFileDriver(Scanner scanner, Subway subway);

    public Subway loadFromFileCombination(Scanner scanner, Subway subway);


}

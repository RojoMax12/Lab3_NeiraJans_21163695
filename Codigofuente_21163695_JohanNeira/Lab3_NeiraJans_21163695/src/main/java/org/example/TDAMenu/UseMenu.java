package org.example.TDAMenu;

import org.example.TDACargadedatos.CargaDedatos;
import org.example.TDASubway.Subway;

public interface UseMenu {

    public void showMenu(Subway subway);

    public void option1(CargaDedatos cargaDedatos);

    public void option2(Subway subway);

    public void option3(Subway subway, CargaDedatos cargaDedatos);

    public void displayOptionsInicio();

    public void displayOptionsOption1();

    public void displayOptionsOption2();

    public void displayOptionsOption3();


}

package org.example;
import org.example.TDAMenu.Menu;
import org.example.TDASubway.Subway;


public class Main {
    public static void main(String[] args) {
        Subway subway = new Subway(9999, "Nada");
        Menu menu = new Menu();
        menu.showMenu(subway);

    }

}



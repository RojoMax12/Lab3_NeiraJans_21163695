package org.example;

import java.util.List;

public interface UseLine {

    /**
     * Nombre line_length
     * Descripcion  Método que permite determinar el largo total de una línea
     * @return length
     */
    public float line_length();

    /**
     * Nombre line_section_length
     * Descripcion Método que permite determinar el trayecto entre una estación origen y una fina
     * @param station1_name
     * @param station2_name
     * @return sectionLength
     */
    public float line_section_length(String station1_name, String station2_name);

    /**
     * Nombre line_cost
     * Descripcion Metodo que permite determinar el costo total (monetario) de recorrer una línea.
     * @return cost
     */
    public float line_cost();

    /**
     * Nombre line_section_cost
     * Descripcion  Método que permite determinar el costo de un trayecto entre una estación origen y una final.
     * @param station1_name
     * @param station2_name
     * @return sectionCost
     */
    public float line_section_cost(String station1_name, String station2_name);

    /**
     * Nombre line_add_section
     * Descripcion Método que permite añadir tramos a una línea.
     * @param section
     * @return Line
     */
    public void line_add_section(Section section);

    /**
     * Nombre isline
     * Descripcion Método que permite determinar si un elemento cumple con las restricciones señaladas en
     * apartados anteriores en relación a las estaciones y tramos para poder conformar una línea.
     * @param line
     * @return boolean
     */
    public boolean isline(Line line);

    /**
     * Nombre consistencias
     * Descripcion Metodo que determina la consistencia de la lista de secciones
     * @param section
     * @return boolean
     */
    public boolean consistencias(List<Section> section);

    /**
     * Nombre linecirular
     * Descripcion Metodo que determina a traves de la lista de secciones si es una linea circular
     * @param section
     * @return boolean
     */
    public boolean linecirular(List<Section> section);

    /**
     * Nombre linenormal
     * Descripcion Metodo que determina a traves de la lista de secciones si es una linea normal
     * @param section
     * @return boolean
     */
    public boolean linenormal(List<Section> section);

}

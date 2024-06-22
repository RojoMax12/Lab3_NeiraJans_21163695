package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line implements UseLine {
    private int id;
    private String nombre;
    private String rail_type;
    private List<Section> sections;
    private List<Train> ListTrain = new ArrayList<Train>();

    /**
     * Nombre Line
     * Descripcion Construye un Line
     * @param id
     * @param nombre
     * @param rail_type
     * @param sections
     */
    public Line(int id, String nombre, String rail_type, List<Section> sections) {
        this.id = id;
        this.nombre = nombre;
        this.rail_type = rail_type;
        this.sections = sections;
    }

    /**
     * Nombre getId
     * Descripcion Metodo que obtiene la Id de un Line
     * @return id
     */
    public int getId() {
        return id;
    }

    /**
     * Nombre getNombre
     * Descripcion Metodo que obtiene el nombre de un Line
     * @return nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Nombre getRail_type
     * Descripcion Metodo que obtiene el rail_type de un Line
     * @return rail_type
     */
    public String getRail_type() {
        return rail_type;
    }

    /**
     * Nombre getSections
     * Descripcion Metodo que obtiene la lista de secciones de un Line
     * @return sections
     */
    public List<Section> getSections() {
        return sections;
    }

    /**
     * Nombre getListTrain
     * Descripcion Metodo que obtiene la lista de trenes de un Line
     * @return ListTrain
     */
    public List<Train> getListTrain() {
        return ListTrain;
    }

    /**
     * Nombre line_length
     * Descripcion  Método que permite determinar el largo total de una línea
     * @return length
     */
    @Override
    public float line_length() {
        float length = 0;
        for (Section section : getSections()) {
            length = length + section.getDistance();
        }
        return length;
    }


    /**
     * Nombre line_section_length
     * Descripcion Método que permite determinar el trayecto entre una estación origen y una fina
     * @param station1_name
     * @param station2_name
     * @return sectionLength
     */
    @Override
    public float line_section_length(String station1_name, String station2_name) {
        float sectionLength = 0;
        boolean foundFirstStation = false;

        for (int i = 0; i < getSections().size(); i++) {
            Section currentSection = getSections().get(i);

            if (!foundFirstStation && currentSection.getPoint1().getName().equals(station1_name)) {
                sectionLength += currentSection.getDistance();
                foundFirstStation = true;

                if (currentSection.getPoint2().getName().equals(station2_name)) {
                    return sectionLength;
                }
            }

            if (foundFirstStation && currentSection.getPoint2().getName().equals(station2_name)) {
                sectionLength += currentSection.getDistance();
                return sectionLength;
            }
        }

        return sectionLength;
    }



    /**
     * Nombre line_cost
     * Descripcion Metodo que permite determinar el costo total (monetario) de recorrer una línea.
     * @return cost
     */
    @Override
    public float line_cost() {
        float cost = 0;
        for (Section section : getSections()) {
            cost = cost + section.getCost();
        }
        return cost;
    }


    /**
     * Nombre line_section_cost
     * Descripcion  Método que permite determinar el costo de un trayecto entre una estación origen y una final.
     * @param station1_name
     * @param station2_name
     * @return sectionCost
     */
    @Override
    public float line_section_cost(String station1_name, String station2_name) {
        float sectionCost = 0;
        boolean foundFirstStation = false;

        for (int i = 0; i < getSections().size(); i++) {
            Section currentSection = getSections().get(i);

            if (!foundFirstStation && currentSection.getPoint1().getName().equals(station1_name)) {
                sectionCost += currentSection.getCost();
                foundFirstStation = true;

                if (currentSection.getPoint2().getName().equals(station2_name)) {
                    return sectionCost;
                }
            }

            if (foundFirstStation && currentSection.getPoint2().getName().equals(station2_name)) {
                sectionCost += currentSection.getCost();
                return sectionCost;
            }
        }

        return sectionCost;
    }



    /**
     * Nombre line_add_section
     * Descripcion Método que permite añadir tramos a una línea.
     * @param section
     * @return Line
     */
    @Override
    public Line line_add_section(Section section) {
        List<Section> currentSections = getSections();

        if (currentSections.contains(section)) {
            return this;
        }
        currentSections.add(section);

        return new Line(getId(), getNombre(), getRail_type(), currentSections);
    }


    /**
     * Nombre isline
     * Descripcion Método que permite determinar si un elemento cumple con las restricciones señaladas en
     * apartados anteriores en relación a las estaciones y tramos para poder conformar una línea.
     * @param line
     * @return boolean
     */
    @Override
    public boolean isline(Line line){
        if (linecirular(line.getSections())||linenormal(line.getSections())){
            return consistencias(line.getSections());
        }
        return false;
    }


    /**
     * Nombre consistencias
     * Descripcion Metodo que determina la consistencia de la lista de secciones
     * @param section
     * @return boolean
     */
    @Override
    public boolean consistencias(List<Section> section) {
        for(int i = 0; i < section.size() - 1; i++) {
            if(!Objects.equals(section.get(i).getPoint2().getName(), getSections().get(i + 1).getPoint1().getName())){
                return false;
            }
        }
        return true;
    }


    /**
     * Nombre linecirular
     * Descripcion Metodo que determina a traves de la lista de secciones si es una linea circular
     * @param section
     * @return boolean
     */
    @Override
    public boolean linecirular(List<Section> section) {
        if(Objects.equals(section.get(0).getPoint1().getName(), section.get(section.size() - 1).getPoint2().getName())) {
            return true;
        }
        return false;
    }


    /**
     * Nombre linenormal
     * Descripcion Metodo que determina a traves de la lista de secciones si es una linea normal
     * @param section
     * @return boolean
     */
    @Override
    public boolean linenormal(List<Section> section) {
        if (section.get(0).getPoint1().getType().equals(StationType.T) && section.get(section.size()-1).getPoint2().getType().equals(StationType.T)) {
            return true;
        }
        return false;
    }


    /**
     * Nombre toString()
     * Descripcion Metodo que muestra el Line
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Line ").append(id).append(":\n")
                .append("  ID: ").append(id).append("\n")
                .append("  Name: ").append(nombre).append("\n")
                .append("  Rail Type: ").append(rail_type).append("\n")
                .append("  Sections:\n");

        for (Section section : sections) {
            sb.append("    ").append(section).append("\n");
        }

        sb.append("Lista de Trenes:\n");
        for (Train train : ListTrain) {
            sb.append("    ").append(train).append("\n");
        }

        return sb.toString();
    }

}

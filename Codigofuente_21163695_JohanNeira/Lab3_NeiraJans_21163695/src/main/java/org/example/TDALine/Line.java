package org.example.TDALine;
import org.example.TDASection.Section;
import org.example.TDAStation.StationType;
import org.example.TDATrain.Train;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Line implements UseLine{
    private int id;
    private String nombre;
    private String rail_type;
    private List<Section> sections;
    private List<Train> ListTrain = new ArrayList<Train>();

    public Line(int id, String nombre, String rail_type, List<Section> sections) {
        this.id = id;
        this.nombre = nombre;
        this.rail_type = rail_type;
        this.sections = sections;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getRail_type() {
        return rail_type;
    }

    public List<Section> getSections() {
        return sections;
    }

    public List<Train> getListTrain() {
        return ListTrain;
    }

    @Override
    public float line_length() {
        float length = 0;
        for (Section section : getSections()) {
            length = length + section.getDistance();
        }
        return length;
    }

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


    @Override
    public float line_cost() {
        float cost = 0;
        for (Section section : getSections()) {
            cost = cost + section.getCost();
        }
        return cost;
    }

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


    @Override
    public Line line_add_section(Section section) {
        List<Section> currentSections = getSections();

        if (currentSections.contains(section)) {
            return this;
        }
        currentSections.add(section);

        return new Line(getId(), getNombre(), getRail_type(), currentSections);
    }

    @Override
    public boolean isline(Line line){
        if (linecirular(line.getSections())||linenormal(line.getSections())){
            return consistencias(line.getSections());
        }
        return false;
    }

    @Override
    public boolean consistencias(List<Section> section) {
        for(int i = 0; i < section.size() - 1; i++) {
            if(!Objects.equals(section.get(i).getPoint2().getName(), getSections().get(i + 1).getPoint1().getName())){
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean linecirular(List<Section> section) {
        if(Objects.equals(section.get(0).getPoint1().getName(), section.get(section.size() - 1).getPoint2().getName())) {
            return true;
        }
        return false;
    }

    @Override
    public boolean linenormal(List<Section> section) {
        if (section.get(0).getPoint1().getType().equals(StationType.T) && section.get(section.size()-1).getPoint2().getType().equals(StationType.T)) {
            return true;
        }
        return false;
    }


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

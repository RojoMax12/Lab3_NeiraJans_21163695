package org.example.TDALine;

import org.example.TDASection.Section;

import java.util.List;

public interface UseLine {

    public float line_length();

    public float line_section_length(String station1_name, String station2_name);

    public float line_cost();

    public float line_section_cost(String station1_name, String station2_name);

    public Line line_add_section(Section section);

    public boolean consistencias(List<Section> section);

    public boolean isline(Line line);

    public boolean linecirular(List<Section> section);

    public boolean linenormal(List<Section> section);

}

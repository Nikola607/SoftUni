package com.example.football.models.xmlDTOs;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "stats")
@XmlAccessorType(XmlAccessType.FIELD)
public class StatSeedRootDTO {
    @XmlElement(name = "stat")
    private List<StatSeedDTO> stats;

    public List<StatSeedDTO> getStats() {
        return stats;
    }

    public void setStats(List<StatSeedDTO> stats) {
        this.stats = stats;
    }
}

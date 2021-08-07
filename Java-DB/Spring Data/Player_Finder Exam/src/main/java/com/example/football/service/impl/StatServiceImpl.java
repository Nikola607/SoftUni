package com.example.football.service.impl;

import com.example.football.models.entity.Stat;
import com.example.football.models.xmldto.StatSeedRootDto;
import com.example.football.repository.StatRepository;
import com.example.football.service.StatService;
import com.example.football.util.ValidationUtil;
import com.example.football.util.XmlParser;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

@Component
public class StatServiceImpl implements StatService {

    private final StatRepository statRepository;
    private final XmlParser xmlParser;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public StatServiceImpl(StatRepository statRepository, XmlParser xmlParser, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.statRepository = statRepository;
        this.xmlParser = xmlParser;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return statRepository.count() > 0;
    }

    @Override
    public String readStatsFileContent() throws IOException {
        return Files.readString(Path.of("src/main/resources/files/xml/stats.xml"));
    }

    @Override
    public String importStats() throws JAXBException, FileNotFoundException {
        StringBuilder sb = new StringBuilder();

        xmlParser.fromFile("src/main/resources/files/xml/stats.xml", StatSeedRootDto.class)
                .getStats()
                .stream()
                .filter(statSeedDto -> {
                    boolean isValid = validationUtil.isValid(statSeedDto);

                    sb.append(isValid ? String.format("Successfully imported Stat %.2f - %.2f - %.2f",
                            statSeedDto.getPassing(), statSeedDto.getShooting(), statSeedDto.getEndurance()) :
                            String.format("Invalid Stat"));
                    sb.append(System.lineSeparator());

                    return isValid;
                })
                .map(statSeedDto -> modelMapper.map(statSeedDto, Stat.class))
                .forEach(statRepository::save);

        return sb.toString();
    }

    @Override
    public Stat findById(Long id) {
        return statRepository.findById(id)
                .orElse(null);
    }
}

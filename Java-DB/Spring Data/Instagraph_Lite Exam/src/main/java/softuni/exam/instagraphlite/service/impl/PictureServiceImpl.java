package softuni.exam.instagraphlite.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import softuni.exam.instagraphlite.models.models.entity.Pictures;
import softuni.exam.instagraphlite.models.models.jsondto.PicturesSeedDto;
import softuni.exam.instagraphlite.repository.PictureRepository;
import softuni.exam.instagraphlite.service.PictureService;
import softuni.exam.instagraphlite.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Component
public class PictureServiceImpl implements PictureService {
    public static final String PICTURE_FILE_PATH = "src/main/resources/files/pictures.json";

    private final PictureRepository pictureRepository;
    private final ModelMapper modelMapper;
    private final Gson gson;
    private final ValidationUtil validationUtil;

    public PictureServiceImpl(PictureRepository pictureRepository, ModelMapper modelMapper, Gson gson, ValidationUtil validationUtil) {
        this.pictureRepository = pictureRepository;
        this.modelMapper = modelMapper;
        this.gson = gson;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readFromFileContent() throws IOException {
        return Files.readString(Path.of(PICTURE_FILE_PATH));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();
        PicturesSeedDto[] picturesSeedDtos = gson.fromJson(readFromFileContent(), PicturesSeedDto[].class);

        Arrays.stream(picturesSeedDtos)
                .filter(picturesSeedDto -> {
                    boolean isValid = validationUtil.isValid(picturesSeedDto)
                            && !isEntityExists(picturesSeedDto.getPath());

                    sb.append(isValid ? String.format("Successfully imported Picture, with size %.2f",
                            picturesSeedDto.getSize()) : String.format("Invalid Picture"));
                    sb.append(System.lineSeparator());

                    return isValid;
                })
                .map(picturesSeedDto -> modelMapper.map(picturesSeedDto, Pictures.class))
                .forEach(pictureRepository::save);

        return sb.toString();
    }

    public boolean isEntityExists(String path) {
        return pictureRepository.existsByPath(path);
    }

    @Override
    public Pictures findByPath(String profilePicture) {
        return pictureRepository.findByPath(profilePicture)
                .orElse(null);
    }

    @Override
    public String exportPictures() {
        StringBuilder sb = new StringBuilder();

        pictureRepository.findAllBySizeGreaterThanOrderBySizeAsc(30000)
                .stream()
                .forEach(pictures -> {
                    sb.append(String.format("%.2f – %s\n", pictures.getSize(), pictures.getPath()));
                });

        return sb.toString();
    }
}

package softuni.exam.service.impl;

import com.google.gson.Gson;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;
import softuni.exam.models.jsondto.PictureSeedDto;
import softuni.exam.models.entity.Picture;
import softuni.exam.repository.PictureRepository;
import softuni.exam.service.CarService;
import softuni.exam.service.PictureService;
import softuni.exam.util.ValidationUtil;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

@Component
public class PictureServiceImpl implements PictureService {
    public static final String PICTURES_OUTPUT_FILE = "src/main/resources/files/json/pictures.json";

    private final CarService carService;
    private final PictureRepository pictureRepository;
    private final Gson gson;
    private final ModelMapper modelMapper;
    private final ValidationUtil validationUtil;

    public PictureServiceImpl(CarService carService, PictureRepository pictureRepository, Gson gson, ModelMapper modelMapper, ValidationUtil validationUtil) {
        this.carService = carService;
        this.pictureRepository = pictureRepository;
        this.gson = gson;
        this.modelMapper = modelMapper;
        this.validationUtil = validationUtil;
    }

    @Override
    public boolean areImported() {
        return pictureRepository.count() > 0;
    }

    @Override
    public String readPicturesFromFile() throws IOException {
        return Files.readString(Path.of(PICTURES_OUTPUT_FILE));
    }

    @Override
    public String importPictures() throws IOException {
        StringBuilder sb = new StringBuilder();
        PictureSeedDto[] pictureSeedDtos = gson.fromJson(readPicturesFromFile(), PictureSeedDto[].class);

        Arrays.stream(pictureSeedDtos)
                .filter(pictureSeedDto -> {
                    boolean isValid = validationUtil.isValid(pictureSeedDto);

                    sb.append(isValid ? String.format("Successfully import picture - %s",
                            pictureSeedDto.getName()) : String.format("Invalid picture"));
                    sb.append(System.lineSeparator());

                    return isValid;
                })
                .map(pictureSeedDto -> {
                    Picture picture = modelMapper.map(pictureSeedDto, Picture.class);

                    picture.setCar(carService.findById(pictureSeedDto.getCar()));

                    return picture;
                })
                .forEach(pictureRepository::save);

        return sb.toString();
    }

}

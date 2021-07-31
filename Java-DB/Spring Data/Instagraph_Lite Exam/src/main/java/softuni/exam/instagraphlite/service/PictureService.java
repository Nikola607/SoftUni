package softuni.exam.instagraphlite.service;

import org.springframework.stereotype.Service;
import softuni.exam.instagraphlite.models.models.entity.Pictures;

import java.io.IOException;

@Service
public interface PictureService {
    boolean areImported();
    String readFromFileContent() throws IOException;
    String importPictures() throws IOException;
    String exportPictures();

    boolean isEntityExists(String profilePicture);

    Pictures findByPath(String profilePicture);

}

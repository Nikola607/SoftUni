package softuni.exam.service;


import org.springframework.stereotype.Service;
import softuni.exam.models.entity.Car;

import java.io.IOException;

@Service
public interface PictureService {

    boolean areImported();

    String readPicturesFromFile() throws IOException;
	
	String importPictures() throws IOException;

}

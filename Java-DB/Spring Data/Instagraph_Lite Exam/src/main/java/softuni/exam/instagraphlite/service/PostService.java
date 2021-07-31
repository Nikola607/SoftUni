package softuni.exam.instagraphlite.service;

import org.springframework.stereotype.Service;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public interface PostService {
    boolean areImported();
    String readFromFileContent() throws IOException;
    String importPosts() throws IOException, JAXBException;

}

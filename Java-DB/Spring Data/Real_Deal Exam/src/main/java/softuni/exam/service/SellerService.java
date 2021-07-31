package softuni.exam.service;

import org.springframework.stereotype.Service;
import softuni.exam.models.entity.Seller;

import javax.xml.bind.JAXBException;
import java.io.IOException;

@Service
public interface SellerService {

    boolean areImported();

    String readSellersFromFile() throws IOException;

    String importSellers() throws IOException, JAXBException;

    Seller findById(Long id);
}

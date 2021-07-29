package com.example.demo;

import com.example.demo.model.dto.CategoriesSeedRootDto;
import com.example.demo.model.dto.ProductSeedRootDto;
import com.example.demo.model.dto.UserSeedRootDto;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import com.example.demo.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.FileNotFoundException;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private static final String RECOURSE_FILES_PATH = "src/main/resources/09. XML-Processing-Exercises/";
    public static final String CATEGORY_FILE_PATH = "categories.xml";
    public static final String USER_FILE_PATH = "users.xml";
    public static final String PRODUCT_FILE_PATH = "products.xml";
    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;

    public CommandLineRunnerImpl(XmlParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();

    }

    private void seedData() throws JAXBException, FileNotFoundException {
        CategoriesSeedRootDto categoriesSeedRootDto = xmlParser.fromFile(RECOURSE_FILES_PATH + CATEGORY_FILE_PATH,
                CategoriesSeedRootDto.class);
        categoryService.seedCategories(categoriesSeedRootDto.getCategories());

        UserSeedRootDto userSeedRootDto = xmlParser.fromFile(RECOURSE_FILES_PATH + USER_FILE_PATH,
                UserSeedRootDto.class);
        userService.seedUsers(userSeedRootDto.getUsers());

        ProductSeedRootDto productSeedRootDto = xmlParser.fromFile(RECOURSE_FILES_PATH + PRODUCT_FILE_PATH,
                ProductSeedRootDto.class);
        productService.seedProducts(productSeedRootDto.getProducts());
    }
}

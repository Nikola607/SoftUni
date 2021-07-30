package com.example.demo;

import com.example.demo.model.dto.*;
import com.example.demo.service.CategoryService;
import com.example.demo.service.ProductService;
import com.example.demo.service.UserService;
import com.example.demo.util.XmlParser;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import javax.xml.bind.JAXBException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private static final String RECOURSE_FILES_PATH = "src/main/resources/09. XML-Processing-Exercises/";
    private static final String OUTPUT_FILES_PATH = "src/main/resources/09. XML-Processing-Exercises/out/";
    public static final String CATEGORY_FILE_PATH = "categories.xml";
    public static final String USER_FILE_PATH = "users.xml";
    public static final String PRODUCT_FILE_PATH = "products.xml";
    public static final String PRODUCTS_IN_RANGE = "products-in-range.xml";
    public static final String SOLD_PRODUCTS = "sold-products.xml";
    private final XmlParser xmlParser;
    private final CategoryService categoryService;
    private final UserService userService;
    private final ProductService productService;
    private final BufferedReader bufferedReader;

    public CommandLineRunnerImpl(XmlParser xmlParser, CategoryService categoryService, UserService userService, ProductService productService) {
        this.xmlParser = xmlParser;
        this.categoryService = categoryService;
        this.userService = userService;
        this.productService = productService;
        bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }


    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Select exercise number:");
        int num = Integer.parseInt(bufferedReader.readLine());

        switch (num){
            case 1 -> productsInRange();
            case 2 -> soldProducts();
        }
    }

    private void soldProducts() throws JAXBException {
        UserViewRootDto userViewRootDto = userService
                .findUsersWithMoreThatOneProduct();

        xmlParser.writeToFile(OUTPUT_FILES_PATH + SOLD_PRODUCTS,
                userViewRootDto);
    }

    private void productsInRange() throws JAXBException {
        ProductViewRootDto productViewRootDto = productService
                .findProductsWithoutBuyer();

        xmlParser.writeToFile(OUTPUT_FILES_PATH + PRODUCTS_IN_RANGE,
                productViewRootDto);
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

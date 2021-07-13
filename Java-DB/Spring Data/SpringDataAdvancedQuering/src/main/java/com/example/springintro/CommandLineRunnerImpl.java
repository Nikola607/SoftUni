package com.example.springintro;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Book;
import com.example.springintro.service.AuthorService;
import com.example.springintro.service.BookService;
import com.example.springintro.service.CategoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.stream.Collectors;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    private final CategoryService categoryService;
    private final AuthorService authorService;
    private final BookService bookService;
    private final BufferedReader bufferedReader;


    public CommandLineRunnerImpl(CategoryService categoryService, AuthorService authorService, BookService bookService, BufferedReader bufferedReader) {
        this.categoryService = categoryService;
        this.authorService = authorService;
        this.bookService = bookService;
        this.bufferedReader = bufferedReader;
    }

    @Override
    public void run(String... args) throws Exception {
        seedData();

        System.out.println("Select exercise number:");
        int num = Integer.parseInt(bufferedReader.readLine());

        switch (num) {
            case 1 -> exOne();
            case 2 -> exTwo();
            case 3 -> exThree();
            case 4 -> exFour();
            case 5 -> exFive();
            case 6 -> exSix();
            case 7 -> exSeven();
            case 8 -> exEight();
            case 9 -> exNine();
            case 10 -> exTen();
        }
    }

    private void exTen() {
    }

    private void exNine() throws IOException {
        System.out.println("Enter a number:");

        int num = Integer.parseInt(bufferedReader.readLine());
        int numberOfBooks = bookService.findAllBooksWithTitleLongerThat(num);

        System.out.printf("There are %s books with longer title than %s symbols\n", numberOfBooks, num);
    }

    private void exEight() throws IOException {
        System.out.println("Enter a String: ");

        String input = bufferedReader.readLine();

        bookService.bookTitleSearch(input)
                .forEach(System.out::println);
    }

    private void exSeven() throws IOException {
        System.out.println("Enter a String: ");

        String input = bufferedReader.readLine();

        bookService.findAllBooksContaining(input)
                .forEach(System.out::println);
    }

    private void exSix() throws IOException {
        System.out.println("Enter a String: ");

        String input = bufferedReader.readLine();
        authorService.findAllAuthorsWithNameEndingWith(input)
                .forEach(System.out::println);
    }

    private void exFive() throws IOException {
        System.out.println("Enter date in the format dd-mm-yyyy");

        LocalDate localDate = LocalDate.parse(bufferedReader.readLine(), DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        bookService.findAllBooksBeforeDate(localDate)
                .forEach(System.out::println);
    }

    private void exFour() throws IOException {
        System.out.println("Enter year:");

        int releaseDate = Integer.parseInt(bufferedReader.readLine());

        bookService.findAllBooksNotReleasedInThisYear(releaseDate)
                .forEach(System.out::println);
    }

    private void exThree() {
        bookService.findAllBooksWithPriceLowerThat5AndHigherThat40()
                .forEach(System.out::println);
    }

    private void exTwo() {
        bookService.findAllGoldenBooksLessThat5000Copies()
                .forEach(System.out::println);
    }

    private void exOne() throws IOException {
        System.out.println("Enter Age Restriction:");

        AgeRestriction ageRestriction = AgeRestriction.valueOf(bufferedReader.readLine().toUpperCase());
        bookService.findAllBooksTitlesWithAgeRestriction(ageRestriction)
                .forEach(System.out::println);
    }

    private void pritnALlBooksByAuthorNameOrderByReleaseDate(String firstName, String lastName) {
        bookService
                .findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(firstName, lastName)
                .forEach(System.out::println);
    }

    private void printAllAuthorsAndNumberOfTheirBooks() {
        authorService
                .getAllAuthorsOrderByCountOfTheirBooks()
                .forEach(System.out::println);
    }

    private void printAllAuthorsNamesWithBooksWithReleaseDateBeforeYear(int year) {
        bookService
                .findAllAuthorsWithBooksWithReleaseDateBeforeYear(year)
                .forEach(System.out::println);
    }

    private void printAllBooksAfterYear(int year) {
        bookService
                .findAllBooksAfterYear(year)
                .stream()
                .map(Book::getTitle)
                .forEach(System.out::println);
    }

    private void seedData() throws IOException {
        categoryService.seedCategories();
        authorService.seedAuthors();
        bookService.seedBooks();
    }
}

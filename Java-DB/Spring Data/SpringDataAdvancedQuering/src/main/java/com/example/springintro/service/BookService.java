package com.example.springintro.service;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public interface BookService {
    void seedBooks() throws IOException;

    List<Book> findAllBooksAfterYear(int year);

    List<String> findAllAuthorsWithBooksWithReleaseDateBeforeYear(int year);

    List<String> findAllBooksByAuthorFirstAndLastNameOrderByReleaseDate(String firstName, String lastName);

    List<String> findAllBooksTitlesWithAgeRestriction(AgeRestriction ageRestriction);

    List<String> findAllGoldenBooksLessThat5000Copies();

    List<String> findAllBooksWithPriceLowerThat5AndHigherThat40();

    List<String> findAllBooksNotReleasedInThisYear(int releaseDate);

    List<String> findAllBooksBeforeDate(LocalDate localDate);

    List<String> findAllBooksContaining(String input);

    List<String> bookTitleSearch(String input);

    int findAllBooksWithTitleLongerThat(int num);

}

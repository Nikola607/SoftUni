package com.example.springintro.repository;

import com.example.springintro.model.entity.AgeRestriction;
import com.example.springintro.model.entity.Author;
import com.example.springintro.model.entity.Book;
import com.example.springintro.model.entity.EditionType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findAllByReleaseDateAfter(LocalDate releaseDateAfter);

    List<Book> findAllByReleaseDateBefore(LocalDate releaseDateBefore);

    List<Book> findAllByAuthor_FirstNameAndAuthor_LastNameOrderByReleaseDateDescTitle(String author_firstName, String author_lastName);

    List<Book> findAllByAgeRestriction(AgeRestriction ageRestriction);

    List<Book> findAllByEditionTypeAndCopiesLessThan(EditionType editionType, Integer copies);

    List<Book> findAllByPriceLessThanOrPriceGreaterThan(BigDecimal price, BigDecimal price2);

    List<Book> findAllByReleaseDateBeforeOrReleaseDateAfter(LocalDate releaseDate, LocalDate releaseDate2);

    List<Book> findAllByTitleContaining(String title);

    List<Book> findAllByAuthor_LastNameStartsWith(String author_lastName);

    @Query("SELECT COUNT(b) FROM Book b WHERE length(b.title) > :param ")
    int findAllBooksWithTitleLongerThat(@Param(value = "param") int length);

//    @Query("SELECT SUM(b.copies), CONCAT(a.firstName, ' ', a.lastName) " +
//            "FROM spring_data_intro.domain.entities.Book AS b " +
//            "JOIN b.author AS a " +
//            "GROUP BY a.id " +
//            "ORDER BY SUM(b.copies) DESC")
//    List<Object[]> findAllByCountOfAllCopies();

    Book findBookByTitle(String title);
}

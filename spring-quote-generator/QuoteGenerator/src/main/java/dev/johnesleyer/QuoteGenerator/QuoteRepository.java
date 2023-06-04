package dev.johnesleyer.QuoteGenerator;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface QuoteRepository extends CrudRepository<Quote, Long>{
    // Custom query methods
    List<Quote> findByAuthor(String author);
}

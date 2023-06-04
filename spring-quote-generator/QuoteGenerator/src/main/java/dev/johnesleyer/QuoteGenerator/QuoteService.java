package dev.johnesleyer.QuoteGenerator;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class QuoteService {
    private final QuoteRepository quoteRepository;

    @Autowired
    public QuoteService(QuoteRepository quoteRepository){
        this.quoteRepository = quoteRepository;
    }

    public Quote getRandomQuote(){
        List<Quote> quotes = (List<Quote>) quoteRepository.findAll();
        if (!quotes.isEmpty()){
            int randomIndex = new Random().nextInt(quotes.size());
            return quotes.get(randomIndex);
        }
        return null;
    }

    public List<Quote> searchQuotesByAuthor(String author){
        return quoteRepository.findByAuthor(author);
    }

    public Quote addQuote(Quote quote){
        return quoteRepository.save(quote);
    }
}

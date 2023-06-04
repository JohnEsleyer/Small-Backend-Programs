package dev.johnesleyer.QuoteGenerator;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class QuoteServiceTest {
    @Mock
    private QuoteRepository quoteRepository;

    private QuoteService quoteService;

    @BeforeEach
    public void setup(){
       MockitoAnnotations.openMocks(this);
       quoteService = new QuoteService(quoteRepository);
    }

    @Test
    public void testGetRandomQuote() {
        // Create a list of quotes for testing
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("Quote 1", "Author 1"));
        quotes.add(new Quote("Quote 2", "Author 2"));

        // Mock the repository behavior
        when(quoteRepository.findAll()).thenReturn(quotes);

        // Call the service method
        Quote randomQuote = quoteService.getRandomQuote();

        // Verify the result
        assertEquals(quotes.contains(randomQuote), true);
    }
    @Test
    public void testSearchQuotesByAuthor() {
        // Create a list of quotes for testing
        List<Quote> quotes = new ArrayList<>();
        quotes.add(new Quote("Quote 1", "Author 1"));
        quotes.add(new Quote("Quote 2", "Author 2"));

        // Mock the repository behavior
        when(quoteRepository.findByAuthor("Author 1")).thenReturn(quotes.subList(0, 1));

        // Call the service method
        List<Quote> result = quoteService.searchQuotesByAuthor("Author 1");

        // Verify the result
        assertEquals(1, result.size());
        assertEquals("Quote 1", result.get(0).getText());
        assertEquals("Author 1", result.get(0).getAuthor());
    }
}

package dev.johnesleyer.QuoteGenerator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/quote")
public class QuoteController {
    private final QuoteService quoteService;

    @Autowired 
    public QuoteController(QuoteService quoteService){
        this.quoteService = quoteService;
    }

    @GetMapping("/random")
    public Quote getRandomQuote(){
        return quoteService.getRandomQuote();
    }

    @PostMapping("/add")
    public Quote addQuote(@RequestBody Quote quote){
        return quoteService.addQuote(quote);
    }
}

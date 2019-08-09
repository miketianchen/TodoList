import model.Quote;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class QuoteTest {
    Quote quote;

    @BeforeEach
    public void setup() {
        quote = new Quote("something something", "me");
    }

    @Test
    public void testGetters() {
        assertTrue(quote.getQuote().equals("something something"));
        assertTrue(quote.getAuthor().equals("me"));
    }

    @Test
    public void testSetters() {
        quote.setQuote("new new");
        quote.setAuthor("you");

        assertFalse(quote.getQuote().equals("something something"));
        assertFalse(quote.getAuthor().equals("me"));
    }
}

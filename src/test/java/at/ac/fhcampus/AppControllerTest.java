package at.ac.fhcampus;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {

    @Test
    void setArticles() {
    }

    @Test
    void getArticleCount() {
    }

    @Test
    void getTopHeadlinesAustria() {
    }

    @Test
    void getAllNewsBitcoin() {
        AppController test = new AppController();
        List<Article> actual  = test.getAllNewsBitcoin();

        List<Article> expected = new ArrayList<Article>();
        expected.add(new Article("Author1","Bitcoin1"));
        expected.add(new Article("Author2","Bitcoin2"));

        assertEquals(expected.size(),actual.size());
    }

    @Test
    void filterList() {
    }
}
package at.ac.fhcampus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {

    /*@Test
    @DisplayName("Checks if the number of articles set is correct")
    void setArticles1() {
        AppController test = new AppController();
        List<Article> inputList = List.of(new Article("Author1", "Title1", description, url, urlToImage, publishedAt, content), new Article("Author2", "Title2", description, url, urlToImage, publishedAt, content),
                new Article("Author3", "Title3", description, url, urlToImage, publishedAt, content), new Article("Author4", "Title4", description, url, urlToImage, publishedAt, content));
        test.setArticles(inputList);

        List<Article> testList1 = new ArrayList<>();
        testList1.add(new Article("Author1", "Title1", description, url, urlToImage, publishedAt, content));
        testList1.add(new Article("Author2", "Title2", description, url, urlToImage, publishedAt, content));
        testList1.add(new Article("Author3", "Title3", description, url, urlToImage, publishedAt, content));
        testList1.add(new Article("Author4", "Title4", description, url, urlToImage, publishedAt, content));
        List<Article> actual = test.getArticles();

        assertEquals(testList1.size(), actual.size());
    }

    @Test
    @DisplayName("Checks if the articles set are correct")
    void setArticles2() {
        AppController test = new AppController();
        List<Article> inputList = List.of(new Article("Author1", "Title1", description, url, urlToImage, publishedAt, content), new Article("Author2", "Title2", description, url, urlToImage, publishedAt, content),
                new Article("Author3", "Title3", description, url, urlToImage, publishedAt, content), new Article("Author4", "Title4", description, url, urlToImage, publishedAt, content));
        test.setArticles(inputList);
        List<Article> testList1 = new ArrayList<>();
        testList1.add(new Article("Author1", "Title1", description, url, urlToImage, publishedAt, content));
        testList1.add(new Article("Author2", "Title2", description, url, urlToImage, publishedAt, content));
        testList1.add(new Article("Author3", "Title3", description, url, urlToImage, publishedAt, content));
        testList1.add(new Article("Author4", "Title4", description, url, urlToImage, publishedAt, content));
        List<Article> actual = test.getArticles();

        assertEquals(testList1, actual);
    }

    @Test
    @DisplayName("Check if the number of articles in getArticleCount() is correct")
    void getArticleCount1() {
        AppController test = new AppController();
        List<Article> inputList = List.of(new Article("Author1", "Title1", description, url, urlToImage, publishedAt, content), new Article("Author2", "Title2", description, url, urlToImage, publishedAt, content),
                new Article("Author3", "Title3", description, url, urlToImage, publishedAt, content), new Article("Author4", "Title4", description, url, urlToImage, publishedAt, content));

        test.setArticles(inputList);

        int articleCount = 4;
        assertEquals(articleCount, test.getArticleCount());
    }

    @Test
    @DisplayName("Checks for correct behaviour (to return 0) on empty Articles List")
    void getArticleCountEmptyArticles() {
        try {
            final int count = new AppController().getArticleCount();
            assertEquals(0, count, "Article count should equal 0");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @DisplayName("Checks if the articles were filtered correctly")
    void getTopHeadlinesAustriaWithFilledList() {
        AppController test = new AppController();
        List<Article> inputList = List.of(new Article("Author1", "Austria1", description, url, urlToImage, publishedAt, content), new Article("Author2", "Belgium", description, url, urlToImage, publishedAt, content),
                new Article("Author3", "Austria2", description, url, urlToImage, publishedAt, content), new Article("Author4", "Austria3", description, url, urlToImage, publishedAt, content));
        test.setArticles(inputList);

        List<Article> expected = new ArrayList<>();
        expected.add(new Article("Author1", "Austria1", description, url, urlToImage, publishedAt, content));
        expected.add(new Article("Author2", "Belgium", description, url, urlToImage, publishedAt, content)); // TODO: CHANGE WHEN IMPLEMENTING REAL LOGIC FOR getTopHeadlinesAustria
        expected.add(new Article("Author3", "Austria2", description, url, urlToImage, publishedAt, content));
        expected.add(new Article("Author4", "Austria3", description, url, urlToImage, publishedAt, content));

        assertEquals(expected, test.getTopHeadlinesAustria(), "Lists should be equal");
    }

    @Test
    @DisplayName("Checks if an empty List is returned as an empty List")
    void getTopHeadlinesAustriaWithEmptyList() {
        AppController test = new AppController();

        assertEquals(Collections.emptyList(), test.getTopHeadlinesAustria(), "List should be empty");
    }

    @Test
    @DisplayName("Checks if the articles were filtered correctly")
    void getAllNewsBitcoinTest() {
        AppController test = new AppController();
        List<Article> inputList = List.of(new Article("Author1", "Bitcoin1", description, url, urlToImage, publishedAt, content), new Article("Author2", "Bitcoin2", description, url, urlToImage, publishedAt, content),
                new Article("Author3", "Stefan", description, url, urlToImage, publishedAt, content), new Article("Author4", "Ripple", description, url, urlToImage, publishedAt, content));
        test.setArticles(inputList);

        List<Article> expected = new ArrayList<>();
        expected.add(new Article("Author1", "Bitcoin1", description, url, urlToImage, publishedAt, content));
        expected.add(new Article("Author2", "Bitcoin2", description, url, urlToImage, publishedAt, content));

        assertEquals(expected, test.getAllNewsBitcoin(), "Filter result incorrect");
    }

    @Test
    @DisplayName("Expects empty List if no Articles in AppController")
    void getAllNewsBitcoinEmptyTest() {
        AppController test = new AppController();

        assertEquals(Collections.emptyList(), test.getAllNewsBitcoin(), "List should be empty");
    }

    @Test
    @DisplayName("Filter List with a valid Query")
    void filterListWithValidQuery() {
        try {
            List<Article> inputList = List.of(new Article("New York Times", "Something happened", description, url, urlToImage, publishedAt, content),
                    new Article("Financial Times", "Something else happened", description, url, urlToImage, publishedAt, content));

            assertEquals(inputList, AppController.filterList("SoMeThInG", inputList), "Filter result incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @DisplayName("Filter List with an empty Query")
    void filterListWithEmptyQuery() {
        try {
            List<Article> inputList = List.of(new Article("New York Times", "Something happened", description, url, urlToImage, publishedAt, content),
                    new Article("Financial Times", "Something else happened", description, url, urlToImage, publishedAt, content));

            assertEquals(inputList, AppController.filterList("", inputList), "Filter result incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    @DisplayName("Filter List with query not found in Articles")
    void filterListWithQueryNotFoundInArticles() {
        try {
            List<Article> inputList = List.of(new Article("New York Times", "Something happened", description, url, urlToImage, publishedAt, content),
                    new Article("Financial Times", "Something else happened", description, url, urlToImage, publishedAt, content));

            assertEquals(Collections.emptyList(), AppController.filterList("Günther", inputList), "Filter result incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
    */

}

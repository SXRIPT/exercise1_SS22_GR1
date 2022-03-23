package at.ac.fhcampus;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class AppControllerTest {

    @Test
    void setArticles1() {
        // methode checks if the number of articles set is correct
        AppController test = new AppController();
        List<Article> inputList = List.of(new Article("Author1", "Title1"), new Article("Author2", "Title2"),
                new Article("Author3", "Title3"), new Article("Author4", "Title4"));
        test.setArticles(inputList);

        List<Article> testList1 = new ArrayList<>();
        testList1.add(new Article("Author1", "Title1"));
        testList1.add(new Article("Author2", "Title2"));
        testList1.add(new Article("Author3", "Title3"));
        testList1.add(new Article("Author4", "Title4"));
        List<Article> actual = test.getArticles();

        assertEquals(testList1.size(), actual.size());
    }

    @Test
    void setArticles2() {
        // method checks if the articles set are correct
        AppController test = new AppController();
        List<Article> inputList = List.of(new Article("Author1", "Title1"), new Article("Author2", "Title2"),
                new Article("Author3", "Title3"), new Article("Author4", "Title4"));
        test.setArticles(inputList);
        List<Article> testList1 = new ArrayList<>();
        testList1.add(new Article("Author1", "Title1"));
        testList1.add(new Article("Author2", "Title2"));
        testList1.add(new Article("Author3", "Title3"));
        testList1.add(new Article("Author4", "Title4"));
        List<Article> actual = test.getArticles();

        assertEquals(testList1, actual);
    }

    @Test
    void getArticleCount1() {
        // check if the number of articles in the getArticleCount method is correct.
        AppController test = new AppController();
        List<Article> inputList = List.of(new Article("Author1", "Title1"), new Article("Author2", "Title2"),
                new Article("Author3", "Title3"), new Article("Author4", "Title4"));

        test.setArticles(inputList);

        int articleCount = 4;
        assertEquals(articleCount, test.getArticleCount());
    }

    @Test
    void getArticleCountEmptyArticles() {
        // Checks for correct behaviour (to return 0) on empty Articles List
        try {
            final int count = new AppController().getArticleCount();
            assertEquals(0, count, "Article count should equal 0");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void getTopHeadlinesAustriaWithFilledList() {
        // method checks if the articles were filtered correctly
        AppController test = new AppController();
        List<Article> inputList = List.of(new Article("Author1", "Austria1"), new Article("Author2", "Belgium"),
                new Article("Author3", "Austria2"), new Article("Author4", "Austria3"));
        test.setArticles(inputList);

        List<Article> expected = new ArrayList<>();
        expected.add(new Article("Author1", "Austria1"));
        expected.add(new Article("Author2", "Belgium")); // TODO: CHANGE WHEN IMPLEMENTING REAL LOGIC FOR getTopHeadlinesAustria
        expected.add(new Article("Author3", "Austria2"));
        expected.add(new Article("Author4", "Austria3"));

        assertEquals(expected, test.getTopHeadlinesAustria(), "Lists should be equal");
    }

    @Test
    void getTopHeadlinesAustriaWithEmptyList() {
        // method checks if an empty List is returned as an empty List
        AppController test = new AppController();

        assertEquals(Collections.emptyList(), test.getTopHeadlinesAustria(), "List should be empty");
    }

    @Test
    void getAllNewsBitcoinTest() {
        // method checks if the articles were filtered correctly
        AppController test = new AppController();
        List<Article> inputList = List.of(new Article("Author1", "Bitcoin1"), new Article("Author2", "Bitcoin2"),
                new Article("Author3", "Stefan"), new Article("Author4", "Ripple"));
        test.setArticles(inputList);

        List<Article> expected = new ArrayList<>();
        expected.add(new Article("Author1", "Bitcoin1"));
        expected.add(new Article("Author2", "Bitcoin2"));

        assertEquals(expected, test.getAllNewsBitcoin(), "Filter result incorrect");
    }

    @Test
    void getAllNewsBitcoinEmptyTest() {
        // method checks if an empty List is returned as an empty List
        AppController test = new AppController();

        assertEquals(Collections.emptyList(), test.getAllNewsBitcoin(), "List should be empty");
    }

    @Test
    void filterListWithValidQuery() {
        // Filter List with a valid Query
        try {
            List<Article> inputList = List.of(new Article("New York Times", "Something happened"),
                    new Article("Financial Times", "Something else happened"));

            assertEquals(inputList, AppController.filterList("SoMeThInG", inputList), "Filter result incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void filterListWithEmptyQuery() {
        // Filter List with an empty Query
        try {
            List<Article> inputList = List.of(new Article("New York Times", "Something happened"),
                    new Article("Financial Times", "Something else happened"));

            assertEquals(inputList, AppController.filterList("", inputList), "Filter result incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void filterListWithQueryNotFoundInArticles() {
        // Filter List with query not found in Articles
        try {
            List<Article> inputList = List.of(new Article("New York Times", "Something happened"),
                    new Article("Financial Times", "Something else happened"));

            assertEquals(Collections.emptyList(), AppController.filterList("Günther", inputList), "Filter result incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}

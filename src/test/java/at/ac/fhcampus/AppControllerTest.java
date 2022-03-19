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

        List<Article> testList1 = new ArrayList<Article>();
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
        List<Article> testList1 = new ArrayList<Article>();
        testList1.add(new Article("Author1", "Title1"));
        testList1.add(new Article("Author2", "Title2"));
        testList1.add(new Article("Author3", "Title3"));
        testList1.add(new Article("Author4", "Title4"));
        List<Article> actual = test.getArticles();

        assertEquals(testList1.containsAll(actual), actual.containsAll(testList1));

    }

    @Test
    void getArticleCount1() {
        AppController test = new AppController();
        List<Article> inputList = List.of(new Article("Author1", "Title1"), new Article("Author2", "Title2"),
                new Article("Author3", "Title3"), new Article("Author4", "Title4"));

        test.setArticles(inputList);

        int articleCount = 4;
        assertEquals(articleCount, test.getArticleCount());

    }


    @Test
    void getTopHeadlinesAustriaWithFilledList() {
        // method checks if the articles were filtered correctly
        AppController test = new AppController();
        List<Article> inputList = List.of(new Article("Author 1", "Austria1"), new Article("Author2", "Belgium"),
                new Article("Author3", "Austria2"), new Article("Author4", "Austria3"));
        test.setArticles(inputList);

        List<Article> expected = new ArrayList<Article>();
        expected.add(new Article("Author1", "Austria1"));
        expected.add(new Article("Author3", "Austria2"));
        expected.add(new Article("Author4", "Austria3"));

        assertEquals(expected.containsAll(test.getTopHeadlinesAustria()), test.getTopHeadlinesAustria().containsAll(expected));
    }

    @Test
    void getTopHeadlinesAustriaWithEmptyList() {
        // method checks if an empty List is returned as an empty List
        AppController test = new AppController();

        assertEquals(Collections.emptyList(), test.getTopHeadlinesAustria(), "List should be empty");
    }

    @Test
    void getAllNewsBitcoinTest() {
        AppController test = new AppController();
        List<Article> inputList = List.of(new Article("Author1", "Bitcoin1"), new Article("Author2", "Bitcoin2"),
                new Article("Author3", "Stefan"), new Article("Author4", "Ripple"));
        test.setArticles(inputList);

        List<Article> expected = new ArrayList<Article>();
        expected.add(new Article("Author1", "Bitcoin1"));
        expected.add(new Article("Author2", "Bitcoin2"));

        assertEquals(expected.containsAll(test.getAllNewsBitcoin()), test.getAllNewsBitcoin().containsAll(expected), "Filter result incorrect");
    }

    @Test
    void getAllNewsBitcoinEmptyTest() {
        AppController test = new AppController();

        assertEquals(Collections.emptyList(), test.getAllNewsBitcoin(), "List should be empty");
    }

    @Test
    void filterListWithValidQuery() {
        try {
            final AppController controller = new AppController();
            List<Article> inputList = List.of(new Article("New York Times", "Something happened"),
                    new Article("Financial Times", "Something else happened"));

            assertEquals(inputList, controller.filterList("SoMeThInG", inputList), "Filter result incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void filterListWithEmptyQuery() {
        try {
            final AppController controller = new AppController();
            List<Article> inputList = List.of(new Article("New York Times", "Something happened"),
                    new Article("Financial Times", "Something else happened"));

            assertEquals(inputList, controller.filterList("", inputList), "Filter result incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }

    @Test
    void filterListWithQueryNotFoundInArticles() {
        try {
            final AppController controller = new AppController();
            List<Article> inputList = List.of(new Article("New York Times", "Something happened"),
                    new Article("Financial Times", "Something else happened"));

            assertNotEquals(inputList, controller.filterList("Günther", inputList), "Filter result incorrect");
        } catch (Exception e) {
            e.printStackTrace();
            fail();
        }
    }
}

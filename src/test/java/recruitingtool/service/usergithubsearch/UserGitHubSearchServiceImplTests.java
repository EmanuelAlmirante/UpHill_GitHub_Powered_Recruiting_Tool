package recruitingtool.service.usergithubsearch;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import recruitingtool.exception.BusinessException;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

@RunWith(MockitoJUnitRunner.class)
public class UserGitHubSearchServiceImplTests {

    @InjectMocks
    private UserGitHubSearchServiceImpl userGitHubSearchService;

    @Test
    private void searchGitHubUsersByLocationAndLanguageAndFollowersSuccessfully() {
        // Arrange
        String location = "lisbon";
        String language = "java";
        String followers = "1000";

        Map<String, String> queryParamsMap = new HashMap<>() {{
            put("location:", location);
            put("language:", language);
            put("followers:>=", followers);
        }};

        // Act
        userGitHubSearchService.searchGitHubUsersByParameters(queryParamsMap);

        // Assert
    }

    @Test
    private void searchGitHubUsersByLocationSuccessfully() {
        // Arrange
        String location = "lisbon";
        String language = null;
        String followers = null;

        Map<String, String> queryParamsMap = new HashMap<>() {{
            put("location:", location);
            put("language:", language);
            put("followers:>=", followers);
        }};

        // Act
        userGitHubSearchService.searchGitHubUsersByParameters(queryParamsMap);

        // Assert
    }

    @Test
    private void searchGitHubUsersByLanguageSuccessfully() {
        // Arrange
        String location = null;
        String language = "java";
        String followers = null;

        Map<String, String> queryParamsMap = new HashMap<>() {{
            put("location:", location);
            put("language:", language);
            put("followers:>=", followers);
        }};

        // Act

        // Assert
    }

    @Test
    private void searchGitHubUsersByFollowersSuccessfully() {
        // Arrange
        String location = null;
        String language = null;
        String followers = "1000";

        Map<String, String> queryParamsMap = new HashMap<>() {{
            put("location:", location);
            put("language:", language);
            put("followers:>=", followers);
        }};

        // Act

        // Assert
    }

    @Test
    private void searchGitHubUsersByLocationAndLanguageSuccessfully() {
        // Arrange
        String location = "lisbon";
        String language = "java";
        String followers = null;

        Map<String, String> queryParamsMap = new HashMap<>() {{
            put("location:", location);
            put("language:", language);
            put("followers:>=", followers);
        }};

        // Act

        // Assert
    }

    @Test
    private void searchGitHubUsersByLocationAndFollowersSuccessfully() {
        // Arrange
        String location = "lisbon";
        String language = null;
        String followers = "1000";

        Map<String, String> queryParamsMap = new HashMap<>() {{
            put("location:", location);
            put("language:", language);
            put("followers:>=", followers);
        }};

        // Act

        // Assert
    }

    @Test
    private void searchGitHubUsersByLanguageAndFollowersSuccessfully() {
        // Arrange
        String location = null;
        String language = "java";
        String followers = "1000";

        Map<String, String> queryParamsMap = new HashMap<>() {{
            put("location:", location);
            put("language:", language);
            put("followers:>=", followers);
        }};

        // Act

        // Assert
    }

    @Test(expected = BusinessException.class)
    public void searchGitHubUsersByNoParamsFails() {
        // Arrange
        String location = "lisbon";
        String language = "java";
        String followers = "1000";

        Map<String, String> queryParamsMap = new HashMap<>() {{
            put("location:", location);
            put("language:", language);
            put("followers:>=", followers);
        }};

        // Act && Assert
        try {
            userGitHubSearchService.searchGitHubUsersByParameters(queryParamsMap);
        } catch (BusinessException be) {
            String exceptionMessage = "Query cannot be empty! Please choose a location or language or followers!";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of all params null was not thrown!");
    }
}

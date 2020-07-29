package recruitingtool.controller;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserGitHubSearchControllerTests extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void searchGitHubUsersByLocationAndLanguageAndFollowersSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?location=lisbon&language=java&followers=1000";

        // Act
        MvcResult mvcResult = mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
                                                  .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isOk())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLocationSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?location=lisbon";

        // Act
        MvcResult mvcResult = mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
                                                  .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isOk())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLanguageSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?language=java";

        // Act
        MvcResult mvcResult = mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
                                                  .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isOk())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByFollowersSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?followers=1000";

        // Act
        MvcResult mvcResult = mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
                                                  .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isOk())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLocationAndLanguageSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?location=lisbon&language=java";

        // Act
        MvcResult mvcResult = mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
                                                  .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isOk())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLocationFollowersSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?location=lisbon&followers=1000";

        // Act
        MvcResult mvcResult = mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
                                                  .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isOk())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLanguageAndFollowersSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?language=java&followers=1000";

        // Act
        MvcResult mvcResult = mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
                                                  .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isOk())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByNoParamsFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?";

        // Act
        MvcResult mvcResult = mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
                                                  .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isInternalServerError())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"Query cannot be empty! Please choose a location or language or followers!\",\"arguments\":[]}}";

        // Assert
        assertNotNull(jsonResponse);
    }
}

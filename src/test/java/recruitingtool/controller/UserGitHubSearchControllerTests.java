package recruitingtool.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserGitHubSearchControllerTests extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void searchGitHubUsersByLocationAndLanguageAndFollowersWithAuthenticationSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?location=lisbon&language=java&followers=1000";

        // Act
        MvcResult mvcResult = mvc.perform(get(uri).with(httpBasic("admin", "admin"))
                                                  .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                  .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isOk())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLocationWithAuthenticationSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?location=lisbon";

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                    .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isOk())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLanguageWithAuthenticationSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?language=java";

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                    .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isOk())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByFollowersWithAuthenticationSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?followers=1000";

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                    .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isOk())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLocationAndLanguageWithAuthenticationSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?location=lisbon&language=java";

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                    .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isOk())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLocationFollowersWithAuthenticationSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?location=lisbon&followers=1000";

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                    .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isOk())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLanguageAndFollowersWithAuthenticationSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?language=java&followers=1000";

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                    .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isOk())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByNoParamsWithAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?";

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                    .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isInternalServerError())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"Query cannot be empty! Please choose a location or language or followers!\",\"arguments\":[]}}";

        // Assert
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLocationAndLanguageAndFollowersWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?location=lisbon&language=java&followers=1000";

        // Act
        MvcResult mvcResult = mvc.perform(get(uri).with(httpBasic("admin", "wrongPassword"))
                                                  .contentType(MediaType.APPLICATION_JSON_VALUE)
                                                  .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isUnauthorized())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLocationWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?location=lisbon";

        // Act
        MvcResult mvcResult =
                mvc.perform(
                        get(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isUnauthorized())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLanguageWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?language=java";

        // Act
        MvcResult mvcResult =
                mvc.perform(
                        get(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isUnauthorized())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByFollowersWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?followers=1000";

        // Act
        MvcResult mvcResult =
                mvc.perform(
                        get(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isUnauthorized())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLocationAndLanguageWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?location=lisbon&language=java";

        // Act
        MvcResult mvcResult =
                mvc.perform(
                        get(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isUnauthorized())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLocationFollowersWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?location=lisbon&followers=1000";

        // Act
        MvcResult mvcResult =
                mvc.perform(
                        get(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isUnauthorized())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByLanguageAndFollowersWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?language=java&followers=1000";

        // Act
        MvcResult mvcResult =
                mvc.perform(
                        get(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isUnauthorized())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void searchGitHubUsersByNoParamsWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/github-search?";

        // Act
        MvcResult mvcResult =
                mvc.perform(
                        get(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isUnauthorized())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }
}

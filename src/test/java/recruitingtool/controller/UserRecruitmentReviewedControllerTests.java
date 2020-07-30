package recruitingtool.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MvcResult;
import recruitingtool.model.UserRecruitmentReviewedModel;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserRecruitmentReviewedControllerTests extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void createUserRecruitmentReviewedModelWithAuthenticationSuccessfully() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Junior";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = 9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isCreated())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        int id = JsonPath.parse(jsonResponse).read("$.id");

        String expectedResponse = "{" +
                "\"id\":" + id + "," +
                "\"jobCategory\":\"" + jobCategory + "\"," +
                "\"skillLevel\":\"" + skillLevel + "\"," +
                "\"fitForJobScale\":" + fitForJobScale + "," +
                "\"commentary\":\"" + commentary + "\"," +
                "\"name\":\"" + name + "\"," +
                "\"company\":\"" + company + "\"," +
                "\"blog\":\"" + blog + "\"," +
                "\"location\":\"" + location + "\"," +
                "\"email\":\"" + email + "\"," +
                "\"bio\":\"" + bio + "\"," +
                "\"numberOfFollowers\":" + numberOfFollowers + "," +
                "\"numberOfFollowing\":" + numberOfFollowing + "," +
                "\"gitHubUrl\":\"" + gitHubUrl + "\"," +
                "\"repos\":[\"" + repos.get(0) + "\",\"" + repos.get(1) + "\"" + "]" +
                "}";

        // Assert
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidJobCategoryWithAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "DevOps";
        String skillLevel = "Junior";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = 9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isInternalServerError())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"Job category is invalid! Must be one of: Frontend, Backend, QA, Data Analyst!\",\"arguments\":[]}}";

        // Assert
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidSkillLevelWithAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Distinguished";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = 9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isInternalServerError())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"Skill level is invalid! Must be one of: Junior, Mid-level, Expert!\",\"arguments\":[]}}";

        // Assert
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidFitForJobScaleWithAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Junior";
        int fitForJobScale = 10;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = 9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isInternalServerError())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"Fit for job scale is invalid! Must be between 1 and 5!\",\"arguments\":[]}}";

        // Assert
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidNameWithAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Junior";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = null;
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = 9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isInternalServerError())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"Name is invalid! Must contain a string!\",\"arguments\":[]}}";

        // Assert
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidNumberOfFollowersWithAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Junior";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = -3130;
        int numberOfFollowing = 9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isInternalServerError())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"Number of followers is invalid! Must be a positive integer!\",\"arguments\":[]}}";

        // Assert
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidNumberOfFollowingWithAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Junior";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = -9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isInternalServerError())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"Number of following is invalid! Must be a positive integer!\",\"arguments\":[]}}";

        // Assert
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidGitHubUrlWithAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Junior";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = 9;
        String gitHubUrl = null;
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isInternalServerError())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse =
                "{\"BusinessError\":{\"messageKey\":\"GitHub URL is invalid! Must be a string!\",\"arguments\":[]}}";

        // Assert
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void getAllUserRecruitmentReviewedModelWithAuthenticationReturnsPopulatedList() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Junior";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = 9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        mvc.perform(post(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                             .content(inputJson)
                             .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isCreated())
           .andReturn();

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                    .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isOk()).andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();
        int id = JsonPath.parse(jsonResponse).read("$[0].id");

        String expectedResponse = "[{" +
                "\"id\":" + id + "," +
                "\"jobCategory\":\"" + jobCategory + "\"," +
                "\"skillLevel\":\"" + skillLevel + "\"," +
                "\"fitForJobScale\":" + fitForJobScale + "," +
                "\"commentary\":\"" + commentary + "\"," +
                "\"name\":\"" + name + "\"," +
                "\"company\":\"" + company + "\"," +
                "\"blog\":\"" + blog + "\"," +
                "\"location\":\"" + location + "\"," +
                "\"email\":\"" + email + "\"," +
                "\"bio\":\"" + bio + "\"," +
                "\"numberOfFollowers\":" + numberOfFollowers + "," +
                "\"numberOfFollowing\":" + numberOfFollowing + "," +
                "\"gitHubUrl\":\"" + gitHubUrl + "\"," +
                "\"repos\":[\"" + repos.get(0) + "\",\"" + repos.get(1) + "\"" + "]" +
                "}]";

        // Assert
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void getAllUserRecruitmentReviewedModelWithAuthenticationReturnsEmptyList() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).with(httpBasic("admin", "admin")).contentType(MediaType.APPLICATION_JSON_VALUE)
                                    .accept(MediaType.APPLICATION_JSON))
                   .andExpect(status().isOk())
                   .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse = "[]";

        // Assert
        assertEquals(expectedResponse, jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedModelWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Junior";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = 9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isUnauthorized())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidJobCategoryWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "DevOps";
        String skillLevel = "Junior";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = 9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isUnauthorized())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidSkillLevelWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Distinguished";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = 9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isUnauthorized())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidFitForJobScaleWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Junior";
        int fitForJobScale = 10;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = 9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isUnauthorized())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidNameWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Junior";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = null;
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = 9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isUnauthorized())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidNumberOfFollowersWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Junior";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = -3130;
        int numberOfFollowing = 9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isUnauthorized())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidNumberOfFollowingWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Junior";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = -9;
        String gitHubUrl = "https://github.com/simplesteph";
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isUnauthorized())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void createUserRecruitmentReviewedWithInvalidGitHubUrlWithoutAuthenticationFails() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        String jobCategory = "Backend";
        String skillLevel = "Junior";
        int fitForJobScale = 3;
        String commentary = "Nothing to comment upon.";
        String name = "Stephane Maarek";
        String company = "@datacumulus";
        String blog = "https://courses.datacumulus.com/";
        String location = "Lisbon + moving around the world";
        String email = "N.A.";
        String bio =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowers = 3130;
        int numberOfFollowing = 9;
        String gitHubUrl = null;
        List<String> repos = Arrays.asList("https://github.com/simplesteph/ansible",
                                           "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith().withJobCategory(jobCategory)
                                                    .withSkillLevel(skillLevel).withFitForJobScale(fitForJobScale)
                                                    .withCommentary(commentary).withName(name).withCompany(company)
                                                    .withBlog(blog).withLocation(location).withEmail(email).withBio(bio)
                                                    .withNumberOfFollowers(numberOfFollowers)
                                                    .withNumberOfFollowing(numberOfFollowing).withGitHubUrl(gitHubUrl)
                                                    .withRepos(repos).build();

        String inputJson = super.mapToJson(userRecruitmentReviewedModelToBeCreated);

        // Act
        MvcResult mvcResult = mvc.perform(
                post(uri).with(httpBasic("admin", "wrongPassword")).contentType(MediaType.APPLICATION_JSON_VALUE)
                         .content(inputJson)
                         .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isUnauthorized())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        // Assert
        assertNotNull(jsonResponse);
    }

    @Test
    public void getAllUserRecruitmentReviewedModelWithoutAuthenticationFails() throws Exception {
        // Arrange
        // Arrange
        String uri = "/uphill/api/recruiting";

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

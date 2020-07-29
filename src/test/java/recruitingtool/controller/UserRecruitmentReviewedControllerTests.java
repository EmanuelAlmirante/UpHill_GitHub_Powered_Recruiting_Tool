package recruitingtool.controller;

import com.jayway.jsonpath.JsonPath;
import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MvcResult;
import recruitingtool.model.UserRecruitmentReviewedModel;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserRecruitmentReviewedControllerTests extends AbstractTest {
    @Override
    @Before
    public void setUp() {
        super.setUp();
    }

    @Test
    public void createUserRecruitmentReviewedModelSuccessfully() throws Exception {
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
        MvcResult mvcResult = mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)
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
    public void createUserRecruitmentReviewedWithInvalidJobCategoryFails() throws Exception {
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
        MvcResult mvcResult = mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)
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
    public void createUserRecruitmentReviewedWithInvalidSkillLevelFails() throws Exception {
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
        MvcResult mvcResult = mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)
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
    public void createUserRecruitmentReviewedWithInvalidFitForJobScaleFails() throws Exception {
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
        MvcResult mvcResult = mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)
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
    public void createUserRecruitmentReviewedWithInvalidNameFails() throws Exception {
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
        MvcResult mvcResult = mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)
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
    public void createUserRecruitmentReviewedWithInvalidNumberOfFollowersFails() throws Exception {
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
        MvcResult mvcResult = mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)
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
    public void createUserRecruitmentReviewedWithInvalidNumberOfFollowingFails() throws Exception {
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
        MvcResult mvcResult = mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)
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
    public void createUserRecruitmentReviewedWithInvalidGitHubUrlFails() throws Exception {
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
        MvcResult mvcResult = mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)
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
    public void getAllUserRecruitmentReviewedModelReturnsPopulatedList() throws Exception {
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

        mvc.perform(post(uri).contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)
                             .accept(MediaType.APPLICATION_JSON))
           .andExpect(status().isCreated())
           .andReturn();

        // Act
        MvcResult mvcResult =
                mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON))
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
    public void getAllUserRecruitmentReviewedModelReturnsEmptyList() throws Exception {
        // Arrange
        String uri = "/uphill/api/recruiting";

        // Act
        MvcResult mvcResult = mvc.perform(get(uri).contentType(MediaType.APPLICATION_JSON_VALUE)
                                                  .accept(MediaType.APPLICATION_JSON))
                                 .andExpect(status().isOk())
                                 .andReturn();

        String jsonResponse = mvcResult.getResponse().getContentAsString();

        String expectedResponse = "[]";

        // Assert
        assertEquals(expectedResponse, jsonResponse);
    }
}

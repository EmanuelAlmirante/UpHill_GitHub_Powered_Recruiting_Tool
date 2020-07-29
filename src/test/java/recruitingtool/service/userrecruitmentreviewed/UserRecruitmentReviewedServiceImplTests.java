package recruitingtool.service.userrecruitmentreviewed;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import recruitingtool.exception.BusinessException;
import recruitingtool.model.UserRecruitmentReviewedModel;
import recruitingtool.repository.UserRecruitmentReviewedRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class UserRecruitmentReviewedServiceImplTests {
    @Mock
    private UserRecruitmentReviewedRepository userRecruitmentReviewedRepository;

    @InjectMocks
    private UserRecruitmentReviewedServiceImpl userRecruitmentReviewedService;

    @Test
    public void createUserRecruitmentReviewedSuccessfully() {
        // Arrange
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

        // Act
        when(userRecruitmentReviewedRepository.save(userRecruitmentReviewedModelToBeCreated))
                .thenReturn(userRecruitmentReviewedModelToBeCreated);

        UserRecruitmentReviewedModel userRecruitmentReviewedModelCreated =
                userRecruitmentReviewedService
                        .createUserRecruitmentReviewedModel(userRecruitmentReviewedModelToBeCreated);

        // Assert
        assertNotNull(userRecruitmentReviewedModelCreated);
        assertEquals(jobCategory, userRecruitmentReviewedModelCreated.getJobCategory());
        assertEquals(skillLevel, userRecruitmentReviewedModelCreated.getSkillLevel());
        assertEquals(fitForJobScale, userRecruitmentReviewedModelCreated.getFitForJobScale());
        assertEquals(commentary, userRecruitmentReviewedModelCreated.getCommentary());
        assertEquals(name, userRecruitmentReviewedModelCreated.getName());
        assertEquals(company, userRecruitmentReviewedModelCreated.getCompany());
        assertEquals(blog, userRecruitmentReviewedModelCreated.getBlog());
        assertEquals(location, userRecruitmentReviewedModelCreated.getLocation());
        assertEquals(email, userRecruitmentReviewedModelCreated.getEmail());
        assertEquals(bio, userRecruitmentReviewedModelCreated.getBio());
        assertEquals(numberOfFollowers, userRecruitmentReviewedModelCreated.getNumberOfFollowers());
        assertEquals(numberOfFollowing, userRecruitmentReviewedModelCreated.getNumberOfFollowing());
        assertEquals(gitHubUrl, userRecruitmentReviewedModelCreated.getGitHubUrl());
        assertEquals(repos, userRecruitmentReviewedModelCreated.getRepos());
    }

    @Test(expected = BusinessException.class)
    public void createUserRecruitmentReviewedWithInvalidJobCategoryFails() {
        // Arrange
        String jobCategory = "DevpOps";
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

        // Act && Assert
        try {
            userRecruitmentReviewedService.createUserRecruitmentReviewedModel(userRecruitmentReviewedModelToBeCreated);
        } catch (BusinessException be) {
            String exceptionMessage = "Job category is invalid! Must be one of: Frontend, Backend, QA, Data Analyst!";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid job category was not thrown!");
    }

    @Test(expected = BusinessException.class)
    public void createUserRecruitmentReviewedWithInvalidSkillLevelFails() {
        // Arrange
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

        // Act && Assert
        try {
            userRecruitmentReviewedService.createUserRecruitmentReviewedModel(userRecruitmentReviewedModelToBeCreated);
        } catch (BusinessException be) {
            String exceptionMessage = "Skill level is invalid! Must be one of: Junior, Mid-level, Expert!";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid skill level was not thrown!");
    }

    @Test(expected = BusinessException.class)
    public void createUserRecruitmentReviewedWithInvalidFitForJobScaleFails() {
        // Arrange
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

        // Act && Assert
        try {
            userRecruitmentReviewedService.createUserRecruitmentReviewedModel(userRecruitmentReviewedModelToBeCreated);
        } catch (BusinessException be) {
            String exceptionMessage = "Fit for job scale is invalid! Must be between 1 and 5!";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid fit for job scale was not thrown!");
    }

    @Test(expected = BusinessException.class)
    public void createUserRecruitmentReviewedWithInvalidNameFails() {
        // Arrange
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

        // Act && Assert
        try {
            userRecruitmentReviewedService.createUserRecruitmentReviewedModel(userRecruitmentReviewedModelToBeCreated);
        } catch (BusinessException be) {
            String exceptionMessage = "Name is invalid! Must contain a string!";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid name was not thrown!");
    }

    @Test(expected = BusinessException.class)
    public void createUserRecruitmentReviewedWithInvalidNumberOfFollowersFails() {
        // Arrange
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

        // Act && Assert
        try {
            userRecruitmentReviewedService.createUserRecruitmentReviewedModel(userRecruitmentReviewedModelToBeCreated);
        } catch (BusinessException be) {
            String exceptionMessage = "Number of followers is invalid! Must be a positive integer!";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid number of followers was not thrown!");
    }

    @Test(expected = BusinessException.class)
    public void createUserRecruitmentReviewedWithInvalidNumberOfFollowingFails() {
        // Arrange
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

        // Act && Assert
        try {
            userRecruitmentReviewedService.createUserRecruitmentReviewedModel(userRecruitmentReviewedModelToBeCreated);
        } catch (BusinessException be) {
            String exceptionMessage = "Number of following is invalid! Must be a positive integer!";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid number of following was not thrown!");
    }

    @Test(expected = BusinessException.class)
    public void createUserRecruitmentReviewedWithInvalidGitHubUrlFails() {
        // Arrange
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

        // Act && Assert
        try {
            userRecruitmentReviewedService.createUserRecruitmentReviewedModel(userRecruitmentReviewedModelToBeCreated);
        } catch (BusinessException be) {
            String exceptionMessage = "GitHub URL is invalid! Must be a string!";
            assertEquals(exceptionMessage, be.getMessage());
            throw be;
        }

        fail("Business exception of invalid GitHub URL was not thrown!");
    }

    @Test
    public void getAllUserRecruitmentReviewedModelReturnsPopulatedList() {
        // Arrange
        String jobCategoryUserOne = "Backend";
        String skillLevelUserOne = "Junior";
        int fitForJobScaleUserOne = 3;
        String commentaryUserOne = "Nothing to comment upon.";
        String nameUserOne = "Stephane Maarek";
        String companyUserOne = "@datacumulus";
        String blogUserOne = "https://courses.datacumulus.com/";
        String locationUserOne = "Lisbon + moving around the world";
        String emailUserOne = "N.A.";
        String bioUserOne =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowersUserOne = 3130;
        int numberOfFollowingUserOne = 9;
        String gitHubUrlUserOne = "https://github.com/simplesteph";
        List<String> reposUserOne = Arrays.asList("https://github.com/simplesteph/ansible",
                                                  "https://github.com/simplesteph/ansible-modules-core");

        UserRecruitmentReviewedModel userRecruitmentReviewedModelUserOneToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith()
                                                    .withJobCategory(jobCategoryUserOne)
                                                    .withSkillLevel(skillLevelUserOne)
                                                    .withFitForJobScale(fitForJobScaleUserOne)
                                                    .withCommentary(commentaryUserOne).withName(nameUserOne)
                                                    .withCompany(companyUserOne)
                                                    .withBlog(blogUserOne).withLocation(locationUserOne)
                                                    .withEmail(emailUserOne).withBio(bioUserOne)
                                                    .withNumberOfFollowers(numberOfFollowersUserOne)
                                                    .withNumberOfFollowing(numberOfFollowingUserOne)
                                                    .withGitHubUrl(gitHubUrlUserOne)
                                                    .withRepos(reposUserOne).build();

        String jobCategoryUserTwo = "Backend";
        String skillLevelUserTwo = "Junior";
        int fitForJobScaleUserTwo = 3;
        String commentaryUserTwo = "Nothing to comment upon.";
        String nameUserTwo = "Stephane Maarek";
        String companyUserTwo = "@datacumulus";
        String blogUserTwo = "https://courses.datacumulus.com/";
        String locationUserTwo = "Lisbon + moving around the world";
        String emailUserTwo = "N.A.";
        String bioUserTwo =
                "Kafka & AWS evangelist, Udemy instructor, love finding problems that are patiently waiting to be solved.";
        int numberOfFollowersUserTwo = 3130;
        int numberOfFollowingUserTwo = 9;
        String gitHubUrlUserTwo = "https://github.com/simplesteph";
        List<String> reposUserTwo = Arrays.asList("https://github.com/simplesteph/ansible",
                                                  "https://github.com/simplesteph/ansible-modules-core");


        UserRecruitmentReviewedModel userRecruitmentReviewedModelUserTwoToBeCreated =
                UserRecruitmentReviewedModel.Builder.userRecruitmentReviewedModelWith()
                                                    .withJobCategory(jobCategoryUserTwo)
                                                    .withSkillLevel(skillLevelUserTwo)
                                                    .withFitForJobScale(fitForJobScaleUserTwo)
                                                    .withCommentary(commentaryUserTwo).withName(nameUserTwo)
                                                    .withCompany(companyUserTwo)
                                                    .withBlog(blogUserTwo).withLocation(locationUserTwo)
                                                    .withEmail(emailUserTwo).withBio(bioUserTwo)
                                                    .withNumberOfFollowers(numberOfFollowersUserTwo)
                                                    .withNumberOfFollowing(numberOfFollowingUserTwo)
                                                    .withGitHubUrl(gitHubUrlUserTwo)
                                                    .withRepos(reposUserTwo).build();

        List<UserRecruitmentReviewedModel> userRecruitmentReviewedModelList =
                Arrays.asList(userRecruitmentReviewedModelUserOneToBeCreated,
                              userRecruitmentReviewedModelUserTwoToBeCreated);

        // Act
        when(userRecruitmentReviewedRepository.findAll()).thenReturn(userRecruitmentReviewedModelList);

        List<UserRecruitmentReviewedModel> retrievedUserRecruitmentReviewedModelList =
                userRecruitmentReviewedService.getAllUserRecruitmentReviewedModel();

        // Assert
        assertNotNull(retrievedUserRecruitmentReviewedModelList);
        assertEquals(2, retrievedUserRecruitmentReviewedModelList.size());
        assertTrue(retrievedUserRecruitmentReviewedModelList.stream().anyMatch(
                userRecruitmentReviewedModelUserOneToBeCreated::equals));
        assertTrue(retrievedUserRecruitmentReviewedModelList.stream().anyMatch(
                userRecruitmentReviewedModelUserTwoToBeCreated::equals));
    }

    @Test
    public void getAllUserRecruitmentReviewedModelReturnsEmptyList() {
        // Act
        when(userRecruitmentReviewedRepository.findAll()).thenReturn(new ArrayList<>());

        List<UserRecruitmentReviewedModel> retrievedUserRecruitmentReviewedModelList =
                userRecruitmentReviewedService.getAllUserRecruitmentReviewedModel();

        // Assert
        assertNotNull(retrievedUserRecruitmentReviewedModelList);
        assertTrue(retrievedUserRecruitmentReviewedModelList.isEmpty());
    }
}

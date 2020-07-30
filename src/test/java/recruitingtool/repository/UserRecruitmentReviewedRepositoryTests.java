package recruitingtool.repository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit4.SpringRunner;
import recruitingtool.model.UserRecruitmentReviewedModel;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;


@DataJpaTest
@RunWith(SpringRunner.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class UserRecruitmentReviewedRepositoryTests {
    @Autowired
    private UserRecruitmentReviewedRepository userRecruitmentReviewedRepository;

    @Test
    public void saveUserRecruitmentReviewedSuccessfully() {
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
        UserRecruitmentReviewedModel userRecruitmentReviewedModelCreated =
                userRecruitmentReviewedRepository.save(userRecruitmentReviewedModelToBeCreated);

        // Assert
        assertNotNull(userRecruitmentReviewedModelCreated);
        assertFalse(userRecruitmentReviewedModelCreated.getId().toString().isEmpty());
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

    @Test
    public void findAllUserRecruitmentReviewedReturnsPopulatedList() {
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

        userRecruitmentReviewedRepository.save(userRecruitmentReviewedModelUserOneToBeCreated);

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

        userRecruitmentReviewedRepository.save(userRecruitmentReviewedModelUserTwoToBeCreated);

        // Act
        List<UserRecruitmentReviewedModel> retrievedUserRecruitmentReviewedModelList =
                userRecruitmentReviewedRepository.findAll();

        // Assert
        assertNotNull(retrievedUserRecruitmentReviewedModelList);
        assertEquals(2, retrievedUserRecruitmentReviewedModelList.size());
        assertTrue(retrievedUserRecruitmentReviewedModelList.stream().anyMatch(
                userRecruitmentReviewedModelUserOneToBeCreated::equals));
        assertTrue(retrievedUserRecruitmentReviewedModelList.stream().anyMatch(
                userRecruitmentReviewedModelUserTwoToBeCreated::equals));
    }

    @Test
    public void findAllUserRecruitmentReviewedReturnsEmptyList() {
        // Act
        List<UserRecruitmentReviewedModel> retrievedUserRecruitmentReviewedModelList =
                userRecruitmentReviewedRepository.findAll();

        // Assert
        assertNotNull(retrievedUserRecruitmentReviewedModelList);
        assertTrue(retrievedUserRecruitmentReviewedModelList.isEmpty());
    }
}

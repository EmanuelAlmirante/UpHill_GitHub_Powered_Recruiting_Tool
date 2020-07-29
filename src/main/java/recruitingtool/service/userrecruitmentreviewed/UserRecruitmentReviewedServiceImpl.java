package recruitingtool.service.userrecruitmentreviewed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import recruitingtool.exception.BusinessException;
import recruitingtool.model.UserRecruitmentReviewedModel;
import recruitingtool.repository.UserRecruitmentReviewedRepository;

import java.util.List;

@Service
public class UserRecruitmentReviewedServiceImpl implements UserRecruitmentReviewedService {
    private final UserRecruitmentReviewedRepository userRecruitmentReviewedRepository;

    @Autowired
    public UserRecruitmentReviewedServiceImpl(UserRecruitmentReviewedRepository userRecruitmentReviewedRepository) {
        this.userRecruitmentReviewedRepository = userRecruitmentReviewedRepository;
    }

    @Override
    public UserRecruitmentReviewedModel createUserRecruitmentReviewedModel(
            UserRecruitmentReviewedModel userRecruitmentReviewedModel) {
        verifyUserRecruitmentReviewedModelIsValid(userRecruitmentReviewedModel);

        return userRecruitmentReviewedRepository.save(userRecruitmentReviewedModel);
    }

    @Override
    public List<UserRecruitmentReviewedModel> getAllUserRecruitmentReviewedModel() {
        return userRecruitmentReviewedRepository.findAll();
    }

    private void verifyUserRecruitmentReviewedModelIsValid(UserRecruitmentReviewedModel userRecruitmentReviewedModel) {
        verifyJobCategoryIsValid(userRecruitmentReviewedModel);
        verifySkillLevelIsValid(userRecruitmentReviewedModel);
        verifyFitForJobScaleIsValid(userRecruitmentReviewedModel);
        verifyNameIsValid(userRecruitmentReviewedModel);
        verifyNumberOfFollowersIsValid(userRecruitmentReviewedModel);
        verifyNumberOfFollowingIsValid(userRecruitmentReviewedModel);
        verifyGitHubUrlIsValid(userRecruitmentReviewedModel);
    }

    private void verifyJobCategoryIsValid(UserRecruitmentReviewedModel userRecruitmentReviewedModel) {
        String jobCategory = userRecruitmentReviewedModel.getJobCategory();

        if (jobCategory == null || !jobCategory.matches("Frontend|Backend|QA|Data Analyst")) {
            throw new BusinessException(
                    "Job category is invalid! Must be one of: Frontend, Backend, QA, Data Analyst!");
        }
    }

    private void verifySkillLevelIsValid(UserRecruitmentReviewedModel userRecruitmentReviewedModel) {
        String skillLevel = userRecruitmentReviewedModel.getSkillLevel();

        if (skillLevel == null || !skillLevel.matches("Junior|Mid-level|Expert")) {
            throw new BusinessException(
                    "Skill level is invalid! Must be one of: Junior, Mid-level, Expert!");
        }
    }

    private void verifyFitForJobScaleIsValid(UserRecruitmentReviewedModel userRecruitmentReviewedModel) {
        int fitForJobScale = userRecruitmentReviewedModel.getFitForJobScale();

        if (fitForJobScale < 1 || fitForJobScale > 5) {
            throw new BusinessException("Fit for job scale is invalid! Must be between 1 and 5!");
        }
    }

    private void verifyNameIsValid(UserRecruitmentReviewedModel userRecruitmentReviewedModel) {
        String name = userRecruitmentReviewedModel.getName();

        if (name == null || name.isEmpty()) {
            throw new BusinessException("Name is invalid! Must contain a string!");
        }
    }

    private void verifyNumberOfFollowersIsValid(UserRecruitmentReviewedModel userRecruitmentReviewedModel) {
        int numberOfFollowers = userRecruitmentReviewedModel.getNumberOfFollowers();

        if (numberOfFollowers < 0) {
            throw new BusinessException("Number of followers is invalid! Must be a positive integer!");
        }
    }

    private void verifyNumberOfFollowingIsValid(UserRecruitmentReviewedModel userRecruitmentReviewedModel) {
        int numberOfFollowing = userRecruitmentReviewedModel.getNumberOfFollowing();

        if (numberOfFollowing < 0) {
            throw new BusinessException("Number of following is invalid! Must be a positive integer!");
        }
    }

    private void verifyGitHubUrlIsValid(UserRecruitmentReviewedModel userRecruitmentReviewedModel) {
        String gitHubUrl = userRecruitmentReviewedModel.getGitHubUrl();

        if (gitHubUrl == null || gitHubUrl.isEmpty()) {
            throw new BusinessException("GitHub URL is invalid! Must be a string!");
        }
    }
}

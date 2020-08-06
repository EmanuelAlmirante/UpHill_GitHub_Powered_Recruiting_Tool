package recruitingtool.service.userrecruitmentreviewed;

import recruitingtool.model.UserRecruitmentReviewedModel;

import java.util.List;

public interface UserRecruitmentReviewedService {
    UserRecruitmentReviewedModel createUserRecruitmentReviewedModel(
            UserRecruitmentReviewedModel userRecruitmentReviewedModel);

    List<UserRecruitmentReviewedModel> getAllUserRecruitmentReviewedModel();
}

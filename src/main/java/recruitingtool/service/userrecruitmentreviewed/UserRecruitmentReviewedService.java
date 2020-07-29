package recruitingtool.service.userrecruitmentreviewed;

import org.springframework.stereotype.Component;
import recruitingtool.model.UserRecruitmentReviewedModel;

import java.util.List;

@Component
public interface UserRecruitmentReviewedService {
    UserRecruitmentReviewedModel createUserRecruitmentReviewedModel(
            UserRecruitmentReviewedModel userRecruitmentReviewedModel);

    List<UserRecruitmentReviewedModel> getAllUserRecruitmentReviewedModel();
}

package recruitingtool.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import recruitingtool.model.UserRecruitmentReviewedModel;

@Repository
public interface UserRecruitmentReviewedRepository extends JpaRepository<UserRecruitmentReviewedModel, Long> {
}

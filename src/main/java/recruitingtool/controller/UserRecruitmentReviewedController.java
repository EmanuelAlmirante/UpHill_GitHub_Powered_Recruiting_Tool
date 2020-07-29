package recruitingtool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import recruitingtool.controller.utils.AbstractController;
import recruitingtool.model.UserRecruitmentReviewedModel;
import recruitingtool.service.userrecruitmentreviewed.UserRecruitmentReviewedService;

import javax.validation.Valid;

import java.util.List;

import static recruitingtool.controller.utils.RestEndpoint.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/recruiting")
public class UserRecruitmentReviewedController extends AbstractController {
    @Autowired
    private UserRecruitmentReviewedService userRecruitmentReviewedService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserRecruitmentReviewedModel createUserRecruitmentReviewedModel(
            @Valid @RequestBody UserRecruitmentReviewedModel userRecruitmentReviewedModel) {
        return userRecruitmentReviewedService.createUserRecruitmentReviewedModel(userRecruitmentReviewedModel);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserRecruitmentReviewedModel> getAllUserRecruitmentReviewedModel() {
        return userRecruitmentReviewedService.getAllUserRecruitmentReviewedModel();
    }
}

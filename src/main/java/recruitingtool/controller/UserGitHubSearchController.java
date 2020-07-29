package recruitingtool.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import recruitingtool.controller.utils.AbstractController;
import recruitingtool.model.UserGitHubSearchModel;
import recruitingtool.service.usergithubsearch.UserGitHubSearchService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static recruitingtool.controller.utils.RestEndpoint.BASE_URL;

@RestController
@RequestMapping(BASE_URL + "/github-search")
public class UserGitHubSearchController extends AbstractController {
    @Autowired
    private UserGitHubSearchService userGitHubSearchService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<UserGitHubSearchModel> searchGitHubUsersByParameters(@RequestParam(required = false) String location,
                                                                     @RequestParam(required = false)
                                                                             String language,
                                                                     @RequestParam(required = false) String followers) {
        Map<String, String> queryParamsMap = new HashMap<>() {{
            put("location:", location);
            put("language:", language);
            put("followers:>=", followers);
        }};

        return userGitHubSearchService.searchGitHubUsersByParameters(queryParamsMap);
    }
}

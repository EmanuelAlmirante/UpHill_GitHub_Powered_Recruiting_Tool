package recruitingtool.service.usergithubsearch;

import recruitingtool.model.UserGitHubSearchModel;

import java.util.List;
import java.util.Map;

public interface UserGitHubSearchService {
    List<UserGitHubSearchModel> searchGitHubUsersByParameters(Map<String, String> queryParamsMap);
}

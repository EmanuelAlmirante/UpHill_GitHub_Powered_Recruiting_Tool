package recruitingtool.service.usergithubsearch;

import org.springframework.stereotype.Component;
import recruitingtool.model.UserGitHubSearchModel;

import java.util.List;
import java.util.Map;

@Component
public interface UserGitHubSearchService {
    List<UserGitHubSearchModel> searchGitHubUsersByParameters(Map<String, String> queryParamsMap);
}

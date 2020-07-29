package recruitingtool.service.usergithubsearch;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import recruitingtool.exception.BusinessException;
import recruitingtool.model.UserGitHubSearchModel;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import static recruitingtool.service.usergithubsearch.utils.OAuth2Token.OAUTH2_TOKEN;

@Service
public class UserGitHubSearchServiceImpl implements UserGitHubSearchService {
    @Override
    public List<UserGitHubSearchModel> searchGitHubUsersByParameters(Map<String, String> queryParamsMap) {
        if (Collections.frequency(queryParamsMap.values(), null) == queryParamsMap.size()) {
            throw new BusinessException("Query cannot be empty! Please choose a location or language or followers!");
        }

        String apiUrl = apiUrlRequestBuilder(queryParamsMap);
        JsonArray parsedJsonArrayUsersDetails = parseAllUsersDetailsToJsonArray(apiUrl);
        List<JsonObject> extractedGitHubInformationJsonObjects =
                extractUsersGitHubInformation(parsedJsonArrayUsersDetails);
        List<UserGitHubSearchModel> userGitHubSearchModelList =
                userGitHubSearchFinalOutput(extractedGitHubInformationJsonObjects);

        return userGitHubSearchModelList;
    }

    private String apiUrlRequestBuilder(Map<String, String> queryParamsMap) {
        StringBuilder apiUrl = new StringBuilder("https://api.github.com/search/users?q=");

        for (Map.Entry<String, String> entry : queryParamsMap.entrySet()) {
            if (entry.getValue() != null) {
                apiUrl.append(entry.getKey()).append(entry.getValue()).append("+");
            }
        }

        if (apiUrl.toString().charAt(apiUrl.length() - 1) == '+') {
            apiUrl.deleteCharAt(apiUrl.length() - 1);
        }

        return apiUrl.toString();
    }

    private JsonArray parseAllUsersDetailsToJsonArray(String apiUrl) {
        JsonArray jsonArrayUsersDetails;

        JsonObject jsonObject = parseGetRequestToJsonObject(apiUrl);
        jsonArrayUsersDetails = jsonObject.getAsJsonArray("items");

        return jsonArrayUsersDetails;
    }

    private List<JsonObject> extractUsersGitHubInformation(JsonArray parsedJsonArrayUsersDetails) {
        List<JsonObject> jsonObjectsList = new ArrayList<>();

        for (JsonElement jsonElementUserDetails : parsedJsonArrayUsersDetails) {
            JsonObject userElementObject = jsonElementUserDetails.getAsJsonObject();

            String url = userElementObject.get("url").getAsString();

            JsonObject userDetailsJsonObject = parseGetRequestToJsonObject(url);

            jsonObjectsList.add(userDetailsJsonObject);
        }

        return jsonObjectsList;
    }

    private List<UserGitHubSearchModel> userGitHubSearchFinalOutput(List<JsonObject> jsonObjects) {
        List<UserGitHubSearchModel> userGitHubSearchModelList = new ArrayList<>();

        for (JsonObject jsonObject : jsonObjects) {
            String name = jsonObject.get("name").isJsonNull() ? "N.A." : jsonObject.get("name").getAsString();
            String company = jsonObject.get("company").isJsonNull() ? "N.A." : jsonObject.get("company").getAsString();
            String blog = jsonObject.get("blog").isJsonNull() ? "N.A." : jsonObject.get("blog").getAsString();
            String location =
                    jsonObject.get("location").isJsonNull() ? "N.A." : jsonObject.get("location").getAsString();
            String email = jsonObject.get("email").isJsonNull() ? "N.A." : jsonObject.get("email").getAsString();
            String bio = jsonObject.get("bio").isJsonNull() ? "N.A." : jsonObject.get("bio").getAsString();
            int numberOfFollowers = jsonObject.get("followers").getAsInt();
            int numberOfFollowing = jsonObject.get("following").getAsInt();
            String gitHubUrl = jsonObject.get("html_url").getAsString();
            String reposUrl = jsonObject.get("repos_url").getAsString();
            List<String> reposUrlList = extractRepositoriesUrlToList(reposUrl);

            UserGitHubSearchModel userGitHubSearchModel =
                    UserGitHubSearchModel.Builder.userGitHubSearchModelWith().withName(name).withCompany(company)
                                                 .withBlog(blog)
                                                 .withLocation(location).withEmail(email)
                                                 .withBio(bio)
                                                 .withNumberOfFollowers(numberOfFollowers)
                                                 .withNumberOfFollowing(numberOfFollowing)
                                                 .withGitHubUrl(gitHubUrl).withRepos(reposUrlList).build();

            userGitHubSearchModelList.add(userGitHubSearchModel);
        }

        return userGitHubSearchModelList;
    }

    private List<String> extractRepositoriesUrlToList(String reposUrl) {
        List<String> reposUrlList = new ArrayList<>();
        JsonArray reposUrlJsonArray = parseGetRequestToJsonArray(reposUrl);

        for (JsonElement jsonArrayElement : reposUrlJsonArray) {
            JsonObject jsonObject = jsonArrayElement.getAsJsonObject();
            String repoUrl = jsonObject.get("svn_url").getAsString();
            reposUrlList.add(repoUrl);
        }

        return reposUrlList;
    }

    private JsonObject parseGetRequestToJsonObject(String apiUrl) {
        HttpURLConnection connection = null;
        JsonObject jsonObject = null;

        try {
            //Create connection
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", OAUTH2_TOKEN);
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            Gson gson = new Gson();
            jsonObject = gson.fromJson(response.toString(), JsonObject.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return jsonObject;
    }

    private JsonArray parseGetRequestToJsonArray(String apiUrl) {
        HttpURLConnection connection = null;
        JsonArray jsonArray = null;

        try {
            //Create connection
            URL url = new URL(apiUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("Authorization", OAUTH2_TOKEN);
            connection.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }

            in.close();

            Gson gson = new Gson();

            jsonArray = gson.fromJson(response.toString(), JsonArray.class);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }

        return jsonArray;
    }
}

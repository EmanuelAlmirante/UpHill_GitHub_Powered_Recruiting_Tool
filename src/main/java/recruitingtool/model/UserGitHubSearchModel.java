package recruitingtool.model;

import java.util.List;

public class UserGitHubSearchModel {
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String bio;
    private int numberOfFollowers;
    private int numberOfFollowing;
    private String gitHubUrl;
    private List<String> repos;

    public UserGitHubSearchModel() {
    }

    public UserGitHubSearchModel(Builder builder) {
        this.name = builder.name;
        this.company = builder.company;
        this.blog = builder.blog;
        this.location = builder.location;
        this.email = builder.email;
        this.bio = builder.bio;
        this.numberOfFollowers = builder.numberOfFollowers;
        this.numberOfFollowing = builder.numberOfFollowing;
        this.gitHubUrl = builder.gitHubUrl;
        this.repos = builder.repos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getBlog() {
        return blog;
    }

    public void setBlog(String blog) {
        this.blog = blog;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public Integer getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public void setNumberOfFollowers(int numberOfFollowers) {
        this.numberOfFollowers = numberOfFollowers;
    }

    public Integer getNumberOfFollowing() {
        return numberOfFollowing;
    }

    public void setNumberOfFollowing(int numberOfFollowing) {
        this.numberOfFollowing = numberOfFollowing;
    }

    public String getGitHubUrl() {
        return gitHubUrl;
    }

    public void setGitHubUrl(String gitHubUrl) {
        this.gitHubUrl = gitHubUrl;
    }

    public List<String> getRepos() {
        return repos;
    }

    public void setRepos(List<String> repos) {
        this.repos = repos;
    }

    public static class Builder {
        private String name;
        private String company;
        private String blog;
        private String location;
        private String email;
        private String bio;
        private int numberOfFollowers;
        private int numberOfFollowing;
        private String gitHubUrl;
        private List<String> repos;

        public static Builder userGitHubSearchModelWith() {
            return new Builder();
        }

        public Builder withName(String name) {
            this.name = name;

            return this;
        }

        public Builder withCompany(String company) {
            this.company = company;

            return this;
        }

        public Builder withBlog(String blog) {
            this.blog = blog;

            return this;
        }

        public Builder withLocation(String location) {
            this.location = location;

            return this;
        }

        public Builder withEmail(String email) {
            this.email = email;

            return this;
        }

        public Builder withBio(String bio) {
            this.bio = bio;

            return this;
        }

        public Builder withNumberOfFollowers(int numberOfFollowers) {
            this.numberOfFollowers = numberOfFollowers;

            return this;
        }

        public Builder withNumberOfFollowing(int numberOfFollowing) {
            this.numberOfFollowing = numberOfFollowing;

            return this;
        }

        public Builder withGitHubUrl(String gitHubUrl) {
            this.gitHubUrl = gitHubUrl;

            return this;
        }

        public Builder withRepos(List<String> repos) {
            this.repos = repos;

            return this;
        }

        public UserGitHubSearchModel build() {
            return new UserGitHubSearchModel(this);
        }
    }
}

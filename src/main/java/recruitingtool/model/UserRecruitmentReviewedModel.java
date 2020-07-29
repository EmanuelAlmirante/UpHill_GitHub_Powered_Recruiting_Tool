package recruitingtool.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

@Entity
@Table(name = "reviewed_users")
public class UserRecruitmentReviewedModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String jobCategory;
    @NotNull
    private String skillLevel;
    @NotNull
    private int fitForJobScale;
    @NotNull
    private String commentary;
    @NotNull
    private String name;
    private String company;
    private String blog;
    private String location;
    private String email;
    private String bio;
    @NotNull
    private int numberOfFollowers;
    @NotNull
    private int numberOfFollowing;
    @NotNull
    private String gitHubUrl;
    @ElementCollection
    private List<String> repos;

    public UserRecruitmentReviewedModel() {
    }

    public UserRecruitmentReviewedModel(Builder builder) {
        this.jobCategory = builder.jobCategory;
        this.skillLevel = builder.skillLevel;
        this.fitForJobScale = builder.fitForJobScale;
        this.commentary = builder.commentary;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobCategory() {
        return jobCategory;
    }

    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    public String getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(String skillLevel) {
        this.skillLevel = skillLevel;
    }

    public int getFitForJobScale() {
        return fitForJobScale;
    }

    public void setFitForJobScale(int fitForJobScale) {
        this.fitForJobScale = fitForJobScale;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
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

    public int getNumberOfFollowers() {
        return numberOfFollowers;
    }

    public void setNumberOfFollowers(int numberOfFollowers) {
        this.numberOfFollowers = numberOfFollowers;
    }

    public int getNumberOfFollowing() {
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
        private String jobCategory;
        private String skillLevel;
        private int fitForJobScale;
        private String commentary;
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

        public static Builder userRecruitmentReviewedModelWith() {
            return new Builder();
        }

        public Builder withJobCategory(String jobCategory) {
            this.jobCategory = jobCategory;

            return this;
        }

        public Builder withSkillLevel(String skillLevel) {
            this.skillLevel = skillLevel;

            return this;
        }

        public Builder withFitForJobScale(int fitForJobScale) {
            this.fitForJobScale = fitForJobScale;

            return this;
        }

        public Builder withCommentary(String commentary) {
            this.commentary = commentary;

            return this;
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

        public UserRecruitmentReviewedModel build() {
            return new UserRecruitmentReviewedModel(this);
        }
    }
}

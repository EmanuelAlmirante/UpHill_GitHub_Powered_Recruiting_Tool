package recruitingtool.model;

import javax.persistence.*;

@Entity
@Table(name = "admins")
public class AdminModel {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String token;

    public AdminModel() {
    }

    public AdminModel(Builder builder) {
        this.userName = builder.userName;
        this.password = builder.password;
        this.token = builder.token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public static class Builder {
        private String userName;
        private String password;
        private String token;

        public static Builder adminModelWith() {
            return new Builder();
        }

        public Builder withUsername(String userName) {
            this.userName = userName;

            return this;
        }

        public Builder withPassword(String password) {
            this.password = password;

            return this;
        }

        public Builder withToken(String token) {
            this.token = token;

            return this;
        }

        public AdminModel build() {
            return new AdminModel(this);
        }
    }
}

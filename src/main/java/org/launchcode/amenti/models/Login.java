package org.launchcode.amenti.models;


import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Login {

    @NotNull
    private String username;

    @Size(min=6, max=10, message="Password not in range")
    private String password;

    public Login(@NotNull  String username, @Size(min = 6, max = 10, message = "Password not in range") String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String email) {
        this.username = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

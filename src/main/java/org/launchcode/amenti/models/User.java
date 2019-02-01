package org.launchcode.amenti.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class User {
        @NotNull
        private String username;

        @NotNull
        @Email
        private String email;

        @Size(min=6, max=10, message="Password not in range")
        private String password;

        public User(String username, String email, String password) {

        }


        public User() {

        }



        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

package org.launchcode.amenti.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {


        //for every 1 user there are many supplements
        @OneToMany
        @JoinColumn(name = "user_id")
        private List<Supplement> supplements = new ArrayList<>();

        @Id
        @GeneratedValue
        private int id;

        @NotNull
        private String username;

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

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

    public int getId() {
        return id;
    }

    public List<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<Supplement> supplements) {
        this.supplements = supplements;
    }
}


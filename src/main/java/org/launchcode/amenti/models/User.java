package org.launchcode.amenti.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class User {


        //for every 1 user there are many supplements
        @OneToMany(mappedBy = "user")
        private List<Supplement> supplements = new ArrayList<Supplement>();



        @Id
        @GeneratedValue
        private int id;

        @NotNull
        @Size(min=3, max=15, message="Username does not meet minimum requirements")
        private String username;

        @Size(min=6, max=10, message="Password not in range")
        private String password;


        public User(String username, String password) {

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

    public void setId(int id) {
        this.id = id;
    }

    public List<Supplement> getSupplements() {
        return supplements;
    }

    public void setSupplements(List<Supplement> supplements) {
        this.supplements = supplements;
    }
}


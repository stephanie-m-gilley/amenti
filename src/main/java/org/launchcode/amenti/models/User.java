package org.launchcode.amenti.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class User {

        //@ManyToOne
        //private SupplementModel supplements;

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

    //public SupplementModel getSupplements() {
      //  return supplements;
    //}

    //public void setSupplements(SupplementModel supplements) {
      //  this.supplements = supplements;
    //}
}


package org.launchcode.amenti.models;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Supplements {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=20)
    private String name;

    @NotNull
    @Size(min=1, message = "Description can not be left empty")
    private String description;

    public Supplements(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

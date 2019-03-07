package org.launchcode.amenti.models;


import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Supplement {


    //@NotNull
    //@Range(min=1, max=5)
    //private int rating;


    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=2, max=35)
    private String brand;

    @NotNull
    @Size(min=3, max=40)
    private String name;

    @NotNull
    @Size(min=1, message = "Description can not be left empty")
    private String description;

    private SupplementsType type;

    @ManyToOne
    private User user;

    //@ManyToMany(mappedBy = "supplements")
    //private List<SupplementsType> supplementsType;



    public Supplement(String name, String description) {
        this.name = name;
        this.description = description;
    }



    public Supplement() { }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
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

    public SupplementsType getType() {
        return type;
    }

    public void setType(SupplementsType type) {
        this.type = type;
    }

    //public int getRating() {
      //  return rating;
    //}

    //public void setRating(int rating) {
      //  this.rating = rating;
    //}
}

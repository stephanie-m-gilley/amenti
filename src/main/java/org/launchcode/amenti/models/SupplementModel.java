package org.launchcode.amenti.models;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class SupplementModel {

    @Id
    @GeneratedValue
    private int id;

    @NotNull
    @Size(min=3, max=20)
    private String name;

    @NotNull
    @Size(min=1, message = "Description can not be left empty")
    private String description;

    private SupplementsType type;

    private int supId;
    private static int nextId = 1;

    public SupplementModel(String name, String description) {
        this();
        this.name = name;
        this.description = description;
    }



    public SupplementModel() {
        supId = nextId;
        nextId++;
    }


    public int getSupId() {
        return supId;
    }

    public void setSupId(int supId) {
        this.supId = supId;
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
}

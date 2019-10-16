package com.example.demo;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Set;

/*
Create SpringBoot application for People and Pets. Each Pet can have only one owner and each person can own multiple pets. This makes the relationship between people and pets one to many. So look at the example for one to many in the SpringBoot guides and follow that. The Person class should contain a set or ArrayList of Pets. The Pet class should contain a Person (remember Composition?).

As you work think how you can simply the process (create a checklist?) for creating a new application. This will make it easier on your Friday project.
 */
@Entity
public class People {
    @Id
@GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @NotNull
    @Size(min = 4)
    private String name;
    @NotNull
    private int numberOfPetsOwned;

    @NotNull
    @Size(min = 5, max = 100)
    private String description;

    @OneToMany(mappedBy = "people", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    public Set<Pet>pets;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberOfPetsOwned() {
        return numberOfPetsOwned;
    }

    public void setNumberOfPetsOwned(int numberOfPetsOwned) {
        this.numberOfPetsOwned = numberOfPetsOwned;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Pet> getPets() {
        return pets;
    }

    public void setPets(Set<Pet> pets) {
        this.pets = pets;
    }
}

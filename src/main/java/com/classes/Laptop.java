package com.classes;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Laptop {
    @Id
    private int laptop_id;
    @ManyToOne
    private Stud stud; //one laptop can at a time belong to one student only
    private String laptop_name;

    public Stud getStud() {
        return stud;
    }

    public void setStud(Stud stud) {
        this.stud = stud;
    }

    public int getLaptop_id() {
        return laptop_id;
    }

    public void setLaptop_id(int laptop_id) {
        this.laptop_id = laptop_id;
    }
    public String getLaptop_name() {
        return laptop_name;
    }

    public void setLaptop_name(String laptop_name) {
        this.laptop_name = laptop_name;
    }
}

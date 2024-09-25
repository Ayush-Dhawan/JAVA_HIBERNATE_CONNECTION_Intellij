package com.classes;

//import jakarta.persistence.Entity;
//import jakarta.persistence.Id;
//import jakarta.persistence.OneToMany;
//import jakarta.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import java.util.*;
import javax.persistence.*;

@Entity
@Table(name="studs")
@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Stud {
    @Id
    private int roll_no;
    private String name;
    private int marks;
    @OneToMany(mappedBy = "stud")
    private List<Laptop> laptops = new ArrayList<>(); // one student can own multiple laptops here

    public int getRoll_no() {
        return roll_no;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Laptop> getLaptops() {
        return laptops;
    }

    public void setLaptops(List<Laptop> laptops) {
        this.laptops = laptops;
    }

    public void setRoll_no(int roll_no) {
        this.roll_no = roll_no;
    }
}

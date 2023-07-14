package com.paul.springboot.developer;

import jakarta.persistence.*;

@Entity
@Table
public class Developer {

    @Id
    @SequenceGenerator(
            name = "developer_sequence",
            sequenceName = "developer_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "developer_sequence"
    )
    private Long id;
    private String name, email;
    private Integer age;
    private String skill;

    public Developer() {
    }

    public Developer(Long id, String name, String email, Integer age, String skill) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
        this.skill = skill;
    }

    public Developer(String name, String email, Integer age, String skill) {
        this.name = name;
        this.email = email;
        this.age = age;
        this.skill = skill;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSkill() {
        return skill;
    }

    public void setSkill(String skill) {
        this.skill = skill;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", skill='" + skill + '\'' +
                '}';
    }
}

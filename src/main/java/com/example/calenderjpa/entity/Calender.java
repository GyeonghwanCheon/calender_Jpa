package com.example.calenderjpa.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "calender")
public class Calender extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;


    public Calender(String username, String contents, String title) {
        this.username = username;
        this.contents = contents;
        this.title = title;
    }

    public Calender() {

    }
}

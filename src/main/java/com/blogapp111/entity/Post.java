package com.blogapp111.entity;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "posts")
public class Post {
    @Id
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "title",unique = true)
    private String title;

    private String description;

    private String content;
    @OneToMany(mappedBy = "post",orphanRemoval = true,cascade = CascadeType.ALL)
    private List<Comment> comments=new ArrayList<>();

}
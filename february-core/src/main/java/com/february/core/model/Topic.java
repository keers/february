package com.february.core.model;

import org.omg.CORBA.PRIVATE_MEMBER;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: sergeikirsanov
 * Date: 2/26/12
 * Time: 8:19 PM
 * To change this template use File | Settings | File Templates.
 */


@Entity
@Table(name = "TOPICS")
public class Topic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NAME")
    private String name;

    @OneToMany(mappedBy = "topic", targetEntity = Post.class,
            fetch = FetchType.EAGER)
    private Collection<Post> posts;


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

    public Collection<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}

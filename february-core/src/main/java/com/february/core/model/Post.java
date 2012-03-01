package com.february.core.model;

import javax.persistence.*;

/**
 * Created by IntelliJ IDEA.
 * User: sergeikirsanov
 * Date: 2/26/12
 * Time: 8:59 PM
 * To change this template use File | Settings | File Templates.
 */

@Entity
@Table(name = "POSTS")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Long id;

    @Column(name = "TEXT")
    private String text;

    @OneToOne(optional = false)
    @JoinColumn(name = "TOPIC_ID")
    private Topic topic;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Topic getTopic() {
        return topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }
}

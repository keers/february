package com.february.core;

import com.february.core.model.Post;
import com.february.core.model.Topic;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * Created by IntelliJ IDEA.
 * User: sergeikirsanov
 * Date: 2/26/12
 * Time: 9:02 PM
 * To change this template use File | Settings | File Templates.
 */

@Stateless
public class AddTopicBean implements AddTopic {

    @Override
    public void createTopic() {
        Topic topic = new Topic();
        topic.setName("Some new topic");

        Post post1 = new Post();
        post1.setText("Some text 1");
        post1.setTopic(topic);

        Post post2 = new Post();
        post2.setText("Some text 2");
        post2.setTopic(topic);

        EntityManagerFactory factory = null;
        EntityManager manager = null;


        try {
            factory = Persistence.createEntityManagerFactory("february");
            manager = factory.createEntityManager();

            manager.getTransaction().begin();
            manager.persist(post1);
            manager.persist(post2);
            manager.persist(topic);

            manager.getTransaction().commit();


        } finally {
            if (manager != null) {
                manager.close();
            }
            if (factory != null) {
                factory.close();
            }
        }
    }
}

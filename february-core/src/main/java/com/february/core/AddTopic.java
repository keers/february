package com.february.core;

import com.february.core.model.Topic;

import javax.ejb.Remote;

/**
 * Created by IntelliJ IDEA.
 * User: sergeikirsanov
 * Date: 2/26/12
 * Time: 9:00 PM
 * To change this template use File | Settings | File Templates.
 */

@Remote
public interface AddTopic {

    public void createTopic();

}

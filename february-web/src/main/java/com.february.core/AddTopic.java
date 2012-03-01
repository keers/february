package com.february.core;

import javax.ejb.Remote;

@Remote
public interface AddTopic {

    public void createTopic();

}

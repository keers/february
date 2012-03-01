<%@ page import="com.february.core.AddTopic" %>
<%@ page import="javax.ejb.EJB" %>

<%!

    @EJB
    private AddTopic addTopic;

%>

<%


out.print("Hello!");


                               try {
        addTopic.createTopic();
        } catch (Exception e) {
                            out.print(e);
        }

%>

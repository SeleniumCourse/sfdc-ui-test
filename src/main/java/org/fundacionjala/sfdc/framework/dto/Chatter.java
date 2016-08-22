package org.fundacionjala.sfdc.framework.dto;

/**
 * @author Veronica Prado
 * @since 9/5/2015.
 */
public class Chatter {

    private String post;

    private String comment;

    public String getComment() {
        return comment;
    }

    public String getPost() {
        return post;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setPost(String post) {
        this.post = post;
    }
}

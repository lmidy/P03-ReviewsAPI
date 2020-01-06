package com.udacity.course3.reviews.models;

import com.udacity.course3.reviews.entity.Comment;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class CommentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String comment;

    public CommentModel() {
    }

    public CommentModel(Comment comment){
        this.id = comment.getId();
        this.comment = comment.getComment();
    }

    public int getId() {
        return id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }


}

package com.udacity.course3.reviews.model;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "reviews")
public class ReviewDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String reviewTitle;

    private Product product;

    private List<CommentDocument> commentDocuments;

    public ReviewDocument() {
        commentDocuments = new ArrayList<>();
    }
    public ReviewDocument(Review review){
        this.id = review.getId();
        this.reviewTitle = review.getReviewTitle();
        this.product = review.getProduct();
        this.commentDocuments = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getReviewTitle() {
        return reviewTitle;
    }

    public void setReviewTitle(String reviewTitle) {
        this.reviewTitle = reviewTitle;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<CommentDocument> getCommentDocuments() {
        return commentDocuments;
    }

    public void addCommentDocument(CommentDocument commentDocument) {
        commentDocuments.add(commentDocument);
    }
}

package com.udacity.course3.reviews.models;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.ArrayList;
import java.util.List;

@Document(collection = "reviews")
public class ReviewModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String reviewTitle;

    private Product product;

    private List<CommentModel> commentModels;

    public ReviewModel() {
        commentModels= new ArrayList<>();
    }
    public ReviewModel(Review review){
        this.id = review.getId();
        this.reviewTitle = review.getReviewTitle();
        this.product = review.getProduct();
        this.commentModels = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

  /*  public void setId(Integer id) {
        this.id = id;
    }*/

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

    public List<CommentModel> getCommentModels() {
        return commentModels;
    }

    public void addCommentModels(CommentModel commentModel) {
        commentModels.add(commentModel);
    }
}

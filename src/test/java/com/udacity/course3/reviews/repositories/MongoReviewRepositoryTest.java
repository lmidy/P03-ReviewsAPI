package com.udacity.course3.reviews.repositories;

import com.udacity.course3.reviews.entity.Comment;
import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.model.CommentDocument;
import com.udacity.course3.reviews.model.ReviewDocument;
import com.udacity.course3.reviews.repository.MongoReviewRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@DataMongoTest
public class MongoReviewRepositoryTest {


    @Autowired
    private MongoReviewRepository mongoReviewRepository;

    @Test
    public void testMongoReviewFindAll() {

        Product product = new Product();
        product.setProductName("Apple Mouse");

        Review review = new Review();
        review.setReviewTitle("Apple Mouse review");
        review.setProduct(product);

        Comment comment = new Comment();
        comment.setComment("Great battery use, easy on hands");
        comment.setReview(review);

        ReviewDocument reviewModel = new ReviewDocument(review);
        reviewModel.addCommentDocument(new CommentDocument(comment));

        ReviewDocument savedReviewInfo = mongoReviewRepository.save(reviewModel);
        assertEquals(reviewModel.getReviewTitle(), savedReviewInfo.getReviewTitle());
        assertEquals(reviewModel.getProduct(), savedReviewInfo.getProduct());
        assertEquals(reviewModel.getCommentDocuments(), savedReviewInfo.getCommentDocuments());

         List<ReviewDocument> reviews = mongoReviewRepository.findAll();
        assertNotNull(reviews);
        ReviewDocument retrievedReviewDoc = reviews.get(0);
        assertEquals(reviewModel.getId(), retrievedReviewDoc.getId());
        assertEquals(reviewModel.getReviewTitle(), retrievedReviewDoc.getReviewTitle());
    }
}

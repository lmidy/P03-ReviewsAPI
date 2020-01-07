package com.udacity.course3.reviews.controller;

import com.udacity.course3.reviews.entity.Product;
import com.udacity.course3.reviews.entity.Review;
import com.udacity.course3.reviews.model.ReviewDocument;
import com.udacity.course3.reviews.repository.MongoReviewRepository;
import com.udacity.course3.reviews.repository.ProductRepository;
import com.udacity.course3.reviews.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/**
 * Spring REST controller for working with review entity.
 */
@RestController
public class ReviewsController {

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MongoReviewRepository mongoReviewRepository;

    /**
     * Creates a review for a product.
     * <p>
     * 1. Add argument for review entity. Use {@link RequestBody} annotation.
     * 2. Check for existence of product.
     * 3. If product not found, return NOT_FOUND.
     * 4. If found, save review.
     *
     * @param productId The id of the product.
     * @return The created review or 404 if product id is not found.
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.POST)
    public ResponseEntity<Review> createReviewForProduct(@PathVariable("productId") Integer productId, @RequestBody Review review) {
    Optional<Product> optionalProduct = productRepository.findById(productId);

    if(!optionalProduct.isPresent())
        return ResponseEntity.notFound().build();
    //this saves review for passed product id to mysql
    review.setProduct(optionalProduct.get());
    reviewRepository.save(review);
    //this saves review to mongodb for that review
    ReviewDocument reviewDocument = new ReviewDocument(review);
    mongoReviewRepository.save(reviewDocument);

    return ResponseEntity.ok().build();
    }

    /**
     * Lists reviews by product from MongoDB
     *
     * @param productId The id of the product.
     * @return The list of reviews from MONGODB
     */
    @RequestMapping(value = "/reviews/products/{productId}", method = RequestMethod.GET)
    public ResponseEntity<List<?>> listReviewsForProduct(@PathVariable("productId") Integer productId) {
        Optional<Product> optionalProduct = productRepository.findById(productId);

        if (!optionalProduct.isPresent())
            return ResponseEntity.notFound().build();
       //this reads from productid from mysql and the actual reviews from mongodb
        List<Integer> reviewIds = reviewRepository.findIdByProductId(productId);
        List<ReviewDocument> reviews = (List<ReviewDocument>) mongoReviewRepository.findAllById(reviewIds);
        return ResponseEntity.ok(reviews);
    }
}
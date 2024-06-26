package com.pat.DAO;

import java.util.List;

import com.pat.modren.reviews;

public interface reviewsDAO {
	void save(reviews review);
    reviews getReviewById(int reviewid);
    List<reviews> getAllReviews();
    void update(reviews review);
    void delete(int reviewid);
    List<reviews> getReviewsByEventId(int eventid);

}

package dev.pranav.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ServiceReview {
    @Autowired
    private RepositoryReview repositoryReview;
    @Autowired
    private MongoTemplate mongoTemplate;
    public Reviews create(String body, String appId){
        Reviews reviews = repositoryReview.insert(new Reviews(body));
        mongoTemplate.update(games.class).matching(Criteria.where("appId").is(appId)).apply(
                new Update().push("reviewIds").value(reviews)
        ).first();

        return reviews;
    }
}

package dev.pranav.movies;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GameRepository extends MongoRepository<games, ObjectId> {
    Optional<games> findGamesByAppId(Integer appId);
}

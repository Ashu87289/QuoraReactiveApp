package com.example.QuoraReactiveApp.repositories;

import com.example.QuoraReactiveApp.models.Like;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseStatus;

@Repository
public interface LikeRepository extends ReactiveMongoRepository<Like,String> {

}

package com.example.QuoraReactiveApp.repositories;

import com.example.QuoraReactiveApp.models.Question;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;
import java.util.List;


@Repository
public interface QuestionRepository extends ReactiveMongoRepository<Question, String> {


    @Query("{'$or': [{'title': {$regex : ?0,$options : 'i'}},{'content':{$regex : ?0,$options : 'i'} } ] }")
    Flux<Question> findByTitleContainingIgnoreCaseOrContentContainingIgnoreCase(
            String title, Pageable pageable);

    Flux<Question> findByTagsContainingIgnoreCase(String tags, Pageable pageable);

    /*Flux<Question> findByCreatedAtGreaterThanOrderByCreatedAtAsc(String tag,LocalDateTime cursor, Pageable pageable);

    Flux<Question> findTop10ByOrderByCreatedAtAsc(String tags);*/

    @Query(value = "{ 'tags': ?0 }", sort = "{ 'createdAt': 1 }")
    Flux<Question> findFirstBatchByTag(String tag);

    @Query(value = "{ 'tags': ?0, 'createdAt': { '$gt': ?1 } }", sort = "{ 'createdAt': 1 }")
    Flux<Question> findNextBatchByTag(String tag, LocalDateTime cursor);

    @Query(value = "{}", sort = "{ 'createdAt': -1 }")
    Flux<Question> findRecentQuestions();

    @Query(value = "{ 'createdAt': { '$lt': ?0 } }", sort = "{ 'createdAt': -1 }")
    Flux<Question> findRecentQuestionsBefore(LocalDateTime cursor);

    @Query(value = "{ 'tags': { '$in': ?0 } }", sort = "{ 'createdAt': -1 }")
    Flux<Question> findRecentQuestionsByTags(List<String> tags);

    @Query(value = "{ 'tags': { '$in': ?0 }, 'createdAt': { '$lt': ?1 } }", sort = "{ 'createdAt': -1 }")
    Flux<Question> findRecentQuestionsByTagsBefore(List<String> tags, LocalDateTime cursor);


    /*Flux represents a stream that emit multiple items.
     * Get List of records
     * Event Streaming (Kafka, web socket)
     * Logs , Notification
     * Continous data stream
     * Work like a producer
     *
     * Flux is Async or non-blocking
     * Execution happen by event loop/schedulers
     * No thread is blocked waiting for data. */
    //Flux<Question> findByAuthorId(String authorId);

    /*Mono represents a stream that emits at most one item.
    Get Single record from db
    Http request returning one request
    Authentication result
    Save operation result.
    * */
    //Mono<Long> countByAuthorId(String authorId);


}

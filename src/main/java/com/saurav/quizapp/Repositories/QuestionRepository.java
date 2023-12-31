package com.saurav.quizapp.Repositories;

import com.saurav.quizapp.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question,Integer> {

    List<Question> getByCategory(String category);


    @Query(value = "SELECT * FROM question q WHERE q.category = :category ORDER BY RANDOM() LIMIT :numberOfQuestions" ,
            nativeQuery = true)
    List<Question> findRandomQuestionsByCategory(String category,int numberOfQuestions);
}

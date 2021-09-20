package com.example.news.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.news.model.News;

import java.util.Optional;

public interface NewsRepo extends JpaRepository<News, Long> {

    Optional<News> findNewsById(Long id);

    void deleteNewsById(Long id);
}

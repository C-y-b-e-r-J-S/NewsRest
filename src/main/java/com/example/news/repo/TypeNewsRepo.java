package com.example.news.repo;
import com.example.news.model.TypeNews;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TypeNewsRepo extends JpaRepository<TypeNews, Long> {

    Optional<TypeNews> findTypeNewsById(Long id);

    void deleteTypeNewsById(Long id);
}

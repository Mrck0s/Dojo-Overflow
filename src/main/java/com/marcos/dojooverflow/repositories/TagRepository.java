package com.marcos.dojooverflow.repositories;

import com.marcos.dojooverflow.models.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long>{
    Optional<Tag> findBySubjectText(String subjectText);
}

package com.marcos.dojooverflow.repositories;

import com.marcos.dojooverflow.models.Tag;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TagRepository extends CrudRepository {
    List<Tag> findBySubjectText(String subjectText);
}

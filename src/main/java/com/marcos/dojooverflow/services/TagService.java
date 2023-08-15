package com.marcos.dojooverflow.services;

import com.marcos.dojooverflow.models.Tag;
import com.marcos.dojooverflow.repositories.TagRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TagService {
    private final TagRepository tagRepository;

    public TagService(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    public List<Tag> getAllTags() {
        return (List<Tag>) tagRepository.findAll();
    }

    public Tag createTag(Tag tag) {
        return (Tag) tagRepository.save(tag);
    }

}


package com.java.firstspring.service.posts;

import com.java.firstspring.domain.posts.PostRepository;
import com.java.firstspring.domain.posts.Posts;
import com.java.firstspring.web.dto.PostResponseDto;
import com.java.firstspring.web.dto.PostSaveRequestDto;
import com.java.firstspring.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Service

public class PostService {

    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto requestDto) {
        return postRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, PostUpdateRequestDto requestDto) {
        Posts posts = postRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        posts.update(requestDto.getTitle(), requestDto.getContent());

        return  id;
    }

    public PostResponseDto findById (Long id) {
        Posts entity = postRepository.findById(id).orElseThrow( () -> new IllegalArgumentException("해당 게시글이 없습니다. id=" + id));

        return new PostResponseDto(entity);
    }
}

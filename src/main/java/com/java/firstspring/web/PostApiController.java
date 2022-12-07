package com.java.firstspring.web;

import com.java.firstspring.service.posts.PostService;
import com.java.firstspring.web.dto.PostResponseDto;
import com.java.firstspring.web.dto.PostSaveRequestDto;
import com.java.firstspring.web.dto.PostUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController

public class PostApiController {

    private final PostService postService;

    @PostMapping("/api/v1/posts")

    public Long save(@RequestBody PostSaveRequestDto requestDto){
        return postService.save(requestDto);
    }


    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostUpdateRequestDto requestDto) {
        return postService.update(id,requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostResponseDto findById (@PathVariable Long id) {
        return postService.findById(id);
    }

}

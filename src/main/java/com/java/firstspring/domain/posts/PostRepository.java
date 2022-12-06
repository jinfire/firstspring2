package com.java.firstspring.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;

//<entity class type, pk type>
public interface PostRepository extends JpaRepository<Posts,Long> {
}

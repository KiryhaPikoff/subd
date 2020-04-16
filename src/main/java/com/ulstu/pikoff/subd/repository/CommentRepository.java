package com.ulstu.pikoff.subd.repository;

import com.ulstu.pikoff.subd.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Integer> {
}
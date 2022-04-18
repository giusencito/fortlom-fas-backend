package com.example.fortlomfas.backend.services.commentservice.domain.service;
import com.example.fortlomfas.backend.services.commentservice.domain.model.entity.ForumComment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;


import java.util.List;
public interface ForumCommentService {
    List<ForumComment> getAll();
    Page<ForumComment> getAll(Pageable pageable);
    ForumComment getById(Long forumcommentId);
    ForumComment create(Long userId, Long forumId, ForumComment forumcomment);
    List<ForumComment> getForumCommentByForumId(Long forumId);
    ResponseEntity<?> delete(Long forumcommentId);
}

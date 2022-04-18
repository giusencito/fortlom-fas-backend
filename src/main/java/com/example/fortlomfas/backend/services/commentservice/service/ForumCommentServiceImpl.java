package com.example.fortlomfas.backend.services.commentservice.service;
import com.example.fortlomfas.backend.services.commentservice.domain.model.entity.ForumComment;
import com.example.fortlomfas.backend.services.commentservice.domain.persistence.ForumCommentRepository;
import com.example.fortlomfas.backend.services.commentservice.domain.service.ForumCommentService;
import com.example.fortlomfas.backend.services.forumservice.domain.persistence.ForumRepository;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Person;
import com.example.fortlomfas.backend.services.userservice.domain.persistence.PersonRepository;
import com.example.fortlomfas.shared.execption.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import javax.validation.Validator;
import java.util.Date;
import java.util.List;

@Service
public class ForumCommentServiceImpl implements ForumCommentService {


    private static final String ENTITY = "ForumComment";

    @Autowired
    private ForumCommentRepository forumcommentRepository;
    @Autowired
    private PersonRepository userRepository;
    @Autowired
    private ForumRepository forumRepository;


    @Override
    public List<ForumComment> getAll() {
        return forumcommentRepository.findAll();
    }

    @Override
    public Page<ForumComment> getAll(Pageable pageable) {
        return forumcommentRepository.findAll(pageable);
    }

    @Override
    public ForumComment getById(Long forumcommentId) {
        return forumcommentRepository.findById(forumcommentId)
                .orElseThrow(() -> new ResourceNotFoundException(ENTITY, forumcommentId));
    }

    @Override
    public ForumComment create(Long userId, Long forumId, ForumComment request) {
        Date date = new Date();
        Person user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("Person", userId));
        return forumRepository.findById(forumId)
                .map(forums -> {
                    request.setForum(forums);
                    request.setPerson(user);
                    request.setRegisterdate(date);
                    return forumcommentRepository.save(request);
                })
                .orElseThrow(() -> new ResourceNotFoundException("Forum", forumId));
    }


    @Override
    public List<ForumComment> getForumCommentByForumId(Long forumId) {
        return forumcommentRepository.findByForumId(forumId);
    }

    @Override
    public ResponseEntity<?> delete(Long forumcommentId) {
        return forumcommentRepository.findById(forumcommentId).map(forumComment -> {
            forumcommentRepository.delete(forumComment);
            return ResponseEntity.ok().build();
        }).orElseThrow(() -> new ResourceNotFoundException(ENTITY, forumcommentId));
    }
}

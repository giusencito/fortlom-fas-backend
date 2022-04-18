package com.example.fortlomfas.backend.services.forumservice.api;
import com.example.fortlomfas.backend.services.forumservice.domain.model.entity.Forum;
import com.example.fortlomfas.backend.services.forumservice.domain.service.ForumService;
import com.example.fortlomfas.backend.services.forumservice.mapping.ForumMapper;
import com.example.fortlomfas.backend.services.forumservice.resource.CreateForumResource;
import com.example.fortlomfas.backend.services.forumservice.resource.ForumResource;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/v1")
public class ForumController {
    @Autowired
    private ForumService forumService;

    @Autowired
    private ForumMapper mapper;

    @Autowired
    private ModelMapper mapping;

    @GetMapping("/forums")
    public Page<ForumResource> getAllForums(Pageable pageable) {
        return mapper.modelListToPage(forumService.getAllForums(), pageable);
    }
    @GetMapping("/forums/{forumId}")
    public ForumResource getForumById(@PathVariable Long forumId) {
        return mapper.toResource(forumService.getForumById(forumId));
    }
    @GetMapping("/user/{usersId}/forums")
    public Page<ForumResource> getAllForumsByusersId(@PathVariable Long usersId,Pageable pageable) {
        return mapper.modelListToPage(forumService.getForumsByUserId(usersId), pageable);
    }
    @PostMapping("/user/{usersId}/forums")
    public ForumResource createForum(@PathVariable Long usersId,@RequestBody CreateForumResource request) {
        Forum forum = mapping.map(request, Forum.class);
        return mapping.map(forumService.createForum(usersId, forum), ForumResource.class);
    }

    @DeleteMapping("/forums/{forumId}")
    public ResponseEntity<?> deleteForum(@PathVariable Long forumId) {
        return forumService.deleteForum(forumId);
    }
}

package com.example.fortlomfas.backend.services.commentservice.mapping;
import com.example.fortlomfas.backend.services.commentservice.domain.model.entity.ForumComment;
import com.example.fortlomfas.backend.services.commentservice.reosource.ForumComment.CreateForumCommentResource;
import com.example.fortlomfas.backend.services.commentservice.reosource.ForumComment.ForumCommentResource;
import com.example.fortlomfas.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import java.io.Serializable;
import java.util.List;
public class ForumCommentMapper implements Serializable{
    @Autowired
    EnhancedModelMapper mapper;

    public ForumCommentResource toResource(ForumComment model) {
        return mapper.map(model, ForumCommentResource.class);
    }

    public Page<ForumCommentResource> modelListToPage(List<ForumComment> modelList, Pageable pageable) {
        return new PageImpl<>(mapper.mapList(modelList, ForumCommentResource.class), pageable, modelList.size());
    }
    public ForumComment toModel(CreateForumCommentResource resource) {
        return mapper.map(resource, ForumComment.class);
    }
}

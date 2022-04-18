package com.example.fortlomfas.backend.services.publicationservice.domain.service;
import com.example.fortlomfas.backend.services.publicationservice.domain.model.entity.Multimedia;
import com.example.fortlomfas.backend.util.Image.ImageModel;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
public interface MultimediaService {

    List<Multimedia> getAll();
    Page<Multimedia> getAll(Pageable pageable);
    Multimedia getById(Long multimediaId);
    ImageModel getImageDetails(Long MultimediaID);
    ResponseEntity<byte[]> getImage(Long MultimediaID);
    void create(Long multimediaId, MultipartFile file) throws IOException;
    ResponseEntity<ByteArrayResource>download(Long filenameId);
    Multimedia update(Long multimediaId, Multimedia request);
    List<ImageModel> getMultimediaByPublicationId(Long multimediaId);
    ResponseEntity<?> delete(Long commentId);
}

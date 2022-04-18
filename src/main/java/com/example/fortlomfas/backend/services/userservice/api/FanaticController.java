package com.example.fortlomfas.backend.services.userservice.api;
import com.example.fortlomfas.backend.services.userservice.domain.service.FanaticService;
import com.example.fortlomfas.backend.services.userservice.mapping.FanaticMapper;
import com.example.fortlomfas.backend.services.userservice.resource.Fanatic.CreateFanaticResource;
import com.example.fortlomfas.backend.services.userservice.resource.Fanatic.FanaticResource;
import com.example.fortlomfas.backend.services.userservice.resource.Fanatic.UpdateFanaticResource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/fanatics")
public class FanaticController {

    @Autowired
    private FanaticService fanaticService;

    @Autowired
    private FanaticMapper mapper;



    @GetMapping
    public Page<FanaticResource> getAllFanatics(Pageable pageable) {
        return mapper.modelListToPage(fanaticService.getAll(), pageable);
    }
    @GetMapping("{fanaticId}")
    public FanaticResource getUserById(@PathVariable("fanaticId") Long fanaticId) {
        return mapper.toResource(fanaticService.getById(fanaticId));
    }
    @GetMapping("/name/{fanaticname}")
    public FanaticResource getUserByfanaticname(@PathVariable("fanaticname") String fanaticname) {
        return mapper.toResource(fanaticService.getbyNombreUsuario(fanaticname));
    }
    @PostMapping
    public FanaticResource createUser(@RequestBody CreateFanaticResource request) {

        return mapper.toResource(fanaticService.create(mapper.toModel(request)));
    }
    @PutMapping("{fanaticId}")
    public FanaticResource updateUser(@PathVariable Long fanaticId, @RequestBody UpdateFanaticResource request) {
        return mapper.toResource(fanaticService.update(fanaticId, mapper.toModel(request)));
    }
    @DeleteMapping("{fanaticId}")
    public ResponseEntity<?> deletePost(@PathVariable Long fanaticId) {
        return fanaticService.delete(fanaticId);
    }
}

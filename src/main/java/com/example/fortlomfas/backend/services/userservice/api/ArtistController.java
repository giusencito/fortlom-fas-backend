package com.example.fortlomfas.backend.services.userservice.api;
import com.example.fortlomfas.backend.services.userservice.domain.service.ArtistService;
import com.example.fortlomfas.backend.services.userservice.mapping.ArtistMapper;
import com.example.fortlomfas.backend.services.userservice.resource.Artist.ArtistResource;
import com.example.fortlomfas.backend.services.userservice.resource.Artist.CreateArtistResource;
import com.example.fortlomfas.backend.services.userservice.resource.Artist.UpdateArtistResource;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/artists")
public class ArtistController {


    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtistMapper mapper;



    @GetMapping
    public Page<ArtistResource> getAllFanatics(Pageable pageable) {
        return mapper.modelListToPage(artistService.getAll(), pageable);
    }
    @GetMapping("{artistId}")
    public ArtistResource getUserById(@PathVariable("artistId") Long artistId) {
        return mapper.toResource(artistService.getById(artistId));
    }
    @GetMapping("/name/{artistname}")
    public ArtistResource getUserByartistname(@PathVariable("artistname") String artistname) {
        return mapper.toResource(artistService.getbyNombreUsuario(artistname));
    }
    @PostMapping
    public ArtistResource createUser(@RequestBody CreateArtistResource request) {

        return mapper.toResource(artistService.create(mapper.toModel(request)));
    }
    @PutMapping("{artistId}")
    public ArtistResource updateUser(@PathVariable Long artistId, @RequestBody UpdateArtistResource request) {
        return mapper.toResource(artistService.update(artistId, mapper.toModel(request)));
    }

    @PutMapping("{artistId}/tag/{tagname}")
    public ArtistResource updateUsertag(@PathVariable Long artistId,@PathVariable String tagname) {
        return mapper.toResource(artistService.setTag(artistId,tagname));
    }
    @PutMapping("{artistId}/upgrade")
    public ArtistResource upgradeartist(@PathVariable Long artistId) {
        return mapper.toResource(artistService.upgradeartist(artistId));
    }
    @PutMapping("/artist/{artistId}/InstagramAccount")
    public ArtistResource updateInstagramAccount(@PathVariable Long artistId, @RequestBody UpdateArtistResource request){
        return mapper.toResource(artistService.setInstagramAccount(artistId,mapper.toModel(request)));

    }
    @PutMapping("/artist/{artistId}/TwitterAccount")
    public ArtistResource updateTwitterAccount(@PathVariable Long artistId, @RequestBody UpdateArtistResource request){
        return mapper.toResource(artistService.setTwitterAccount(artistId,mapper.toModel(request)));
    }
    @PutMapping("/artist/{artistId}/FacebookAccount")
    public ArtistResource updateFacebookAccount(@PathVariable Long artistId, @RequestBody UpdateArtistResource request){
        return mapper.toResource(artistService.setFacebookAccount(artistId,mapper.toModel(request)));
    }
    @DeleteMapping("{artistId}")
    public ResponseEntity<?> deletePost(@PathVariable Long artistId) {
        return artistService.delete(artistId);
    }
}

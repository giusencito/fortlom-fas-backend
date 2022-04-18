package com.example.fortlomfas.backend.services.userservice.mapping;
import com.example.fortlomfas.backend.services.userservice.domain.model.entity.Person;
import com.example.fortlomfas.backend.services.userservice.resource.Person.PersonResource;
import com.example.fortlomfas.backend.services.userservice.resource.Person.UpdatePersonResource;
import com.example.fortlomfas.shared.mapping.EnhancedModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
public class PersonMapper {

    @Autowired
    EnhancedModelMapper mapper;

    public PersonResource toResource(Person model) {
        return mapper.map(model, PersonResource.class);
    }


    public Person toModel(UpdatePersonResource resource) {
        return mapper.map(resource, Person.class);
    }
}

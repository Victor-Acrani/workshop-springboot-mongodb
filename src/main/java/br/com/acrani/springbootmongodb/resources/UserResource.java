package br.com.acrani.springbootmongodb.resources;

import br.com.acrani.springbootmongodb.dto.UserDto;
import br.com.acrani.springbootmongodb.models.User;
import br.com.acrani.springbootmongodb.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
public class UserResource {

    private final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> findAll() {
        List<UserDto> all = userService.findAll();
        return ResponseEntity.ok().body(all);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> findById(@PathVariable String id){
        UserDto byId = userService.findById(id);
        return ResponseEntity.ok().body(byId);
    }

    @PostMapping
    public ResponseEntity<User> save(@RequestBody UserDto userDto){
        User save = userService.save(userDto);
        URI uri = URI.create(ServletUriComponentsBuilder.fromCurrentContextPath().path("/users/"+save.getId()).toUriString());
        return ResponseEntity.created(uri).body(save);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable String id){
        userService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable String id, @RequestBody UserDto userDto){
        User update = userService.update(id, userDto);
        return ResponseEntity.ok().body(update);
    }
}

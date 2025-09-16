package app.users.web;

import app.users.services.UserService;
import app.users.web.dtos.mappers.DtoMapper;
import app.users.web.dtos.requests.CreateUserRequest;
import app.users.web.dtos.responses.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserService userService;


    @Autowired
    public UserRestController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<GetUserResponse> createUserRequest(@RequestBody CreateUserRequest dto){
        return ResponseEntity.ok(DtoMapper.mapUserToGetUserResponse(userService.createUser(dto)));
    }
    @GetMapping("/{id}")
    public ResponseEntity<GetUserResponse> getUser(@PathVariable UUID id){
        return ResponseEntity.ok(DtoMapper.mapUserToGetUserResponse(userService.getUserById(id)));
    }

}

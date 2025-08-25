package com.group.ecommerce.Controller;

import com.group.ecommerce.Dto.UserDTO;
import com.group.ecommerce.Model.BaseReponseModel;
import com.group.ecommerce.Service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<BaseReponseModel> createUser(@RequestBody UserDTO userDTO) {
        try {
            userService.createUser(userDTO);
            BaseReponseModel response = new BaseReponseModel("User created successfully", "SUCCESS");
            return new ResponseEntity<>(response, HttpStatus.CREATED);
        } catch (Exception e) {
            BaseReponseModel response = new BaseReponseModel("Failed to create user", "ERROR");
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }
}

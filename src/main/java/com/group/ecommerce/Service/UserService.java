package com.group.ecommerce.Service;

import com.group.ecommerce.Dto.UserDTO;
import com.group.ecommerce.Entity.User;
import com.group.ecommerce.Repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(UserDTO userDTO) {
        User user = new User();
        user.setUsername(userDTO.getUsername());
        user.setEmail(userDTO.getEmail());
        user.setPassword(userDTO.getPassword()); // In real project, hash password!
        return userRepository.save(user);
    }
}

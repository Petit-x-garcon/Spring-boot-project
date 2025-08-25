package com.group.ecommerce.Mapper;

import com.group.ecommerce.Dto.UserDTO;
import com.group.ecommerce.Entity.User;

public class UserMapper {

    // Convert DTO → Entity
    public static User toEntity(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword()); // remember to hash in real project
        return user;
    }

    // Convert Entity → DTO
    public static UserDTO toDTO(User user) {
        UserDTO dto = new UserDTO();
        dto.setUsername(user.getUsername());
        dto.setEmail(user.getEmail());
        dto.setPassword(user.getPassword());
        return dto;
    }
}

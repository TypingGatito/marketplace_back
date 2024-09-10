package com.example.marketplace.dto.user;

import com.example.marketplace.models.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
abstract public class UserMapper {
    public abstract UserDto toDto(User user);

    @Mapping(target = "id", ignore = true)
    public abstract User toEntity(UserDto userDto);
}

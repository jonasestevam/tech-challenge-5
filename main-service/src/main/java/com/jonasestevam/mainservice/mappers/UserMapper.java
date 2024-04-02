package com.jonasestevam.mainservice.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.jonasestevam.domain.dtos.UserDTO;
import com.jonasestevam.domain.dtos.UserLoggedDTO;
import com.jonasestevam.domain.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper extends BaseMapper<UserDTO, User> {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserLoggedDTO toLoggedUser(UserDTO user);
}

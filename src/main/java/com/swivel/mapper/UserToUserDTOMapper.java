package com.swivel.mapper;

import com.swivel.dto.UserDTO;
import com.swivel.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserToUserDTOMapper {

    UserToUserDTOMapper INSTANCE = Mappers.getMapper(UserToUserDTOMapper.class);
    UserDTO userToUserDTO(User user);
}

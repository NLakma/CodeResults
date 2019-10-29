package com.swivel.mapper;

import com.swivel.dto.UserDTO;
import com.swivel.model.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2019-10-18T22:09:21-0700",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 1.8.0_131 (Oracle Corporation)"
)
public class UserToUserDTOMapperImpl implements UserToUserDTOMapper {

    @Override
    public UserDTO userToUserDTO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDTO userDTO = new UserDTO();

        userDTO.set_id( user.get_id() );
        userDTO.setUrl( user.getUrl() );
        userDTO.setExternal_id( user.getExternal_id() );
        userDTO.setName( user.getName() );
        userDTO.setAlias( user.getAlias() );
        userDTO.setCreated_at( user.getCreated_at() );
        userDTO.setActive( user.getActive() );
        userDTO.setVerified( user.getVerified() );
        userDTO.setShared( user.getShared() );
        userDTO.setLocale( user.getLocale() );
        userDTO.setTimezone( user.getTimezone() );
        userDTO.setLast_login_at( user.getLast_login_at() );
        userDTO.setEmail( user.getEmail() );
        userDTO.setPhone( user.getPhone() );
        userDTO.setSignature( user.getSignature() );
        userDTO.setOrganization_id( user.getOrganization_id() );
        List<String> list = user.getTags();
        if ( list != null ) {
            userDTO.setTags( new ArrayList<String>( list ) );
        }
        userDTO.setSuspended( user.getSuspended() );
        userDTO.setRole( user.getRole() );

        return userDTO;
    }
}

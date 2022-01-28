package com.kmit.mkp.mapper;

import com.kmit.mkp.dto.UserDto;
import com.kmit.mkp.dto.UserTokenDto;
import com.kmit.mkp.entity.UserToken;
import com.kmit.mkp.entity.Users;
import com.kmit.mkp.util.UUIDGenerator;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",
        imports = { UUIDGenerator.class })
public interface UserMapper {
    UserDto toUserDto(Users users);

    @Mapping(source = "id", target = "userId")
    @Mapping(
            target = "id",
            expression = "java(UUIDGenerator.getUUID())")
    @Mapping(target = "status", constant = "A")
    UserToken toUserToken(UserTokenDto userTokenDto);
}

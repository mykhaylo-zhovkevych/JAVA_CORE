package my_spring_api.api.mappers;

import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import my_spring_api.api.dtos.RegisterUserRequest;
import my_spring_api.api.dtos.UpdateUserRequest;
import my_spring_api.api.dtos.UserDto;
import my_spring_api.api.entities.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    //@Mapping(target = "createdAt", expression="java(java.time.LocalDateTime.now())")
    UserDto toDto(User user);
    User toEntity(RegisterUserRequest request);
    void update(UpdateUserRequest request, @MappingTarget User user);

}

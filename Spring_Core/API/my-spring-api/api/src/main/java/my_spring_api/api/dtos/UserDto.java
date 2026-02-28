package my_spring_api.api.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;


@AllArgsConstructor
@Getter
// Here all data can be managed with custome json response
public class UserDto {
    private Long id;
    private String name;
    private String email;
    // @JsonFormat(pattern="yyyy-MM-dd")
    // private LocalDateTime createdAt;
}

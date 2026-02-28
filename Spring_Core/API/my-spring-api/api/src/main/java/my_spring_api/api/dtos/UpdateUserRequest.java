package my_spring_api.api.dtos;

import lombok.Data;

@Data
public class UpdateUserRequest {
    private String name; 
    private String email;    
}

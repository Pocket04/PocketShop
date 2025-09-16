package app.users.web.dtos.mappers;

import app.users.modules.User;
import app.users.web.dtos.responses.GetUserResponse;

public class DtoMapper {

    public static GetUserResponse mapUserToGetUserResponse(User user){
        GetUserResponse dto = new GetUserResponse();
        dto.setEmail(user.getEmail());
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        return dto;
    }

}

package voidX.project.hrMan.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserInfoResponse {

    private int id;
    private String username;
    private String email;
    private List<String> roles;
}

package voidX.project.hrMan.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtAuthenticationResponse {

    private  String accessToken;
    private String roles;
    private Boolean success;
}

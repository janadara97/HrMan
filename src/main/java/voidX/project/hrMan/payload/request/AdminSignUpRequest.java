package voidX.project.hrMan.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminSignUpRequest {

    @NotBlank
    @Size(max = 50,min = 3)
    private String email;

    @NotBlank
    @Size(max = 20,min = 3)
    private String username;

    @NotBlank
    private String password;

    @NotBlank
    private Set<String>roles;
}

package voidX.project.hrMan.payload.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignUpRequest {

    @NotBlank
    @Length(max = 20)
    private String firstName;

    @NotBlank
    @Length(max = 20)
    private String lastName;

    @NotNull
    private LocalDate dob;

    @NotBlank
    @Length(max = 20)
    private String email;

    @NotBlank
    @Length(max = 20)
    private String username;

    @NotBlank
    @Length(max = 20)
    private String password;

    @NotBlank
    @Length(max = 20)
    private String mobile;

    @NotNull
    private Set<Integer> roleIds;
}

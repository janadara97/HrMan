package voidX.project.hrMan.payload.response;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ApiResponse {

    private Boolean success;
    private String message;
}

package voidX.project.hrMan.service;

import org.springframework.http.ResponseEntity;
import voidX.project.hrMan.payload.dto.RoleDto;
import voidX.project.hrMan.payload.request.LoginRequest;
import voidX.project.hrMan.payload.request.SignUpRequest;

public interface AuthService {
    public ResponseEntity<Object> authenticateUser(LoginRequest loginRequest);
    public ResponseEntity<Object> registerUser(SignUpRequest signUpRequest);
    public ResponseEntity<Object> createRole(RoleDto roleDto);
}

package voidX.project.hrMan.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import voidX.project.hrMan.payload.dto.RoleDto;
import voidX.project.hrMan.payload.request.LoginRequest;
import voidX.project.hrMan.payload.request.SignUpRequest;
import voidX.project.hrMan.service.AuthService;

import javax.validation.Valid;

@CrossOrigin
@RestController
@RequestMapping("api/auth")
public class AuthController {

    @Autowired
    AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<Object> authenticateUser(@Valid @RequestBody LoginRequest loginRequest){
        return authService.authenticateUser(loginRequest);
    }
    @PostMapping("/signup")
    public ResponseEntity<Object> registerAdmin(@Valid @RequestBody SignUpRequest signUpRequest){
        return authService.registerUser(signUpRequest);
    }
    @PostMapping("/createRole")
    public ResponseEntity<Object> createRole(@RequestBody RoleDto roleDto){
        return  authService.createRole(roleDto);
    }
}

package voidX.project.hrMan.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import voidX.project.hrMan.exceptions.ResourceNotFoundException;
import voidX.project.hrMan.model.Role;
import voidX.project.hrMan.model.User;
import voidX.project.hrMan.payload.dto.RoleDto;
import voidX.project.hrMan.payload.request.LoginRequest;
import voidX.project.hrMan.payload.request.SignUpRequest;
import voidX.project.hrMan.payload.response.ApiResponse;
import voidX.project.hrMan.payload.response.JwtAuthenticationResponse;
import voidX.project.hrMan.repositories.RoleRepository;
import voidX.project.hrMan.repositories.UserRepository;
import voidX.project.hrMan.security.CustomUserDetailsService;
import voidX.project.hrMan.security.JwtUtils;
import voidX.project.hrMan.security.UserPrinciple;
import voidX.project.hrMan.service.AuthService;

import java.util.Arrays;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    RoleRepository roleRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    CustomUserDetailsService userDetailsService;
    @Autowired
    JwtUtils jwtUtils;
    @Autowired

    private static final Logger LOGGER= LoggerFactory.getLogger(AuthServiceImpl.class);
    @Override
    public ResponseEntity<Object> authenticateUser(LoginRequest loginRequest) {
        try{
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername().trim(),loginRequest.getPassword().trim()));
            UserPrinciple userPrinciple = userDetailsService.loadUserByUsername(loginRequest.getUsername().trim());
            Collection<? extends GrantedAuthority> roles = userPrinciple.getAuthorities();
            String jwt = jwtUtils.generateToken(authentication);

            LOGGER.info("Authenticate user: {}", loginRequest.getUsername());
            return ResponseEntity.ok(new JwtAuthenticationResponse(jwt, Arrays.toString(roles.toArray()),true));
        }
        catch(Exception e){
            e.printStackTrace();
            LOGGER.error("Authentication Failed");
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(false, e.getMessage()));
        }
    }

    @Override
    public ResponseEntity<Object> registerUser(SignUpRequest signUpRequest) {

        try {
            String password=signUpRequest.getPassword();
            String encodedPasswod=passwordEncoder.encode(password);
            Set<Role> roles=signUpRequest.getRoleIds().stream().map(roleId->roleRepository.findById(roleId).get()).collect(Collectors.toSet());

            User user=User.builder().firstName(signUpRequest.getFirstName()).lastName(signUpRequest.getLastName()).mobile(signUpRequest.getMobile()).email(signUpRequest.getEmail()).username(signUpRequest.getUsername()).dob(signUpRequest.getDob()).password(encodedPasswod).roles(roles).build();
            userRepository.save(user);
            LOGGER.info("Successfully created user : {}", user.getUsername());
            return ResponseEntity.ok(new ApiResponse(true,"user created sussessfully"));
        }
        catch (ResourceNotFoundException e){
            LOGGER.error(e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false,"Unable to create the user"));
        }
        catch (Exception e){
            LOGGER.error("Registration Failed\n :{}",e.getMessage());
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false,"Unable to create the user"));
        }
    }

    @Override
    public ResponseEntity<Object> createRole(RoleDto roleDto) {
        try{
            roleRepository.save(new Role().builder().roleName(roleDto.roleName).build());
            LOGGER.info("role created sussessfully");
            return ResponseEntity.ok(new ApiResponse(true,"role created sussessfully"));
        }
        catch (Exception e){
            e.printStackTrace();
            LOGGER.error("Role Creation Failed\n :{}",e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ApiResponse(false,"unable to create the user"));
        }
    }
}

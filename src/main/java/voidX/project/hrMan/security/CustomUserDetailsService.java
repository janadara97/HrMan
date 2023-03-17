package voidX.project.hrMan.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import voidX.project.hrMan.model.User;
import voidX.project.hrMan.repositories.UserRepository;

import javax.transaction.Transactional;

@Component
public class  CustomUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;

    @Override
    @Transactional
    public UserPrinciple loadUserByUsername(String username) throws UsernameNotFoundException {
        User user=userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User Not Found"));
        return  UserPrinciple.create(user);
    }
}

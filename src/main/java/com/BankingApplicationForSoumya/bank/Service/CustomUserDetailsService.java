package com.BankingApplicationForSoumya.bank.Service;

import com.BankingApplicationForSoumya.bank.entity.Users;
import com.BankingApplicationForSoumya.bank.model.UserPrincipal;
import com.BankingApplicationForSoumya.bank.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {


    @Autowired
    private UserRepository userRepository;





    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = userRepository.findByUsername(username);
        if (user==null)
        {
            System.out.println("User not found");
            throw new UsernameNotFoundException("User not found");
        }

        return new UserPrincipal(user);
    }

    public Users Register(Users user){
        Users user_encrypted = new Users();
        user_encrypted.setId(user.getId());
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder(10);
        String encodedPassword = passwordEncoder.encode(user.getPassword());
        user_encrypted.setPassword(encodedPassword);
        user_encrypted.setUsername(user.getUsername());

        Users savedUser = userRepository.save(user_encrypted);

        return savedUser;
    }


}

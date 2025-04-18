package org.studyeasy.SpringBlog.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.studyeasy.SpringBlog.models.Account;
import org.studyeasy.SpringBlog.repositories.AccountRepository;
import org.studyeasy.SpringBlog.util.constants.Roles;

@Service
public class AccountService implements UserDetailsService {
    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;
    public Account save (Account account) {
        account.setPassword(passwordEncoder.encode(account.getPassword()));
        account.setRole(Roles.USER.getRole());
        return accountRepository.save(account);
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
          Optional<Account> optionalAccount = accountRepository.findOneByEmailIgnoreCase(email);
        if(!optionalAccount.isPresent()){
            throw new UsernameNotFoundException("Account not found");
        }
        Account account = optionalAccount.get();
        
        List<GrantedAuthority> grantedAuthority = new ArrayList<>();
        grantedAuthority.add(new SimpleGrantedAuthority(account.getRole()));
        // grantedAuthority.add(new SimpleGrantedAuthority(Roles.USER.getRole()));
        // grantedAuthority.add(new SimpleGrantedAuthority(Roles.ADMIN.getRole()));
        // grantedAuthority.add(new SimpleGrantedAuthority(Roles.MODERATOR.getRole()));
        // grantedAuthority.add(new SimpleGrantedAuthority(Roles.SUPER_ADMIN.getRole()));
        // grantedAuthority.add(new SimpleGrantedAuthority(Roles.ROLE_USER.getRole()));
        // grantedAuthority.add(new SimpleGrantedAuthority(Roles.ROLE_ADMIN.getRole()));
        // grantedAuthority.add(new SimpleGrantedAuthority(Roles.ROLE_MODERATOR.getRole()));
        // grantedAuthority.add(new SimpleGrantedAuthority(Roles.ROLE_SUPER_ADMIN.getRole()));      

        return new User(account.getEmail(), account.getPassword(), grantedAuthority);
    }
    
}

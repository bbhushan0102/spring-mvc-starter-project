package org.studyeasy.SpringBlog.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.studyeasy.SpringBlog.models.Authority;
import org.springframework.stereotype.Service;
import org.studyeasy.SpringBlog.repositories.AuthorityRepository;

@Service
public class AuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    public Authority save(Authority authority) {
        return authorityRepository.save(authority);
    }
     
    
}

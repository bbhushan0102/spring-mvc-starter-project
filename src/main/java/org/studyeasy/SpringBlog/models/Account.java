package org.studyeasy.SpringBlog.models;


import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
// @Table(name = "account")
// @JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
// @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
// @JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "id")
// @JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property = "id")   
@NoArgsConstructor

public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String email;
    private String password;
    private String firstname;
    private String lastname;
    private String role; 

    @OneToMany (mappedBy = "account")
    private List<Post> posts;
    
}
    

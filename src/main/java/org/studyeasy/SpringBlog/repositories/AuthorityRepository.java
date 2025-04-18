package org.studyeasy.SpringBlog.repositories;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.studyeasy.SpringBlog.models.Authority;

@Repository
public interface AuthorityRepository extends JpaRepository <Authority, Long> {

    Authority save(Authority authority);
   
    
}

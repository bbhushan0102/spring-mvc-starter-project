package org.studyeasy.SpringStarter.config;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.studyeasy.SpringStarter.models.Post;
import org.studyeasy.SpringStarter.services.PostService;

@Component
public class SeedData implements CommandLineRunner{
   
    @Autowired
    private PostService postService;

    @Override
    public void run(String... args) throws Exception {
       List<Post> posts = postService.getAll();
       if (posts.size() == 0){
            Post post01 = new Post();
            post01.setTitle("Post 01");
            post01.setBody("Post 01 body.....................");
            postService.save(post01);

            Post post02 = new Post();
            post02.setTitle("Post 02");
            post02.setBody("Post 02 body.....................");

            postService.save(post02);

       }
        
    }
    
    
}

package com.example.joblisting.Controller;

import com.example.joblisting.PostRepo;
import com.example.joblisting.model.Post;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


import java.io.IOException;
import java.util.List;

@RestController
//@RequestMapping("/job")
public class JobController {

    @Autowired
    PostRepo postRepo;

    @RequestMapping(value="/" )
    public void redirect(HttpServletResponse response) throws IOException {
        response.sendRedirect("/swagger-ui.html");
    }

    @GetMapping("/posts")
    public List<Post> getAllPosts() {
        return  postRepo.findAll();
    }

    @PostMapping("/post")
    public Post addPost(@RequestBody Post post){
        System.out.println("==== Received POST ====");
        System.out.println("Profile: " + post.getProfile());
        System.out.println("Desc: " + post.getDesc());
        System.out.println("Exp: " + post.getExp());
//        System.out.println("Tech: " + post.getTech());
        return postRepo.save(post);
    }

}

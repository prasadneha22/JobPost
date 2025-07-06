package com.example.joblisting;

import com.example.joblisting.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

public interface PostRepo extends MongoRepository<Post,String> {
}

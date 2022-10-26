package com.nestdigital.todo_backend.dao;

import com.nestdigital.todo_backend.model.PostModel;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Map;

public interface PostDao extends CrudRepository<PostModel,Integer> {

    @Query(value = "SELECT `id`, `post`, `postdate`, `userid` FROM `posts` WHERE `userid`=:userid", nativeQuery = true)
    List<Map<String ,String>>viewAllSingle(Integer userid);
}

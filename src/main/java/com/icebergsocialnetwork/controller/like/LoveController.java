package com.icebergsocialnetwork.controller.like;

import com.icebergsocialnetwork.model.like.Love;
import com.icebergsocialnetwork.services.like.ILove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping("/loves")
public class LoveController {
    @Autowired
    private ILove iLove;
    @PostMapping
    public void like(@RequestBody Love love){
        iLove.save(love);
    }

    @DeleteMapping("/{id}")
    public void unlike(@PathVariable Long id){
        iLove.deleteById(id);
    }
    @GetMapping
    public Iterable<Love> getAll(){
        return iLove.findAll();
    }
    @GetMapping("/{id}")
    public Love
}

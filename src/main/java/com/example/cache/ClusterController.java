package com.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("cluster")
@RestController
public class ClusterController {

    @Autowired
    HazelcastStoreImpl store;



    @GetMapping("devices")
    public
    Iterable<Device> findAll(){
        return store.findAll();
    }


    @GetMapping("devices/{id}")
    public
    Device  findById(@PathVariable("id") String id){
        return store.findById(id);
    }
}

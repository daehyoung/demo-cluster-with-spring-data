package com.example.cache;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeviceController {

    @Autowired
    DeviceStore store;

    @Autowired
    HazelcastStoreImpl hazelcastStore;

    @GetMapping("devices")
    public
    Iterable<Device> findAll(){
        return store.findAll();
    }


    @GetMapping("devices/{id}")
    public
     Device  findById(@PathVariable("id") String id){
        return store.findById(id).get();
    }

    @PutMapping("devices")
    public @ResponseBody  Device  put(@RequestBody  Device  data){
        Device device = store.save(data);
        hazelcastStore.save(device);
        return device;
    }

    @PostMapping("devices")
    public @ResponseBody  Device  post(@RequestBody  Device  data){
        Device device = store.save(data);
        hazelcastStore.save(device);
        return device;
    }

}

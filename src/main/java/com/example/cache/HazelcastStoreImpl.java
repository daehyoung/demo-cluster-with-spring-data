package com.example.cache;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.map.IMap;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class HazelcastStoreImpl implements KeyValueStore<Device,String>{
    final String DEVICE = "device";
   final HazelcastInstance hazelcastInstance;

    IMap<String, Device>  getMap(){
       IMap<String, Device> map = hazelcastInstance.getMap(DEVICE);
       return map;
   }

    @Override
    public Device findById(String id) {

        return getMap().get(id);
    }

    @Override
    public Iterable<Device> findAll() {
        return getMap().values();
    }

    @Override
    public Device save(Device data) {
        return getMap().put(data.getId(),data);
    }
}

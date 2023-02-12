package com.example.cache;

import com.hazelcast.client.HazelcastClient;
import com.hazelcast.client.config.ClientConfig;
import com.hazelcast.config.Config;

import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class HazelcastStoreConfig {

    @Bean
    public HazelcastInstance hazelcastInstance(){
        return Hazelcast.newHazelcastInstance() ;
    }

    @Bean
    public
    HazelcastStoreImpl HazelcastStoreImpl(HazelcastInstance instance){
        return new HazelcastStoreImpl(instance);
    }
}

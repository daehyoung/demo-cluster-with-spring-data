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
        Config config = new Config();
        config.getNetworkConfig().setPort( 5900 );
        config.setClusterName("device-io-loader");
        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public
    HazelcastStoreImpl HazelcastStoreImpl(HazelcastInstance instance){
        return new HazelcastStoreImpl(instance);
    }
}

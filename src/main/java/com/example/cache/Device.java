package com.example.cache;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

@Data
public class Device {
    @Id
    String id;
    String name;

    @Version
    Integer version;
}

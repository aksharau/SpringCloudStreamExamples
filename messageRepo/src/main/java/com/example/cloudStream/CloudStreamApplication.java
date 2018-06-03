package com.example.cloudStream;

import com.example.*;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
@EnableBinding(StreamsForTheProject.class)
public class CloudStreamApplication {

	public static void main(String[] args) {
		SpringApplication.run(CloudStreamApplication.class, args);
	}
}

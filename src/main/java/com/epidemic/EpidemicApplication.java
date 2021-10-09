package com.epidemic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.epidemic.*;

@SpringBootApplication
@ComponentScan(basePackages ={ "com.epidemic, com.epidemic.controller, com.epidemic.models, com.epidemic.repositories, com.epidemic.services ,com.example.demo"} )
public class EpidemicApplication extends SpringBootServletInitializer {
	
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(EpidemicApplication.class);
	}

// new  branch
	public static void main(String[] args) {
		SpringApplication.run(EpidemicApplication.class, args);
	}


}

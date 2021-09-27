package com.epidemic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import com.epidemic.*;

@SpringBootApplication
@ComponentScan(basePackages ={ "com.epidemic, com.epidemic.controller, com.epidemic.models, com.epidemic.repositories, com.epidemic.services"} )
public class EpidemicApplication {

	public static void main(String[] args) {
		SpringApplication.run(EpidemicApplication.class, args);
	}

}

package com.example.excelProj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class TimesheetApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(TimesheetApplication.class, args);
	}

//
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
		return builder.sources(TimesheetApplication.class);
	}
}

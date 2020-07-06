package cn.nbbandxdd.accesstoken;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AccesstokenApplication {

	@PostConstruct
	void setDefaultTimeZone() {
		
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
	}

	public static void main(String[] args) {
		
		SpringApplication.run(AccesstokenApplication.class, args);
	}
}

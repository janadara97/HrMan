package voidX.project.hrMan;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class })
public class HrManApplication {

	public static void main(String[] args) {
		SpringApplication.run(HrManApplication.class, args);
	}
}

package ipd.com.ipd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ipd.com.respository") // Tell Spring where to find repositories
@EntityScan(basePackages = "ipd.com.models")
@ComponentScan(basePackages = "ipd.com.mange")                // Scans for @Controller, @Service, etc.
public class IpdApplication {

	public static void main(String[] args) {
		SpringApplication.run(IpdApplication.class, args);
	}

}

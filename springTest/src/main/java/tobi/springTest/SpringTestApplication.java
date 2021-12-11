package tobi.springTest;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringTestApplication {
	
	private static final int DEFAULT_PORT = 8086;
	
	public static void main(String[] args) {
		
		SpringApplication app = new SpringApplication(SpringTestApplication.class);
		
		app.setDefaultProperties(Collections.singletonMap("server.port", DEFAULT_PORT));
		app.run(args);
		
		System.out.println("SpringTest!");
		
	}

}

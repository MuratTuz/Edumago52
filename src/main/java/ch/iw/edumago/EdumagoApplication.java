package ch.iw.edumago;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.ServerProperties;

@SpringBootApplication
public class EdumagoApplication implements CommandLineRunner {

	@Autowired
	private ServerProperties serverProperties;

	@Override
	public void run(String... args) {
		System.out.println("EDUMAGO" + serverProperties.toString());
	}

	public static void main(String[] args) {
		SpringApplication.run(EdumagoApplication.class, args);
	}
}
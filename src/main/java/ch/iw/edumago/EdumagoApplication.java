package ch.iw.edumago;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;
import java.util.stream.Collectors;


@SpringBootApplication
public class EdumagoApplication implements CommandLineRunner {

	@Override
	public void run(String... args) {}

	public static void main(String[] args) {
		SpringApplication.run(EdumagoApplication.class, args);
	}
}
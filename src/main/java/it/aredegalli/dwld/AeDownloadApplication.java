package it.aredegalli.dwld;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"it.aredegalli.dwld"})
public class AeDownloadApplication {

	public static void main(String[] args) {
		SpringApplication.run(AeDownloadApplication.class, args);
	}

}

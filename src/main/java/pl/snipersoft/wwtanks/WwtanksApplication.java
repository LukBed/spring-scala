package pl.snipersoft.wwtanks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WwtanksApplication {

	public static void main(String[] args) {
		SpringApplication.run(WwtanksApplication.class, args);
		Database.initDatabase();
	}

}

package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.example.demo.entity.Bank;
import com.example.demo.entity.Branch;
import com.example.demo.repository.BankRepository;
import com.example.demo.repository.BranchRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.web.servlet.context.ServletWebServerApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.util.pattern.PathPatternParser;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	CommandLineRunner seedData(BankRepository bankRepository, BranchRepository branchRepository) {
		return args -> {
			if (bankRepository.count() == 0) {
				Bank bank1 = new Bank();
				bank1.setName("Bank A");
				Bank bank2 = new Bank();
				bank2.setName("Bank B");
				bankRepository.save(bank1);
				bankRepository.save(bank2);

				Branch branch1 = new Branch();
				branch1.setName("Branch A1");
				branch1.setBank(bank1);
				Branch branch2 = new Branch();
				branch2.setName("Branch A2");
				branch2.setBank(bank1);
				Branch branch3 = new Branch();
				branch3.setName("Branch B1");
				branch3.setBank(bank2);
				branchRepository.save(branch1);
				branchRepository.save(branch2);
				branchRepository.save(branch3);
			}
		};
	}

	@Configuration
	class ApiBasePathConfig implements WebMvcConfigurer {
		@Override
		public void configurePathMatch(PathMatchConfigurer configurer) {
			configurer.addPathPrefix("/api/v1", c -> true);
		}
	}

}

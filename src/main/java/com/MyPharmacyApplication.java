package com;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tomek.domain.Medicine;
import com.tomek.repository.MedicineRepository;
import com.tomek.service.MedicineService;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MyPharmacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyPharmacyApplication.class, args);




	}

}

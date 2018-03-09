package com.tomek;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;
import com.tomek.domain.Medicine;
    import com.tomek.service.MedicineService;
    import java.io.IOException;
    import java.io.InputStream;
    import java.lang.reflect.Type;
    import java.util.ArrayList;
    import java.util.List;
    import javax.annotation.PostConstruct;
    import javax.annotation.Resources;
    import org.springframework.boot.CommandLineRunner;
    import org.springframework.context.annotation.Bean;
    import org.springframework.stereotype.Component;
    import sun.misc.IOUtils;
@Component
public class DataLoader {

  @Bean
  public CommandLineRunner runner(MedicineService medicineService){
    return args -> {
      // read JSON and load json
      ObjectMapper mapper = new ObjectMapper();
      TypeReference<List<Medicine>> typeReference = new TypeReference<List<Medicine>>(){};
      InputStream inputStream = TypeReference.class.getResourceAsStream("/json/Medicines.json");
      try {
        List<Medicine> users = mapper.readValue(inputStream,typeReference);
        medicineService.save(users);
        System.out.println("Users Saved!");
      } catch (IOException e){
        System.out.println("Unable to save users: " + e.getMessage());
      }
    };
  }



}

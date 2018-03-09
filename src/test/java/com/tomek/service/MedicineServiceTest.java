package com.tomek.service;

import static org.junit.jupiter.api.Assertions.*;

import com.tomek.domain.Medicine;
import com.tomek.repository.MedicineRepository;
import java.util.Date;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class MedicineServiceTest {

  @InjectMocks
  MedicineService medicineService;

  @Mock
  MedicineRepository medicineRepository;



  @BeforeEach
  void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);



  }

  @Test
  void listOfMedicines() {
    Medicine medicine = new Medicine();
    medicine.setId(1L);
    medicine.setName("name");
    medicine.setAddedAt(new Date());
    medicine.setBrand("Pharma");
    medicine.setCost(13);
    medicine.setNumberOfServings(5);
    medicineService.save(medicine);



    List<Medicine> medicineList = medicineService.listOfMedicines();
    medicineList.add(medicine);
    System.out.println(medicineList.size());
    medicineList.forEach(medicine1 -> System.out.println(medicine1.getBrand()));
  }
}
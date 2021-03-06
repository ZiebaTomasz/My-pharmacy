package com.tomek.service;

import com.tomek.domain.Medicine;
import com.tomek.repository.MedicineRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;


@Service
public class MedicineService {

  private MedicineRepository medicineRepository;

  @Autowired
  public MedicineService(MedicineRepository medicineRepository) {
    this.medicineRepository = medicineRepository;
  }

  public Optional<Medicine> medicineById(Long id){
    return medicineRepository.findById(id);
  }

  public List<Medicine> listOfMedicines(){
    return medicineRepository.findAll();
  }

  public Medicine save(Medicine medicine){
    return medicineRepository.save(medicine);
  }

  public void save(List<Medicine> medicines){
    medicines.stream()
        .forEach(medicine -> medicineRepository.save(medicine));
  }

  public void deleteMedicineById(Long id){
    medicineRepository.deleteById(id);
  }


}

package com.tomek.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.tomek.DataLoader;
import com.tomek.domain.Medicine;
import com.tomek.repository.MedicineRepository;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;

class MedicineServiceTest {

  private MedicineService medicineService;

  @Mock
  private MedicineRepository medicineRepository;

  @Mock
  private Medicine medicine;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    medicineService = new MedicineService(medicineRepository);
  }

  @Test
  void shouldReturnMedicine_whenMedicineByIdCalls() {
    when(medicineRepository.findById(2L)).thenReturn(java.util.Optional.ofNullable(medicine));

    Optional<Medicine> retrieveOptionalMedicine =  medicineService.medicineById(2L);
    Medicine retrieveMedicine = retrieveOptionalMedicine.get();
    assertThat(retrieveMedicine,is(equalTo(medicine)));
  }

  @Test
  public void shouldCallDeteleMethodOfMedicineRepository_whenDeleteMedicineIsCalled(){
    doNothing().when(medicineRepository).deleteById(2l);
    MedicineRepository medicineRepository = Mockito.mock(MedicineRepository.class);

    medicineRepository.deleteById(2L);

    verify(medicineRepository, times(1)).deleteById(2L);
  }
}
package com.tomek.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Date;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MedicineTest {

  Medicine medicine;

  @BeforeEach
  void setUp() {
    medicine = new Medicine();
    medicine.setBrand("Olimp");
    medicine.setName("calcium");
    medicine.setAddedAt(new Date(2005,05,7));

  }

  @Test
  void getId() {
    assertEquals(medicine.getId(), null);
    long exprectedId = 2l;
    medicine.setId(exprectedId);
    assertEquals(exprectedId, (long)medicine.getId());
  }

  @Test
  void getName() {
    String exprectedName = "Caloium";
    assertNotEquals(medicine.getName(),exprectedName);
    assertTrue(medicine.getName().equalsIgnoreCase(exprectedName));
  }

  @Test
  void getBrand() {
    String expectedBrand = "Olimp";
    assertEquals(medicine.getBrand(),expectedBrand);
  }

  @Test
  void getDescription() {
  }

  @Test
  void getCost() {
  }

  @Test
  void getNumberOfServings() {
  }

  @Test
  void getAddedAt() {
  }
}
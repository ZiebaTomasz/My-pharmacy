package com.tomek.controller;

import com.tomek.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

  MedicineService medicineService;

  @Autowired
  public AdminController(MedicineService medicineService) {
    this.medicineService = medicineService;
  }
}

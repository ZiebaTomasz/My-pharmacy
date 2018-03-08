package com.tomek.controller;

import com.tomek.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class HomeController {

  MedicineService medicineService;

  @Autowired
  public HomeController(MedicineService medicineService) {
    this.medicineService = medicineService;
  }


}

package com.tomek.controller;

import com.tomek.domain.Medicine;
import com.tomek.service.MedicineService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

  MedicineService medicineService;

  @Autowired
  public AdminController(MedicineService medicineService) {
    this.medicineService = medicineService;
  }

  @RequestMapping("/")
  public String getAllPosts(Model model){
    model.addAttribute("medicines", medicineService.listOfMedicines());
    return "medicines/medicinesList";
  }
}

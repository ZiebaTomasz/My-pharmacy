package com.tomek.controller;

import com.tomek.domain.Medicine;
import com.tomek.service.MedicineService;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

  MedicineService medicineService;

  @Autowired
  public HomeController(MedicineService medicineService) {
    this.medicineService = medicineService;
  }

  @GetMapping("/")
  public String getAllPosts(Model model){
    model.addAttribute("medicines", medicineService.listOfMedicines());
    return "medicines";
  }

  @GetMapping("/medicine/{id}")
  public String detailMedicine(@PathVariable(value = "id")Long id, Model model){

       model.addAttribute("medicine",medicineService.medicineById(id));
       return "medicineDetail";
  }

}

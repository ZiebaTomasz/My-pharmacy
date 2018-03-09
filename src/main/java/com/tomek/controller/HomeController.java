package com.tomek.controller;

import com.tomek.domain.Medicine;
import com.tomek.service.MedicineService;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import org.apache.logging.log4j.util.PropertySource.Comparator;
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

  @GetMapping("/byName")
  public String getallPostsByName(Model model){
    List<Medicine> medicineSortedList = medicineService.listOfMedicines();
    medicineSortedList.sort((Medicine m1, Medicine m2) -> m1.getName().compareToIgnoreCase(m2.getName()));
    model.addAttribute("medicines",medicineSortedList);
    return "medicines";
  }

  @GetMapping("/byBrand")
  public String getallPostsByBrand(Model model){
    List<Medicine> medicineSortedList = medicineService.listOfMedicines();
    medicineSortedList.sort((Medicine m1, Medicine m2) -> m1.getBrand().compareToIgnoreCase(m2.getBrand()));
    model.addAttribute("medicines",medicineSortedList);
    return "medicines";
  }

  @GetMapping("/byCost")
  public String getallPostsByCost(Model model){
    List<Medicine> medicineSortedList = medicineService.listOfMedicines();
    medicineSortedList.sort(new java.util.Comparator<Medicine>() {
      @Override
      public int compare(Medicine med1, Medicine med2) {
        return (int) (med1.getCost() - med2.getCost());
      }
    });
    model.addAttribute("medicines",medicineSortedList);
    return "medicines";
  }

  @GetMapping("/login")
  public String login(){
    return "login/login";
  }


  @GetMapping("/medicine/{id}")
  public String detailMedicine(@PathVariable(value = "id")Long id, Model model){

       model.addAttribute("medicine",medicineService.medicineById(id));
       return "medicineDetail";
  }

}

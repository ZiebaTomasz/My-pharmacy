package com.tomek.controller;

import com.tomek.domain.Medicine;
import com.tomek.service.MedicineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

  MedicineService medicineService;

  @Autowired
  public AdminController(MedicineService medicineService) {
    this.medicineService = medicineService;
  }


  @RequestMapping("/admin/edit/{id}")
  public String editMedicine(@PathVariable (value = "id")Long id, Model model) {
      return "";
  }

  @PostMapping("admin/medicines")
  public String saveMedicine(Medicine medicine){
    medicineService.save(medicine);
    return "redirect:/";
  }

  @RequestMapping("/admin/create")
  public String create(Model model) {
    model.addAttribute("medicine", new Medicine());
    return "editMedicine";
  }

  @GetMapping(value = "/admin/delete/{id}")
  public String delete(@PathVariable(name = "id")Long id, Model model) {
    medicineService.deleteMedicineById(id);
    return "redirect:/";
  }


}

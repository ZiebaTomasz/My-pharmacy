package com.tomek.controller;

import com.tomek.domain.Medicine;
import com.tomek.service.MedicineService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AdminController {

  MedicineService medicineService;

  @Autowired
  public AdminController(MedicineService medicineService) {
    this.medicineService = medicineService;
  }


  @GetMapping("/admin/edit/{id}")
  public String editMedicine(@PathVariable (value = "id")Long id, Model model) {
    model.addAttribute("medicine",medicineService.medicineById(id));
      return "admin/editMedicine";
  }

  @PostMapping("admin/save")
  public String saveMedicine(@Valid Medicine medicine, BindingResult bindingResult){
    if (bindingResult.hasErrors()){
      System.out.println("some error");
    }
    medicineService.save(medicine);
    return "redirect:/";
  }

  @GetMapping("/admin/create")
  public String createMedicine(Model model) {
    model.addAttribute("medicine", new Medicine());
    return "admin/addMedicine";
  }

  @GetMapping(value = "/admin/delete/{id}")
  public String delete(@PathVariable(name = "id")Long id, Model model) {
    medicineService.deleteMedicineById(id);
    return "redirect:/";
  }


}

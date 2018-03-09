package com.tomek.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.TestInstance.Lifecycle.PER_METHOD;

import com.tomek.domain.Comment;
import com.tomek.domain.Medicine;
import com.tomek.repository.CommentRepository;
import com.tomek.repository.MedicineRepository;
import java.util.List;
import org.junit.Before;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
class CommentServiceTest {

  CommentService commentService;
  MedicineService medicineService;
  @Mock
  CommentRepository commentRepository;
  @Mock
  MedicineRepository medicineRepository;

  Medicine medicine;
  Comment comment;
  Comment comment1;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.initMocks(this);
    commentService = new CommentService(commentRepository);
    medicineService = new MedicineService(medicineRepository);

    medicine = new Medicine();
    medicine.setId(1L);
    medicine.setName("name");
    medicine.setBrand("brand");

    medicineService.save(medicine);

    comment = new Comment();
    comment.setMedicine(medicine);
    comment.setId(1L);
    comment1 = new Comment();
    comment1.setId(2L);
    comment1.setMedicine(medicine);

    commentRepository.save(comment);
    commentRepository.save(comment1);
  }

  @Test
  void commentByMedicine() {

    System.out.println(comment1.getId());
//    Comment comment2 = new Comment();
//    comment2.setId(2L);
//    comment2.setText("super");
//
//    commentRepository.save(comment2);
//    System.out.println(comment2.getId());
//    List<Comment> all = (List<Comment>) commentRepository.findAll();
//    System.out.println(all.size());
//
    List<Comment> commentList = commentService.allComments();
    System.out.println(commentList.size());
    System.out.println(medicineRepository.findById(1L));

    Iterable<Medicine> medicineIterable = medicineService.listOfMedicines();
    System.out.println();
  }
}
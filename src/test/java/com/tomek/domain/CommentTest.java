package com.tomek.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CommentTest {

  Comment comment;

  @BeforeEach
  void setUp() {
    comment = new Comment();
    comment.setId(3L);
    comment.setText("There is a super medicine");

    Medicine medicine = new Medicine();
    medicine.setName("painkiller");
    comment.setMedicine(medicine);
  }

  @Test
  void getId() {
    Long exprectedId = 3L;
    assertEquals(exprectedId, comment.getId());
  }

  @Test
  void getText() {
    String expectedInText = "super";
    assertTrue(comment.getText().contains(expectedInText));
  }

  @Test
  void getMedicine() {
    String expectedMedicineName = "painkiller";
    assertEquals(comment.getMedicine().getName(), expectedMedicineName);
  }
}
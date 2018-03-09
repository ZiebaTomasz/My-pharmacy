package com.tomek.service;

import com.tomek.domain.Comment;
import com.tomek.domain.Medicine;
import com.tomek.repository.CommentRepository;
import com.tomek.repository.MedicineRepository;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CommentService {

  CommentRepository commentRepository;
//  MedicineRepository medicineRepository;

  @Autowired
  public CommentService(CommentRepository commentRepository

//      ,MedicineRepository medicineRepository
  ) {
    this.commentRepository = commentRepository;
//    this.medicineRepository = medicineRepository;
  }

  public List<Comment> allComments(){
    return (List<Comment>) commentRepository.findAll();
  }

  public List<Comment> commentByMedicine(Medicine medicine){

    Iterable<Comment> commentIterable = commentRepository.findAll();

    List<Comment> commentList = StreamSupport.stream(commentIterable.spliterator(),false)
        .filter(comment -> comment.getMedicine().getId().equals(medicine.getId()))
        .collect(Collectors.toList());

    return commentList;
  }
}

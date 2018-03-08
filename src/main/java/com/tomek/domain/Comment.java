package com.tomek.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
@Entity
public class Comment {

  @Id
  @GeneratedValue
  private Long id;

  @Lob
  private String text;

  @ManyToOne
  @NotBlank
  private Medicine medicine;

  public Comment(){}
}

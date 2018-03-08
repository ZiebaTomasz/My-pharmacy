package com.tomek.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@Data
@Entity
public class Medicine {

  @Id
  @GeneratedValue
  private Long id;

  @NotBlank
  @Size(min = 2, max = 120)
  private String name;

  @NotBlank
  private String brand;

  @Lob
  private String description;

  @Positive
  private double cost;

  @Positive
  @Max(120)
  private int numberOfServings;

  @Temporal(TemporalType.TIMESTAMP)
  @JsonFormat(pattern = "MM/dd/yyyy")
  private Date addedAt;

  public Medicine(){

  }

}

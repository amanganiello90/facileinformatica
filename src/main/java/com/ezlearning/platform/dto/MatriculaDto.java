package com.ezlearning.platform.dto;

import com.ezlearning.platform.auth.User;
import com.ezlearning.platform.model.Curso;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MatriculaDto {
  @DateTimeFormat(
      pattern = "yyyy-MM-dd")
  private Date fecha;
  private User user;
  private Curso curso;
  
  public Date getFecha() {
    return fecha;
  }
  
  public void setFecha(Date fecha) {
    this.fecha = fecha;
  }
  
  public User getUser() {
    return user;
  }
  
  public void setUser(User user) {
    this.user = user;
  }
  
  public Curso getCurso() {
    return curso;
  }
  
  public void setCurso(Curso curso) {
    this.curso = curso;
  }
  
}

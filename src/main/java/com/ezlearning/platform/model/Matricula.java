package com.ezlearning.platform.model;

import com.ezlearning.platform.auth.User;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(
    name = "matricula")
public class Matricula {
  @Id
  @Column(
      name = "matricula_id")
  @GeneratedValue(
      strategy = GenerationType.IDENTITY)
  private Long id_matricula;
  
  @Column(
      name = "fecha")
  private LocalDate fecha_matricula;
  
  @OneToOne(
      fetch = FetchType.LAZY,
      optional = false)
  @JoinColumn(
      name = "user_id",
      nullable = false)
  private User usuario;
  
  @OneToOne(
      fetch = FetchType.LAZY,
      optional = false)
  @JoinColumn(
      name = "curso_id",
      nullable = false)
  private Curso curso;
  
  public Matricula(LocalDate fecha_matricula, User usuario, Curso curso) {
    this.fecha_matricula = fecha_matricula;
    this.usuario = usuario;
    this.curso = curso;
  }
  
  public Matricula() {
  }
  
  public Long getId_matricula() {
    return id_matricula;
  }
  
  public void setId_matricula(Long id_matricula) {
    this.id_matricula = id_matricula;
  }
  
  public LocalDate getFecha_matricula() {
    return fecha_matricula;
  }
  
  public void setFecha_matricula(LocalDate fecha_matricula) {
    this.fecha_matricula = fecha_matricula;
  }
  
  public User getUsuario() {
    return usuario;
  }
  
  public void setUsuario(User usuario) {
    this.usuario = usuario;
  }
  
  public Curso getCurso() {
    return curso;
  }
  
  public void setCurso(Curso curso) {
    this.curso = curso;
  }
}

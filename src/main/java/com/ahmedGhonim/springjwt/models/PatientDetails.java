package com.ahmedGhonim.springjwt.models;

import org.hibernate.annotations.Where;

import javax.persistence.*;
/**
 * @author Ghonim
 */
@Entity
@Table(name="patients")
@Where(clause="active=true")
public class PatientDetails extends BaseEntity{
  @Id
  @Column(name="id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  private Long id;

  @Column(name="full_name")
  private String fullPatientName;

  @Column(name="address")
  private String Address;

  @Column(name="phone_number")
  private String phoneNumber;

  @Column(name="disease_description")
  private String diseaseDescription;

  @Column(name="treatment")
  private String treatment;

  @Column(name="notes")
  private String notes;

  public PatientDetails() {
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getFullPatientName() {
    return fullPatientName;
  }

  public void setFullPatientName(String fullPatientName) {
    this.fullPatientName = fullPatientName;
  }

  public String getAddress() {
    return Address;
  }

  public void setAddress(String address) {
    Address = address;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getDiseaseDescription() {
    return diseaseDescription;
  }

  public void setDiseaseDescription(String diseaseDescription) {
    this.diseaseDescription = diseaseDescription;
  }

  public String getTreatment() {
    return treatment;
  }

  public void setTreatment(String treatment) {
    this.treatment = treatment;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

}

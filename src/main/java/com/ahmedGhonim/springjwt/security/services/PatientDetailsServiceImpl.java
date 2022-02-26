package com.ahmedGhonim.springjwt.security.services;

import com.ahmedGhonim.springjwt.models.PatientDetails;
import com.ahmedGhonim.springjwt.repository.PatientDetailsRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class PatientDetailsServiceImpl  {

  private PatientDetailsRepository patientDetailsRepository;

  public PatientDetailsServiceImpl(PatientDetailsRepository patientDetailsRepository) {
    this.patientDetailsRepository = patientDetailsRepository;
  }


  public List<PatientDetails> getAllPatientDetails() {
    return patientDetailsRepository.findAll();
  }


  public void deletePatientDetails(long id) {
    patientDetailsRepository.delete(id);
  }


  public List<PatientDetails> findByFullPatientDetailsName(String fullPatientDetailsName) {
    return patientDetailsRepository.findByFullPatientName(fullPatientDetailsName);
  }


  public Optional<PatientDetails> getPatientById(long id) {
    return patientDetailsRepository.findById(id);
  }


  public PatientDetails update(long id, PatientDetails patientDetails) {
    if (patientDetailsRepository.findById(id).isPresent()){
      PatientDetails patientDetails1=patientDetailsRepository.findById(id).get();
      patientDetails1.setFullPatientName(patientDetails.getFullPatientName());
      patientDetails1.setPhoneNumber(patientDetails.getPhoneNumber());
      patientDetails1.setAddress(patientDetails.getAddress());
      patientDetails1.setDiseaseDescription(patientDetails.getDiseaseDescription());
      patientDetails1.setNotes(patientDetails.getNotes());
      patientDetails1.setTreatment(patientDetails.getTreatment());
      patientDetails1.setCreatedDate(new Date());
      return patientDetailsRepository.save(patientDetails1);
    }return null;

  }


  public void save(PatientDetails patientDetails) {
    patientDetailsRepository.save(patientDetails);
  }
}

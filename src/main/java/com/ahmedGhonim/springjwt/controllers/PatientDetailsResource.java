package com.ahmedGhonim.springjwt.controllers;

import com.ahmedGhonim.springjwt.exception.ResourceNotFoundException;
import com.ahmedGhonim.springjwt.models.PatientDetails;
import com.ahmedGhonim.springjwt.models.User;
import com.ahmedGhonim.springjwt.response.SuccessResponse;
import com.ahmedGhonim.springjwt.security.services.PatientDetailsServiceImpl;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Ghonim
 */
@RestController
@RequestMapping("/api/v1/patient")
public class PatientDetailsResource {

  PatientDetailsServiceImpl patientDetailsService;

  public PatientDetailsResource(PatientDetailsServiceImpl patientDetailsService) {
    this.patientDetailsService = patientDetailsService;
  }

  @RequestMapping(value = "/patients", method = RequestMethod.GET)
  @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
  public List<PatientDetails> getAlbums() {
    return patientDetailsService.getAllPatientDetails();
  }

  @RequestMapping(value = "/{id}", method = RequestMethod.GET)
  @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
  public SuccessResponse<PatientDetails> getById(@PathVariable(name = "id") long id) {
    PatientDetails patientDetails = patientDetailsService.getPatientById(id).
        orElseThrow(() -> new ResourceNotFoundException(User.class, String.valueOf(id)));
    return new SuccessResponse<>(patientDetails);
  }

  @RequestMapping(value = "/delete/{id}", method = RequestMethod.PUT)
  @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
  public void deleteById(@PathVariable(name = "id") long id) {
    PatientDetails patientDetails = patientDetailsService.getPatientById(id).orElseThrow(() -> new ResourceNotFoundException(User.class, String.valueOf(id)));
    patientDetailsService.deletePatientDetails(id);
  }

  @PutMapping(value = "update/{id}")
  @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
  public SuccessResponse<PatientDetails> updateById(@PathVariable("id") long id,@RequestBody PatientDetails patientDetails){
    patientDetailsService.getPatientById(id).orElseThrow(() -> new ResourceNotFoundException(User.class, String.valueOf(id)));
    return new SuccessResponse<>(patientDetailsService.update(id,patientDetails));
  }

  @RequestMapping(value = "/add", method = RequestMethod.POST)
  @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
  public void save(@RequestBody PatientDetails patientDetails) {
    patientDetailsService.save(patientDetails);
  }

  @RequestMapping(method = RequestMethod.GET, value = "/get-by-full-name/{fullPatientDetailsName}}")
  @PreAuthorize("hasRole('MODERATOR') or hasRole('ADMIN')")
  public SuccessResponse<List<PatientDetails>> getBySinger(@PathVariable("fullPatientDetailsName") String fullPatientDetailsName) {
    return new SuccessResponse<>(patientDetailsService.findByFullPatientDetailsName(fullPatientDetailsName));
  }
}

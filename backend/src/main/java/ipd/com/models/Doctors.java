/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ipd.com.models;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;

/**
 *
 * @author adity
 */
@Entity
@Table(name = "doctors")
@NamedQueries({
    @NamedQuery(name = "Doctors.findAll", query = "SELECT d FROM Doctors d"),
    @NamedQuery(name = "Doctors.findByDoctorId", query = "SELECT d FROM Doctors d WHERE d.doctorId = :doctorId"),
    @NamedQuery(name = "Doctors.findByFirstName", query = "SELECT d FROM Doctors d WHERE d.firstName = :firstName"),
    @NamedQuery(name = "Doctors.findByLastName", query = "SELECT d FROM Doctors d WHERE d.lastName = :lastName"),
    @NamedQuery(name = "Doctors.findBySpecialization", query = "SELECT d FROM Doctors d WHERE d.specialization = :specialization"),
    @NamedQuery(name = "Doctors.findByLicenseNumber", query = "SELECT d FROM Doctors d WHERE d.licenseNumber = :licenseNumber"),
    @NamedQuery(name = "Doctors.findByContactNumber", query = "SELECT d FROM Doctors d WHERE d.contactNumber = :contactNumber"),
    @NamedQuery(name = "Doctors.findByEmail", query = "SELECT d FROM Doctors d WHERE d.email = :email"),
    @NamedQuery(name = "Doctors.findByHireDate", query = "SELECT d FROM Doctors d WHERE d.hireDate = :hireDate"),
    @NamedQuery(name = "Doctors.findByIsActive", query = "SELECT d FROM Doctors d WHERE d.isActive = :isActive")})
public class Doctors implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "doctor_id")
    private Integer doctorId;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "specialization")
    private String specialization;
    @Basic(optional = false)
    @Column(name = "license_number")
    private String licenseNumber;
    @Basic(optional = false)
    @Column(name = "contact_number")
    private String contactNumber;
    @Basic(optional = false)
    @Column(name = "email")
    private String email;
    @Basic(optional = false)
    @Column(name = "hire_date")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Basic(optional = false)
    @Column(name = "is_active")
    private boolean isActive;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "admittingDoctorId")
    private Collection<Admissions> admissionsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "recordedByDoctorId")
    private Collection<Medicalrecords> medicalrecordsCollection;

    public Doctors() {
    }

    public Doctors(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Doctors(Integer doctorId, String firstName, String lastName, String specialization, String licenseNumber, String contactNumber, String email, Date hireDate, boolean isActive) {
        this.doctorId = doctorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.specialization = specialization;
        this.licenseNumber = licenseNumber;
        this.contactNumber = contactNumber;
        this.email = email;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(String licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Collection<Admissions> getAdmissionsCollection() {
        return admissionsCollection;
    }

    public void setAdmissionsCollection(Collection<Admissions> admissionsCollection) {
        this.admissionsCollection = admissionsCollection;
    }

    public Collection<Medicalrecords> getMedicalrecordsCollection() {
        return medicalrecordsCollection;
    }

    public void setMedicalrecordsCollection(Collection<Medicalrecords> medicalrecordsCollection) {
        this.medicalrecordsCollection = medicalrecordsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (doctorId != null ? doctorId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Doctors)) {
            return false;
        }
        Doctors other = (Doctors) object;
        if ((this.doctorId == null && other.doctorId != null) || (this.doctorId != null && !this.doctorId.equals(other.doctorId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Doctors[ doctorId=" + doctorId + " ]";
    }
    
}

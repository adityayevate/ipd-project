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
import jakarta.persistence.Lob;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
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
@Table(name = "patients")
@NamedQueries({
    @NamedQuery(name = "Patients.findAll", query = "SELECT p FROM Patients p"),
    @NamedQuery(name = "Patients.findByPatientId", query = "SELECT p FROM Patients p WHERE p.patientId = :patientId"),
    @NamedQuery(name = "Patients.findByFirstName", query = "SELECT p FROM Patients p WHERE p.firstName = :firstName"),
    @NamedQuery(name = "Patients.findByLastName", query = "SELECT p FROM Patients p WHERE p.lastName = :lastName"),
    @NamedQuery(name = "Patients.findByDateOfBirth", query = "SELECT p FROM Patients p WHERE p.dateOfBirth = :dateOfBirth"),
    @NamedQuery(name = "Patients.findByGender", query = "SELECT p FROM Patients p WHERE p.gender = :gender"),
    @NamedQuery(name = "Patients.findByBloodGroup", query = "SELECT p FROM Patients p WHERE p.bloodGroup = :bloodGroup"),
    @NamedQuery(name = "Patients.findByContactNumber", query = "SELECT p FROM Patients p WHERE p.contactNumber = :contactNumber"),
    @NamedQuery(name = "Patients.findByEmail", query = "SELECT p FROM Patients p WHERE p.email = :email"),
    @NamedQuery(name = "Patients.findByCity", query = "SELECT p FROM Patients p WHERE p.city = :city"),
    @NamedQuery(name = "Patients.findByState", query = "SELECT p FROM Patients p WHERE p.state = :state"),
    @NamedQuery(name = "Patients.findByPostalCode", query = "SELECT p FROM Patients p WHERE p.postalCode = :postalCode"),
    @NamedQuery(name = "Patients.findByEmergencyContactName", query = "SELECT p FROM Patients p WHERE p.emergencyContactName = :emergencyContactName"),
    @NamedQuery(name = "Patients.findByEmergencyContactRelation", query = "SELECT p FROM Patients p WHERE p.emergencyContactRelation = :emergencyContactRelation"),
    @NamedQuery(name = "Patients.findByEmergencyContactNumber", query = "SELECT p FROM Patients p WHERE p.emergencyContactNumber = :emergencyContactNumber"),
    @NamedQuery(name = "Patients.findByRegistrationDate", query = "SELECT p FROM Patients p WHERE p.registrationDate = :registrationDate")})
public class Patients implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "patient_id")
    private Integer patientId;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
    @Basic(optional = false)
    @Column(name = "date_of_birth")
    @Temporal(TemporalType.DATE)
    private Date dateOfBirth;
    @Basic(optional = false)
    @Column(name = "gender")
    private String gender;
    @Column(name = "blood_group")
    private String bloodGroup;
    @Basic(optional = false)
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "email")
    private String email;
    @Lob
    @Column(name = "address")
    private String address;
    @Column(name = "city")
    private String city;
    @Column(name = "state")
    private String state;
    @Column(name = "postal_code")
    private String postalCode;
    @Basic(optional = false)
    @Column(name = "emergency_contact_name")
    private String emergencyContactName;
    @Basic(optional = false)
    @Column(name = "emergency_contact_relation")
    private String emergencyContactRelation;
    @Basic(optional = false)
    @Column(name = "emergency_contact_number")
    private String emergencyContactNumber;
    @Basic(optional = false)
    @Column(name = "registration_date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date registrationDate;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Collection<Admissions> admissionsCollection;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "patientId")
    private Insurancedetails insurancedetails;

    public Patients() {
    }

    public Patients(Integer patientId) {
        this.patientId = patientId;
    }

    public Patients(Integer patientId, String firstName, String lastName, Date dateOfBirth, String gender, String contactNumber, String emergencyContactName, String emergencyContactRelation, String emergencyContactNumber, Date registrationDate) {
        this.patientId = patientId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.gender = gender;
        this.contactNumber = contactNumber;
        this.emergencyContactName = emergencyContactName;
        this.emergencyContactRelation = emergencyContactRelation;
        this.emergencyContactNumber = emergencyContactNumber;
        this.registrationDate = registrationDate;
    }

    public Integer getPatientId() {
        return patientId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
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

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getEmergencyContactName() {
        return emergencyContactName;
    }

    public void setEmergencyContactName(String emergencyContactName) {
        this.emergencyContactName = emergencyContactName;
    }

    public String getEmergencyContactRelation() {
        return emergencyContactRelation;
    }

    public void setEmergencyContactRelation(String emergencyContactRelation) {
        this.emergencyContactRelation = emergencyContactRelation;
    }

    public String getEmergencyContactNumber() {
        return emergencyContactNumber;
    }

    public void setEmergencyContactNumber(String emergencyContactNumber) {
        this.emergencyContactNumber = emergencyContactNumber;
    }

    public Date getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Collection<Admissions> getAdmissionsCollection() {
        return admissionsCollection;
    }

    public void setAdmissionsCollection(Collection<Admissions> admissionsCollection) {
        this.admissionsCollection = admissionsCollection;
    }

    public Insurancedetails getInsurancedetails() {
        return insurancedetails;
    }

    public void setInsurancedetails(Insurancedetails insurancedetails) {
        this.insurancedetails = insurancedetails;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (patientId != null ? patientId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Patients)) {
            return false;
        }
        Patients other = (Patients) object;
        if ((this.patientId == null && other.patientId != null) || (this.patientId != null && !this.patientId.equals(other.patientId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Patients[ patientId=" + patientId + " ]";
    }
    
}

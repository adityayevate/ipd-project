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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "staff")
@NamedQueries({
    @NamedQuery(name = "Staff.findAll", query = "SELECT s FROM Staff s"),
    @NamedQuery(name = "Staff.findByStaffId", query = "SELECT s FROM Staff s WHERE s.staffId = :staffId"),
    @NamedQuery(name = "Staff.findByFirstName", query = "SELECT s FROM Staff s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Staff.findByLastName", query = "SELECT s FROM Staff s WHERE s.lastName = :lastName"),
    @NamedQuery(name = "Staff.findByContactNumber", query = "SELECT s FROM Staff s WHERE s.contactNumber = :contactNumber"),
    @NamedQuery(name = "Staff.findByEmail", query = "SELECT s FROM Staff s WHERE s.email = :email"),
    @NamedQuery(name = "Staff.findByHireDate", query = "SELECT s FROM Staff s WHERE s.hireDate = :hireDate"),
    @NamedQuery(name = "Staff.findByIsActive", query = "SELECT s FROM Staff s WHERE s.isActive = :isActive")})
public class Staff implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "staff_id")
    private Integer staffId;
    @Basic(optional = false)
    @Column(name = "first_name")
    private String firstName;
    @Basic(optional = false)
    @Column(name = "last_name")
    private String lastName;
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
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    @ManyToOne(optional = false)
    private Roles roleId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orderedByStaffId")
    private Collection<Labtestresults> labtestresultsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dischargingStaffId")
    private Collection<Dischargesummary> dischargesummaryCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "staffId")
    private Collection<Prescriptions> prescriptionsCollection;

    public Staff() {
    }

    public Staff(Integer staffId) {
        this.staffId = staffId;
    }

    public Staff(Integer staffId, String firstName, String lastName, String contactNumber, String email, Date hireDate, boolean isActive) {
        this.staffId = staffId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.contactNumber = contactNumber;
        this.email = email;
        this.hireDate = hireDate;
        this.isActive = isActive;
    }

    public Integer getStaffId() {
        return staffId;
    }

    public void setStaffId(Integer staffId) {
        this.staffId = staffId;
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

    public Roles getRoleId() {
        return roleId;
    }

    public void setRoleId(Roles roleId) {
        this.roleId = roleId;
    }

    public Collection<Labtestresults> getLabtestresultsCollection() {
        return labtestresultsCollection;
    }

    public void setLabtestresultsCollection(Collection<Labtestresults> labtestresultsCollection) {
        this.labtestresultsCollection = labtestresultsCollection;
    }

    public Collection<Dischargesummary> getDischargesummaryCollection() {
        return dischargesummaryCollection;
    }

    public void setDischargesummaryCollection(Collection<Dischargesummary> dischargesummaryCollection) {
        this.dischargesummaryCollection = dischargesummaryCollection;
    }

    public Collection<Prescriptions> getPrescriptionsCollection() {
        return prescriptionsCollection;
    }

    public void setPrescriptionsCollection(Collection<Prescriptions> prescriptionsCollection) {
        this.prescriptionsCollection = prescriptionsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (staffId != null ? staffId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Staff)) {
            return false;
        }
        Staff other = (Staff) object;
        if ((this.staffId == null && other.staffId != null) || (this.staffId != null && !this.staffId.equals(other.staffId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Staff[ staffId=" + staffId + " ]";
    }
    
}

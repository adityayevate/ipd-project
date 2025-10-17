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
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;

/**
 *
 * @author adity
 */
@Entity
@Table(name = "labtests")
@NamedQueries({
    @NamedQuery(name = "Labtests.findAll", query = "SELECT l FROM Labtests l"),
    @NamedQuery(name = "Labtests.findByTestId", query = "SELECT l FROM Labtests l WHERE l.testId = :testId"),
    @NamedQuery(name = "Labtests.findByTestName", query = "SELECT l FROM Labtests l WHERE l.testName = :testName"),
    @NamedQuery(name = "Labtests.findByDepartment", query = "SELECT l FROM Labtests l WHERE l.department = :department"),
    @NamedQuery(name = "Labtests.findByNormalRange", query = "SELECT l FROM Labtests l WHERE l.normalRange = :normalRange"),
    @NamedQuery(name = "Labtests.findByCost", query = "SELECT l FROM Labtests l WHERE l.cost = :cost")})
public class Labtests implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "test_id")
    private Integer testId;
    @Basic(optional = false)
    @Column(name = "test_name")
    private String testName;
    @Basic(optional = false)
    @Column(name = "department")
    private String department;
    @Column(name = "normal_range")
    private String normalRange;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "cost")
    private BigDecimal cost;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testId")
    private Collection<Labtestresults> labtestresultsCollection;

    public Labtests() {
    }

    public Labtests(Integer testId) {
        this.testId = testId;
    }

    public Labtests(Integer testId, String testName, String department, BigDecimal cost) {
        this.testId = testId;
        this.testName = testName;
        this.department = department;
        this.cost = cost;
    }

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getNormalRange() {
        return normalRange;
    }

    public void setNormalRange(String normalRange) {
        this.normalRange = normalRange;
    }

    public BigDecimal getCost() {
        return cost;
    }

    public void setCost(BigDecimal cost) {
        this.cost = cost;
    }

    public Collection<Labtestresults> getLabtestresultsCollection() {
        return labtestresultsCollection;
    }

    public void setLabtestresultsCollection(Collection<Labtestresults> labtestresultsCollection) {
        this.labtestresultsCollection = labtestresultsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (testId != null ? testId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Labtests)) {
            return false;
        }
        Labtests other = (Labtests) object;
        if ((this.testId == null && other.testId != null) || (this.testId != null && !this.testId.equals(other.testId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ipd.com.models.Labtests[ testId=" + testId + " ]";
    }
    
}

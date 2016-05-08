/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gym;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

/**
 *
 * @author Shan Wijenayaka
 */
@Entity
@Table(name = "memberdetails", catalog = "gymdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Memberdetails.findAll", query = "SELECT m FROM Memberdetails m"),
    @NamedQuery(name = "Memberdetails.findById", query = "SELECT m FROM Memberdetails m WHERE m.id = :id"),
    @NamedQuery(name = "Memberdetails.findByName", query = "SELECT m FROM Memberdetails m WHERE m.name = :name"),
    @NamedQuery(name = "Memberdetails.findByContactNumber", query = "SELECT m FROM Memberdetails m WHERE m.contactNumber = :contactNumber"),
    @NamedQuery(name = "Memberdetails.findByAddress", query = "SELECT m FROM Memberdetails m WHERE m.address = :address"),
    @NamedQuery(name = "Memberdetails.findByRegisteredOn", query = "SELECT m FROM Memberdetails m WHERE m.registeredOn = :registeredOn"),
    @NamedQuery(name = "Memberdetails.findByRegisteredBy", query = "SELECT m FROM Memberdetails m WHERE m.registeredBy = :registeredBy")})
public class Memberdetails implements Serializable {
    
    
    public class MyThread implements Runnable{

       @Override
        public void run() {
            
        }
        
    }
    
    
    
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "contact_number")
    private String contactNumber;
    @Column(name = "address")
    private String address;
    @Column(name = "registered_on")
    @Temporal(TemporalType.DATE)
    private Date registeredOn;
    @Column(name = "registered_by")
    private String registeredBy;

    public Memberdetails() {
    }

    public Memberdetails(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        String oldName = this.name;
        this.name = name;
        changeSupport.firePropertyChange("name", oldName, name);
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        String oldContactNumber = this.contactNumber;
        this.contactNumber = contactNumber;
        changeSupport.firePropertyChange("contactNumber", oldContactNumber, contactNumber);
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        String oldAddress = this.address;
        this.address = address;
        changeSupport.firePropertyChange("address", oldAddress, address);
    }

    public Date getRegisteredOn() {
        return registeredOn;
    }

    public void setRegisteredOn(Date registeredOn) {
        Date oldRegisteredOn = this.registeredOn;
        this.registeredOn = registeredOn;
        changeSupport.firePropertyChange("registeredOn", oldRegisteredOn, registeredOn);
    }

    public String getRegisteredBy() {
        return registeredBy;
    }

    public void setRegisteredBy(String registeredBy) {
        String oldRegisteredBy = this.registeredBy;
        this.registeredBy = registeredBy;
        changeSupport.firePropertyChange("registeredBy", oldRegisteredBy, registeredBy);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Memberdetails)) {
            return false;
        }
        Memberdetails other = (Memberdetails) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gym.Memberdetails[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

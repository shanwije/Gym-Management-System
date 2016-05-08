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
@Table(name = "pay", catalog = "gymdb", schema = "")
@NamedQueries({
    @NamedQuery(name = "Pay.findAll", query = "SELECT p FROM Pay p"),
    @NamedQuery(name = "Pay.findById", query = "SELECT p FROM Pay p WHERE p.id = :id"),
    @NamedQuery(name = "Pay.findByCount", query = "SELECT p FROM Pay p WHERE p.count = :count"),
    @NamedQuery(name = "Pay.findByReciptNo", query = "SELECT p FROM Pay p WHERE p.reciptNo = :reciptNo"),
    @NamedQuery(name = "Pay.findByPayment", query = "SELECT p FROM Pay p WHERE p.payment = :payment"),
    @NamedQuery(name = "Pay.findByDate", query = "SELECT p FROM Pay p WHERE p.date = :date"),
    @NamedQuery(name = "Pay.findByAddedBy", query = "SELECT p FROM Pay p WHERE p.addedBy = :addedBy")})
public class Pay implements Serializable {
    @Transient
    private PropertyChangeSupport changeSupport = new PropertyChangeSupport(this);
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "count")
    private int count;
    @Column(name = "reciptNo")
    private String reciptNo;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "payment")
    private Double payment;
    @Basic(optional = false)
    @Column(name = "date")
    @Temporal(TemporalType.DATE)
    private Date date;
    @Column(name = "added_by")
    private String addedBy;

    public Pay() {
    }

    public Pay(Integer id) {
        this.id = id;
    }

    public Pay(Integer id, int count, Date date) {
        this.id = id;
        this.count = count;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        Integer oldId = this.id;
        this.id = id;
        changeSupport.firePropertyChange("id", oldId, id);
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        int oldCount = this.count;
        this.count = count;
        changeSupport.firePropertyChange("count", oldCount, count);
    }

    public String getReciptNo() {
        return reciptNo;
    }

    public void setReciptNo(String reciptNo) {
        String oldReciptNo = this.reciptNo;
        this.reciptNo = reciptNo;
        changeSupport.firePropertyChange("reciptNo", oldReciptNo, reciptNo);
    }

    public Double getPayment() {
        return payment;
    }

    public void setPayment(Double payment) {
        Double oldPayment = this.payment;
        this.payment = payment;
        changeSupport.firePropertyChange("payment", oldPayment, payment);
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        Date oldDate = this.date;
        this.date = date;
        changeSupport.firePropertyChange("date", oldDate, date);
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        String oldAddedBy = this.addedBy;
        this.addedBy = addedBy;
        changeSupport.firePropertyChange("addedBy", oldAddedBy, addedBy);
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
        if (!(object instanceof Pay)) {
            return false;
        }
        Pay other = (Pay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "gym.Pay[ id=" + id + " ]";
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.addPropertyChangeListener(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        changeSupport.removePropertyChangeListener(listener);
    }
    
}

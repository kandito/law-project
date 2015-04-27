/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kandito Agung
 */
@Entity
@Table(name = "kategori")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Kategori.findAll", query = "SELECT k FROM Kategori k"),
    @NamedQuery(name = "Kategori.findByIdKategori", query = "SELECT k FROM Kategori k WHERE k.idKategori = :idKategori"),
    @NamedQuery(name = "Kategori.findByNama", query = "SELECT k FROM Kategori k WHERE k.nama = :nama")})
public class Kategori implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_kategori")
    private Integer idKategori;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idKategori")
    private Collection<Alat> alatCollection;

    public Kategori() {
    }

    public Kategori(Integer idKategori) {
        this.idKategori = idKategori;
    }

    public Kategori(Integer idKategori, String nama) {
        this.idKategori = idKategori;
        this.nama = nama;
    }

    public Integer getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(Integer idKategori) {
        this.idKategori = idKategori;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    @XmlTransient
    public Collection<Alat> getAlatCollection() {
        return alatCollection;
    }

    public void setAlatCollection(Collection<Alat> alatCollection) {
        this.alatCollection = alatCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idKategori != null ? idKategori.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Kategori)) {
            return false;
        }
        Kategori other = (Kategori) object;
        if ((this.idKategori == null && other.idKategori != null) || (this.idKategori != null && !this.idKategori.equals(other.idKategori))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Kategori[ idKategori=" + idKategori + " ]";
    }
    
}

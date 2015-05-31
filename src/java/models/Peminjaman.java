/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kandito Agung
 */
@Entity
@Table(name = "peminjaman")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Peminjaman.findAll", query = "SELECT p FROM Peminjaman p"),
    @NamedQuery(name = "Peminjaman.findByIdPeminjaman", query = "SELECT p FROM Peminjaman p WHERE p.idPeminjaman = :idPeminjaman"),
    @NamedQuery(name = "Peminjaman.findByTotalBiaya", query = "SELECT p FROM Peminjaman p WHERE p.totalBiaya = :totalBiaya"),
    @NamedQuery(name = "Peminjaman.findByTanggalPinjam", query = "SELECT p FROM Peminjaman p WHERE p.tanggalPinjam = :tanggalPinjam"),
    @NamedQuery(name = "Peminjaman.findByTanggalBalik", query = "SELECT p FROM Peminjaman p WHERE p.tanggalBalik = :tanggalBalik"),
    @NamedQuery(name = "Peminjaman.findByStatus", query = "SELECT p FROM Peminjaman p WHERE p.status = :status"),
    @NamedQuery(name = "Peminjaman.findByIdAdmin", query = "SELECT p FROM Peminjaman p WHERE p.idAdmin = :idAdmin")})
public class Peminjaman implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_peminjaman")
    private Integer idPeminjaman;
    @Basic(optional = false)
    @Column(name = "total_biaya")
    private long totalBiaya;
    @Basic(optional = false)
    @Lob
    @Column(name = "keterangan")
    private String keterangan;
    @Basic(optional = false)
    @Column(name = "tanggal_pinjam")
    @Temporal(TemporalType.DATE)
    private Date tanggalPinjam;
    @Basic(optional = false)
    @Column(name = "tanggal_balik")
    @Temporal(TemporalType.DATE)
    private Date tanggalBalik;
    @Basic(optional = false)
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @Column(name = "id_admin")
    private int idAdmin;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idPeminjaman")
    private Collection<PeminjamanItem> peminjamanItemCollection;
    @JoinColumn(name = "id_user", referencedColumnName = "id_user")
    @ManyToOne(optional = false)
    private User idUser;

    public Peminjaman() {
    }

    public Peminjaman(Integer idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public Peminjaman(Integer idPeminjaman, long totalBiaya, String keterangan, Date tanggalPinjam, Date tanggalBalik, int status, int idAdmin) {
        this.idPeminjaman = idPeminjaman;
        this.totalBiaya = totalBiaya;
        this.keterangan = keterangan;
        this.tanggalPinjam = tanggalPinjam;
        this.tanggalBalik = tanggalBalik;
        this.status = status;
        this.idAdmin = idAdmin;
    }

    public Integer getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(Integer idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public long getTotalBiaya() {
        return totalBiaya;
    }

    public void setTotalBiaya(long totalBiaya) {
        this.totalBiaya = totalBiaya;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public Date getTanggalPinjam() {
        return tanggalPinjam;
    }

    public void setTanggalPinjam(Date tanggalPinjam) {
        this.tanggalPinjam = tanggalPinjam;
    }

    public Date getTanggalBalik() {
        return tanggalBalik;
    }

    public void setTanggalBalik(Date tanggalBalik) {
        this.tanggalBalik = tanggalBalik;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(int idAdmin) {
        this.idAdmin = idAdmin;
    }

    @XmlTransient
    public Collection<PeminjamanItem> getPeminjamanItemCollection() {
        return peminjamanItemCollection;
    }

    public void setPeminjamanItemCollection(Collection<PeminjamanItem> peminjamanItemCollection) {
        this.peminjamanItemCollection = peminjamanItemCollection;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeminjaman != null ? idPeminjaman.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Peminjaman)) {
            return false;
        }
        Peminjaman other = (Peminjaman) object;
        if ((this.idPeminjaman == null && other.idPeminjaman != null) || (this.idPeminjaman != null && !this.idPeminjaman.equals(other.idPeminjaman))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Peminjaman[ idPeminjaman=" + idPeminjaman + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package models;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Kandito Agung
 */
@Entity
@Table(name = "peminjaman_item")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PeminjamanItem.findAll", query = "SELECT p FROM PeminjamanItem p"),
    @NamedQuery(name = "PeminjamanItem.findByIdPeminjamanItem", query = "SELECT p FROM PeminjamanItem p WHERE p.idPeminjamanItem = :idPeminjamanItem"),
    @NamedQuery(name = "PeminjamanItem.findByKeterangan", query = "SELECT p FROM PeminjamanItem p WHERE p.keterangan = :keterangan"),
    @NamedQuery(name = "PeminjamanItem.findByJumlah", query = "SELECT p FROM PeminjamanItem p WHERE p.jumlah = :jumlah")})
public class PeminjamanItem implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_peminjaman_item")
    private Integer idPeminjamanItem;
    @Basic(optional = false)
    @Column(name = "keterangan")
    private String keterangan;
    @Basic(optional = false)
    @Column(name = "jumlah")
    private int jumlah;
    @JoinColumn(name = "id_peminjaman", referencedColumnName = "id_peminjaman")
    @ManyToOne(optional = false)
    private Peminjaman idPeminjaman;
    @JoinColumn(name = "id_alat", referencedColumnName = "id_alat")
    @ManyToOne(optional = false)
    private Alat idAlat;

    public PeminjamanItem() {
    }

    public PeminjamanItem(Integer idPeminjamanItem) {
        this.idPeminjamanItem = idPeminjamanItem;
    }

    public PeminjamanItem(Integer idPeminjamanItem, String keterangan, int jumlah) {
        this.idPeminjamanItem = idPeminjamanItem;
        this.keterangan = keterangan;
        this.jumlah = jumlah;
    }

    public Integer getIdPeminjamanItem() {
        return idPeminjamanItem;
    }

    public void setIdPeminjamanItem(Integer idPeminjamanItem) {
        this.idPeminjamanItem = idPeminjamanItem;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    public Peminjaman getIdPeminjaman() {
        return idPeminjaman;
    }

    public void setIdPeminjaman(Peminjaman idPeminjaman) {
        this.idPeminjaman = idPeminjaman;
    }

    public Alat getIdAlat() {
        return idAlat;
    }

    public void setIdAlat(Alat idAlat) {
        this.idAlat = idAlat;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPeminjamanItem != null ? idPeminjamanItem.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PeminjamanItem)) {
            return false;
        }
        PeminjamanItem other = (PeminjamanItem) object;
        if ((this.idPeminjamanItem == null && other.idPeminjamanItem != null) || (this.idPeminjamanItem != null && !this.idPeminjamanItem.equals(other.idPeminjamanItem))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.PeminjamanItem[ idPeminjamanItem=" + idPeminjamanItem + " ]";
    }
    
}

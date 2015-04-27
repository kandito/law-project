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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Kandito Agung
 */
@Entity
@Table(name = "alat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Alat.findAll", query = "SELECT a FROM Alat a"),
    @NamedQuery(name = "Alat.findByIdAlat", query = "SELECT a FROM Alat a WHERE a.idAlat = :idAlat"),
    @NamedQuery(name = "Alat.findByKodeAlat", query = "SELECT a FROM Alat a WHERE a.kodeAlat = :kodeAlat"),
    @NamedQuery(name = "Alat.findByNama", query = "SELECT a FROM Alat a WHERE a.nama = :nama"),
    @NamedQuery(name = "Alat.findByBiaya", query = "SELECT a FROM Alat a WHERE a.biaya = :biaya"),
    @NamedQuery(name = "Alat.findByGambar", query = "SELECT a FROM Alat a WHERE a.gambar = :gambar"),
    @NamedQuery(name = "Alat.findByJumlah", query = "SELECT a FROM Alat a WHERE a.jumlah = :jumlah")})
public class Alat implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_alat")
    private Integer idAlat;
    @Basic(optional = false)
    @Column(name = "kode_alat")
    private String kodeAlat;
    @Basic(optional = false)
    @Column(name = "nama")
    private String nama;
    @Basic(optional = false)
    @Lob
    @Column(name = "spesifikasi")
    private String spesifikasi;
    @Basic(optional = false)
    @Lob
    @Column(name = "keterangan")
    private String keterangan;
    @Basic(optional = false)
    @Column(name = "biaya")
    private long biaya;
    @Basic(optional = false)
    @Column(name = "gambar")
    private String gambar;
    @Basic(optional = false)
    @Column(name = "jumlah")
    private int jumlah;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idAlat")
    private Collection<PeminjamanItem> peminjamanItemCollection;
    @JoinColumn(name = "id_kategori", referencedColumnName = "id_kategori")
    @ManyToOne(optional = false)
    private Kategori idKategori;

    public Alat() {
    }

    public Alat(Integer idAlat) {
        this.idAlat = idAlat;
    }

    public Alat(Integer idAlat, String kodeAlat, String nama, String spesifikasi, String keterangan, long biaya, String gambar, int jumlah) {
        this.idAlat = idAlat;
        this.kodeAlat = kodeAlat;
        this.nama = nama;
        this.spesifikasi = spesifikasi;
        this.keterangan = keterangan;
        this.biaya = biaya;
        this.gambar = gambar;
        this.jumlah = jumlah;
    }

    public Integer getIdAlat() {
        return idAlat;
    }

    public void setIdAlat(Integer idAlat) {
        this.idAlat = idAlat;
    }

    public String getKodeAlat() {
        return kodeAlat;
    }

    public void setKodeAlat(String kodeAlat) {
        this.kodeAlat = kodeAlat;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getSpesifikasi() {
        return spesifikasi;
    }

    public void setSpesifikasi(String spesifikasi) {
        this.spesifikasi = spesifikasi;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public void setKeterangan(String keterangan) {
        this.keterangan = keterangan;
    }

    public long getBiaya() {
        return biaya;
    }

    public void setBiaya(long biaya) {
        this.biaya = biaya;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public int getJumlah() {
        return jumlah;
    }

    public void setJumlah(int jumlah) {
        this.jumlah = jumlah;
    }

    @XmlTransient
    public Collection<PeminjamanItem> getPeminjamanItemCollection() {
        return peminjamanItemCollection;
    }

    public void setPeminjamanItemCollection(Collection<PeminjamanItem> peminjamanItemCollection) {
        this.peminjamanItemCollection = peminjamanItemCollection;
    }

    public Kategori getIdKategori() {
        return idKategori;
    }

    public void setIdKategori(Kategori idKategori) {
        this.idKategori = idKategori;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idAlat != null ? idAlat.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alat)) {
            return false;
        }
        Alat other = (Alat) object;
        if ((this.idAlat == null && other.idAlat != null) || (this.idAlat != null && !this.idAlat.equals(other.idAlat))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "models.Alat[ idAlat=" + idAlat + " ]";
    }
    
}

package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Kategori;
import models.PeminjamanItem;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-28T11:47:42")
@StaticMetamodel(Alat.class)
public class Alat_ { 

    public static volatile SingularAttribute<Alat, Kategori> idKategori;
    public static volatile SingularAttribute<Alat, Integer> jumlahTersedia;
    public static volatile SingularAttribute<Alat, String> keterangan;
    public static volatile CollectionAttribute<Alat, PeminjamanItem> peminjamanItemCollection;
    public static volatile SingularAttribute<Alat, Integer> idAlat;
    public static volatile SingularAttribute<Alat, String> nama;
    public static volatile SingularAttribute<Alat, Long> biaya;
    public static volatile SingularAttribute<Alat, Integer> jumlah;
    public static volatile SingularAttribute<Alat, String> spesifikasi;
    public static volatile SingularAttribute<Alat, String> kodeAlat;
    public static volatile SingularAttribute<Alat, String> gambar;

}
package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Alat;
import models.Peminjaman;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-28T11:47:42")
@StaticMetamodel(PeminjamanItem.class)
public class PeminjamanItem_ { 

    public static volatile SingularAttribute<PeminjamanItem, String> keterangan;
    public static volatile SingularAttribute<PeminjamanItem, Integer> jumlah;
    public static volatile SingularAttribute<PeminjamanItem, Alat> idAlat;
    public static volatile SingularAttribute<PeminjamanItem, Integer> idPeminjamanItem;
    public static volatile SingularAttribute<PeminjamanItem, Peminjaman> idPeminjaman;

}
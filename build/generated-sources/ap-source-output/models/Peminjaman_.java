package models;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.PeminjamanItem;
import models.User;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-28T11:47:42")
@StaticMetamodel(Peminjaman.class)
public class Peminjaman_ { 

    public static volatile SingularAttribute<Peminjaman, User> idUser;
    public static volatile SingularAttribute<Peminjaman, Integer> idAdmin;
    public static volatile SingularAttribute<Peminjaman, String> keterangan;
    public static volatile CollectionAttribute<Peminjaman, PeminjamanItem> peminjamanItemCollection;
    public static volatile SingularAttribute<Peminjaman, Date> tanggalPinjam;
    public static volatile SingularAttribute<Peminjaman, Long> totalBiaya;
    public static volatile SingularAttribute<Peminjaman, Integer> idPeminjaman;
    public static volatile SingularAttribute<Peminjaman, Date> tanggalBalik;
    public static volatile SingularAttribute<Peminjaman, Integer> status;

}
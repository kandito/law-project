package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Peminjaman;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-01T02:22:03")
@StaticMetamodel(User.class)
public class User_ { 

    public static volatile SingularAttribute<User, Integer> idUser;
    public static volatile SingularAttribute<User, String> password;
    public static volatile CollectionAttribute<User, Peminjaman> peminjamanCollection;
    public static volatile SingularAttribute<User, String> organisasi;
    public static volatile SingularAttribute<User, String> nomorTelepon;
    public static volatile SingularAttribute<User, String> namaLengkap;
    public static volatile SingularAttribute<User, String> email;
    public static volatile SingularAttribute<User, String> username;
    public static volatile SingularAttribute<User, String> alamat;

}
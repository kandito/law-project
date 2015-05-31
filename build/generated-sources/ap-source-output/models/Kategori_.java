package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Alat;

@Generated(value="EclipseLink-2.5.0.v20130507-rNA", date="2015-06-01T02:01:32")
@StaticMetamodel(Kategori.class)
public class Kategori_ { 

    public static volatile SingularAttribute<Kategori, Integer> idKategori;
    public static volatile SingularAttribute<Kategori, String> nama;
    public static volatile CollectionAttribute<Kategori, Alat> alatCollection;

}
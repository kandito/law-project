package models;

import javax.annotation.Generated;
import javax.persistence.metamodel.CollectionAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;
import models.Alat;

@Generated(value="EclipseLink-2.5.1.v20130918-rNA", date="2015-04-28T14:06:56")
@StaticMetamodel(Kategori.class)
public class Kategori_ { 

    public static volatile SingularAttribute<Kategori, Integer> idKategori;
    public static volatile SingularAttribute<Kategori, String> nama;
    public static volatile CollectionAttribute<Kategori, Alat> alatCollection;

}
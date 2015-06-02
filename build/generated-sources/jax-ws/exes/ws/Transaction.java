
package exes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for transaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="transaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="amount" type="{http://www.w3.org/2001/XMLSchema}double" minOccurs="0"/>
 *         &lt;element name="deskripsi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idKategori" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="idUser" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="jenis" type="{http://www.w3.org/2001/XMLSchema}int" minOccurs="0"/>
 *         &lt;element name="mataUang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="tglTransaksi" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "transaction", propOrder = {
    "amount",
    "deskripsi",
    "id",
    "idKategori",
    "idUser",
    "jenis",
    "mataUang",
    "tglTransaksi"
})
public class Transaction {

    protected Double amount;
    protected String deskripsi;
    protected Integer id;
    protected Integer idKategori;
    protected Integer idUser;
    protected Integer jenis;
    protected String mataUang;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar tglTransaksi;

    /**
     * Gets the value of the amount property.
     * 
     * @return
     *     possible object is
     *     {@link Double }
     *     
     */
    public Double getAmount() {
        return amount;
    }

    /**
     * Sets the value of the amount property.
     * 
     * @param value
     *     allowed object is
     *     {@link Double }
     *     
     */
    public void setAmount(Double value) {
        this.amount = value;
    }

    /**
     * Gets the value of the deskripsi property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDeskripsi() {
        return deskripsi;
    }

    /**
     * Sets the value of the deskripsi property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDeskripsi(String value) {
        this.deskripsi = value;
    }

    /**
     * Gets the value of the id property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setId(Integer value) {
        this.id = value;
    }

    /**
     * Gets the value of the idKategori property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdKategori() {
        return idKategori;
    }

    /**
     * Sets the value of the idKategori property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdKategori(Integer value) {
        this.idKategori = value;
    }

    /**
     * Gets the value of the idUser property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getIdUser() {
        return idUser;
    }

    /**
     * Sets the value of the idUser property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setIdUser(Integer value) {
        this.idUser = value;
    }

    /**
     * Gets the value of the jenis property.
     * 
     * @return
     *     possible object is
     *     {@link Integer }
     *     
     */
    public Integer getJenis() {
        return jenis;
    }

    /**
     * Sets the value of the jenis property.
     * 
     * @param value
     *     allowed object is
     *     {@link Integer }
     *     
     */
    public void setJenis(Integer value) {
        this.jenis = value;
    }

    /**
     * Gets the value of the mataUang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMataUang() {
        return mataUang;
    }

    /**
     * Sets the value of the mataUang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMataUang(String value) {
        this.mataUang = value;
    }

    /**
     * Gets the value of the tglTransaksi property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getTglTransaksi() {
        return tglTransaksi;
    }

    /**
     * Sets the value of the tglTransaksi property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setTglTransaksi(XMLGregorianCalendar value) {
        this.tglTransaksi = value;
    }

}

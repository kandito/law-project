
package exes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateTransaction complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateTransaction">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="matauang" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nominal" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *         &lt;element name="deskripsi" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCategory" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idJenis" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateTransaction", propOrder = {
    "token",
    "id",
    "matauang",
    "nominal",
    "deskripsi",
    "idCategory",
    "idJenis"
})
public class UpdateTransaction {

    protected String token;
    protected int id;
    protected String matauang;
    protected double nominal;
    protected String deskripsi;
    protected int idCategory;
    protected int idJenis;

    /**
     * Gets the value of the token property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getToken() {
        return token;
    }

    /**
     * Sets the value of the token property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setToken(String value) {
        this.token = value;
    }

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the matauang property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getMatauang() {
        return matauang;
    }

    /**
     * Sets the value of the matauang property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setMatauang(String value) {
        this.matauang = value;
    }

    /**
     * Gets the value of the nominal property.
     * 
     */
    public double getNominal() {
        return nominal;
    }

    /**
     * Sets the value of the nominal property.
     * 
     */
    public void setNominal(double value) {
        this.nominal = value;
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
     * Gets the value of the idCategory property.
     * 
     */
    public int getIdCategory() {
        return idCategory;
    }

    /**
     * Sets the value of the idCategory property.
     * 
     */
    public void setIdCategory(int value) {
        this.idCategory = value;
    }

    /**
     * Gets the value of the idJenis property.
     * 
     */
    public int getIdJenis() {
        return idJenis;
    }

    /**
     * Sets the value of the idJenis property.
     * 
     */
    public void setIdJenis(int value) {
        this.idJenis = value;
    }

}

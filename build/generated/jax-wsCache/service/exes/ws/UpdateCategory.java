
package exes.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for updateCategory complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="updateCategory">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="token" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idCategory" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="idJenis" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nama" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "updateCategory", propOrder = {
    "token",
    "idCategory",
    "idJenis",
    "nama"
})
public class UpdateCategory {

    protected String token;
    protected int idCategory;
    protected int idJenis;
    protected String nama;

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

    /**
     * Gets the value of the nama property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNama() {
        return nama;
    }

    /**
     * Sets the value of the nama property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNama(String value) {
        this.nama = value;
    }

}

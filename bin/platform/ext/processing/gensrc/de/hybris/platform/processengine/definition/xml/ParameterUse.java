//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.11 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.02.07 at 01:36:26 PM BRT 
//


package de.hybris.platform.processengine.definition.xml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for parameterUse.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="parameterUse"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="required"/&gt;
 *     &lt;enumeration value="optional"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "parameterUse")
@XmlEnum
public enum ParameterUse {

    @XmlEnumValue("required")
    REQUIRED("required"),
    @XmlEnumValue("optional")
    OPTIONAL("optional");
    private final String value;

    ParameterUse(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static ParameterUse fromValue(String v) {
        for (ParameterUse c: ParameterUse.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}

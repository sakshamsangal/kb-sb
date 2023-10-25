@jakarta.xml.bind.annotation.XmlSchema(namespace = "urn:books",
        elementFormDefault = XmlNsForm.QUALIFIED,
        xmlns = {
                @XmlNs(prefix = "bks", namespaceURI = "urn:books")
        }
)
package com.app.model.jaxb.books;

import jakarta.xml.bind.annotation.XmlNs;
import jakarta.xml.bind.annotation.XmlNsForm;
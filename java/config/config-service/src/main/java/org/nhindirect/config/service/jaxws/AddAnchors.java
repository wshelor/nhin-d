
package org.nhindirect.config.service.jaxws;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import org.nhindirect.config.store.Anchor;

@XmlRootElement(name = "addAnchor", namespace = "http://nhind.org/config")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "addAnchor", namespace = "http://nhind.org/config")
public class AddAnchors {

    @XmlElement(name = "arg0", namespace = "")
    private List<Anchor> arg0;

    /**
     * 
     * @return
     *     returns List<Anchor>
     */
    public List<Anchor> getArg0() {
        return this.arg0;
    }

    /**
     * 
     * @param arg0
     *     the value for the arg0 property
     */
    public void setArg0(List<Anchor> arg0) {
        this.arg0 = arg0;
    }

}

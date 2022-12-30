
package com.digipay.employee;

import javax.xml.namespace.QName;
import jakarta.xml.bind.JAXBElement;
import jakarta.xml.bind.annotation.XmlElementDecl;
import jakarta.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the com.digipay.employee package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _DisplayPermission_QNAME = new QName("http://controller.digipay.com/", "displayPermission");
    private final static QName _DisplayPermissionResponse_QNAME = new QName("http://controller.digipay.com/", "displayPermissionResponse");
    private final static QName _RemovePermission_QNAME = new QName("http://controller.digipay.com/", "removePermission");
    private final static QName _RemovePermissionResponse_QNAME = new QName("http://controller.digipay.com/", "removePermissionResponse");
    private final static QName _SavePermissionInfo_QNAME = new QName("http://controller.digipay.com/", "savePermissionInfo");
    private final static QName _SavePermissionInfoResponse_QNAME = new QName("http://controller.digipay.com/", "savePermissionInfoResponse");
    private final static QName _UpdatePermission_QNAME = new QName("http://controller.digipay.com/", "updatePermission");
    private final static QName _UpdatePermissionResponse_QNAME = new QName("http://controller.digipay.com/", "updatePermissionResponse");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: com.digipay.employee
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link DisplayPermission }
     * 
     */
    public DisplayPermission createDisplayPermission() {
        return new DisplayPermission();
    }

    /**
     * Create an instance of {@link DisplayPermissionResponse }
     * 
     */
    public DisplayPermissionResponse createDisplayPermissionResponse() {
        return new DisplayPermissionResponse();
    }

    /**
     * Create an instance of {@link RemovePermission }
     * 
     */
    public RemovePermission createRemovePermission() {
        return new RemovePermission();
    }

    /**
     * Create an instance of {@link RemovePermissionResponse }
     * 
     */
    public RemovePermissionResponse createRemovePermissionResponse() {
        return new RemovePermissionResponse();
    }

    /**
     * Create an instance of {@link SavePermissionInfo }
     * 
     */
    public SavePermissionInfo createSavePermissionInfo() {
        return new SavePermissionInfo();
    }

    /**
     * Create an instance of {@link SavePermissionInfoResponse }
     * 
     */
    public SavePermissionInfoResponse createSavePermissionInfoResponse() {
        return new SavePermissionInfoResponse();
    }

    /**
     * Create an instance of {@link UpdatePermission }
     * 
     */
    public UpdatePermission createUpdatePermission() {
        return new UpdatePermission();
    }

    /**
     * Create an instance of {@link UpdatePermissionResponse }
     * 
     */
    public UpdatePermissionResponse createUpdatePermissionResponse() {
        return new UpdatePermissionResponse();
    }

    /**
     * Create an instance of {@link Permission }
     * 
     */
    public Permission createPermission() {
        return new Permission();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayPermission }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DisplayPermission }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.digipay.com/", name = "displayPermission")
    public JAXBElement<DisplayPermission> createDisplayPermission(DisplayPermission value) {
        return new JAXBElement<DisplayPermission>(_DisplayPermission_QNAME, DisplayPermission.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link DisplayPermissionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link DisplayPermissionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.digipay.com/", name = "displayPermissionResponse")
    public JAXBElement<DisplayPermissionResponse> createDisplayPermissionResponse(DisplayPermissionResponse value) {
        return new JAXBElement<DisplayPermissionResponse>(_DisplayPermissionResponse_QNAME, DisplayPermissionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemovePermission }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemovePermission }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.digipay.com/", name = "removePermission")
    public JAXBElement<RemovePermission> createRemovePermission(RemovePermission value) {
        return new JAXBElement<RemovePermission>(_RemovePermission_QNAME, RemovePermission.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link RemovePermissionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link RemovePermissionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.digipay.com/", name = "removePermissionResponse")
    public JAXBElement<RemovePermissionResponse> createRemovePermissionResponse(RemovePermissionResponse value) {
        return new JAXBElement<RemovePermissionResponse>(_RemovePermissionResponse_QNAME, RemovePermissionResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavePermissionInfo }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SavePermissionInfo }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.digipay.com/", name = "savePermissionInfo")
    public JAXBElement<SavePermissionInfo> createSavePermissionInfo(SavePermissionInfo value) {
        return new JAXBElement<SavePermissionInfo>(_SavePermissionInfo_QNAME, SavePermissionInfo.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link SavePermissionInfoResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link SavePermissionInfoResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.digipay.com/", name = "savePermissionInfoResponse")
    public JAXBElement<SavePermissionInfoResponse> createSavePermissionInfoResponse(SavePermissionInfoResponse value) {
        return new JAXBElement<SavePermissionInfoResponse>(_SavePermissionInfoResponse_QNAME, SavePermissionInfoResponse.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePermission }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePermission }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.digipay.com/", name = "updatePermission")
    public JAXBElement<UpdatePermission> createUpdatePermission(UpdatePermission value) {
        return new JAXBElement<UpdatePermission>(_UpdatePermission_QNAME, UpdatePermission.class, null, value);
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link UpdatePermissionResponse }{@code >}
     * 
     * @param value
     *     Java instance representing xml element's value.
     * @return
     *     the new instance of {@link JAXBElement }{@code <}{@link UpdatePermissionResponse }{@code >}
     */
    @XmlElementDecl(namespace = "http://controller.digipay.com/", name = "updatePermissionResponse")
    public JAXBElement<UpdatePermissionResponse> createUpdatePermissionResponse(UpdatePermissionResponse value) {
        return new JAXBElement<UpdatePermissionResponse>(_UpdatePermissionResponse_QNAME, UpdatePermissionResponse.class, null, value);
    }

}

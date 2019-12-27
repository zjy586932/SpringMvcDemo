package com.spring.mvc.entity;

import java.util.List;
import java.util.Map;

public class BusinessOrder {
    String districtCode;
    String orderFrom;
    Boolean fromCart;
    String addressId;
    String token;
    String version;
    String method;
    String nativeVersion;
    List<Map> noteList;
    List<Map> itemlist;
    List<Map> invoiceList;

    public BusinessOrder() {
    }

    public String getDistrictCode() {
        return this.districtCode;
    }

    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    public String getOrderFrom() {
        return this.orderFrom;
    }

    public void setOrderFrom(String orderFrom) {
        this.orderFrom = orderFrom;
    }

    public Boolean getFromCart() {
        return this.fromCart;
    }

    public void setFromCart(Boolean fromCart) {
        this.fromCart = fromCart;
    }

    public String getAddressId() {
        return this.addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public String getToken() {
        return this.token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getVersion() {
        return this.version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getMethod() {
        return this.method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getNativeVersion() {
        return this.nativeVersion;
    }

    public void setNativeVersion(String nativeVersion) {
        this.nativeVersion = nativeVersion;
    }

    public List<Map> getNoteList() {
        return this.noteList;
    }

    public void setNoteList(List<Map> noteList) {
        this.noteList = noteList;
    }

    public List<Map> getItemlist() {
        return this.itemlist;
    }

    public void setItemlist(List<Map> itemlist) {
        this.itemlist = itemlist;
    }

    public List<Map> getInvoiceList() {
        return this.invoiceList;
    }

    public void setInvoiceList(List<Map> invoiceList) {
        this.invoiceList = invoiceList;
    }
}
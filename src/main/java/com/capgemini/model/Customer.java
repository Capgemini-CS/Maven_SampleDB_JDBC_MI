package com.capgemini.model;

import lombok.Getter;
import lombok.Setter;

public class Customer {
    @Getter @Setter private String customerNumber;
    @Getter @Setter private String customerName;
    @Getter @Setter private String contactLastName;
    @Getter @Setter private String contactFirstName;
    @Getter @Setter private String phone;
    @Getter @Setter private String city;

    public Customer() {}

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Customer{");
        sb.append("customerNumber='").append(customerNumber).append('\'');
        sb.append(", customerName='").append(customerName).append('\'');
        sb.append(", contactLastName='").append(contactLastName).append('\'');
        sb.append(", contactFirstName='").append(contactFirstName).append('\'');
        sb.append(", phone='").append(phone).append('\'');
        sb.append(", city='").append(city).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

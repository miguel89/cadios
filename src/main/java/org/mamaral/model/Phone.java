package org.mamaral.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "area_code")
    private String areaCode;

    private String number;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAreaCode() {
        return areaCode;
    }

    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public PhoneType getType() {
        return type;
    }

    public void setType(PhoneType type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Phone)) return false;
        Phone phone = (Phone) o;
        return getId().equals(phone.getId()) &&
                getAreaCode().equals(phone.getAreaCode()) &&
                getNumber().equals(phone.getNumber()) &&
                getType() == phone.getType();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getAreaCode(), getNumber(), getType());
    }
}

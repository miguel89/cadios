package org.mamaral.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "phones")
public class Phone {

    @Id
    @GeneratedValue
    private Long id;

    private String areaCode;

    private String number;

    private PhoneType type;

}

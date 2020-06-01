package org.mamaral.model;

import javax.persistence.*;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(unique = true)
    private String email;

    @Column(name = "full_name")
    private String fullName;

    private char[] password;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Phone> phones;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public char[] getPassword() {
        return password;
    }

    public void setPassword(char[] password) {
        this.password = password;
    }

    public List<Phone> getPhones() {
        return phones;
    }

    public void setPhones(List<Phone> phones) {
        this.phones = phones;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return getId().equals(user.getId()) &&
                getEmail().equals(user.getEmail()) &&
                getFullName().equals(user.getFullName()) &&
                Arrays.equals(getPassword(), user.getPassword()) &&
                Objects.equals(getPhones(), user.getPhones());
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(getId(), getEmail(), getFullName(), getPhones());
        result = 31 * result + Arrays.hashCode(getPassword());
        return result;
    }
}

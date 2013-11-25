package org.retail.user;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Paul Kulitski
 */
@Entity
@Table
public class User implements Serializable {

    private String username;
    private transient String password;
    private Set<Authority> authorities;
    private Long customerId;

    public User() {
    }

    public User(String username, String password, Set<Authority> authorities, Long customerId) {
        this.username = username;
        this.password = password;
        this.authorities = authorities;
        this.customerId = customerId;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    @Column(length = 40, unique = true, nullable = false)
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(length = 40, nullable = false)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn
    public Set<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(Set<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 31 * hash + (this.username != null ? this.username.hashCode() : 0);
        hash = 31 * hash + (this.authorities != null ? this.authorities.hashCode() : 0);
        hash = 31 * hash + (this.customerId != null ? this.customerId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if ((this.username == null) ? (other.username != null) : !this.username.equals(other.username)) {
            return false;
        }
        if ((this.authorities == null) ? (other.authorities != null) : !this.authorities.equals(other.authorities)) {
            return false;
        }
        if (this.customerId != other.customerId && (this.customerId == null || !this.customerId.equals(other.customerId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "User{" + "username=" + username + ", authorities=" + authorities + ", customerId=" + customerId + '}';
    }
}

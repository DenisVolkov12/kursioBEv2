package ru.kursio.application.model.entity.customization.renat;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import ru.kursio.application.model.entity.auth.User;

@Entity
@Table(name = "coupon")
public class Coupon {
    @Id
    @Column(name = "coupon_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long couponId;

    @Column(name = "has_been_used")
    private boolean hasBeenUsed;

    @Column(name = "coupon_code", unique=true)
    private String couponCode;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    public long getCouponId() {
        return couponId;
    }

    private String email;

    public void setCouponId(long couponId) {
        this.couponId = couponId;
    }

    public boolean isHasBeenUsed() {
        return hasBeenUsed;
    }

    public void setHasBeenUsed(boolean hasBeenUsed) {
        this.hasBeenUsed = hasBeenUsed;
    }

    public String getCouponCode() {
        return couponCode;
    }

    public void setCouponCode(String couponCode) {
        this.couponCode = couponCode;
    }

    @JsonIgnore
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getEmail() {
        return user.getEmail();
    }

    public void setEmail(String email) {
        this.email = user.getEmail();
    }
}





package ru.kursio.application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kursio.application.model.entity.customization.renat.ColorQuizQuestion;
import ru.kursio.application.model.entity.customization.renat.Coupon;

import java.util.Optional;

@Repository
public interface RenatCouponDao extends JpaRepository<Coupon, Long> {
    Optional<Coupon> findByCouponCode(String couponCode);
}

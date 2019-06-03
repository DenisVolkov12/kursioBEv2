package ru.kursio.application.util.defaultFactory;

import org.jvnet.hk2.annotations.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import ru.kursio.application.model.entity.auth.User;
import ru.kursio.application.model.entity.customization.renat.ColorQuizAnswer;
import ru.kursio.application.model.entity.customization.renat.ColorQuizQuestion;
import ru.kursio.application.model.entity.customization.renat.Coupon;
import ru.kursio.application.model.exception.InvalidParamException;
import ru.kursio.application.model.exception.NotFoundException;
import ru.kursio.application.model.pojo.ErrorDetails;
import ru.kursio.application.service.RenatCouponService;
import ru.kursio.application.util.CouponUtil;

import javax.inject.Inject;
import java.util.*;

import static ru.kursio.application.constants.Constants.MSG_INVALID_PARAM;
import static ru.kursio.application.constants.Constants.MSG_QUESTION_NOT_FOUND;

@Component
public class CouponFactory {

    private static Logger log = LoggerFactory.getLogger(CouponFactory.class.getName());

    @Autowired
    RenatCouponService renatCouponService;

    public List<Coupon> createCoupons(String type, List<User> users, RenatCouponService renatCouponService ){
        if(type.equals("RENAT_COUPON")) {
            Coupon c1 = createCoupon(users.get(1), renatCouponService);
            Coupon c2 = createCoupon(users.get(3), renatCouponService);
            return new ArrayList<>(Arrays.asList(c1, c2));
        }
        return null;
    }

    private Coupon createCoupon (User user, RenatCouponService service){
        Coupon c1 = new Coupon();
        String generatedCouponCode = CouponUtil.generateRandomCoupon();
        boolean check = service.isCouponForSaving(generatedCouponCode);
        while(!check){
            generatedCouponCode = CouponUtil.generateRandomCoupon();
            check  = service.isCouponForSaving(generatedCouponCode);
        }
        c1.setCouponCode(generatedCouponCode);
        c1.setHasBeenUsed(false);
        c1.setUser(user);
        return c1;
    }
}

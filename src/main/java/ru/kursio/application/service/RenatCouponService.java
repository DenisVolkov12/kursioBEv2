package ru.kursio.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import ru.kursio.application.dao.RenatCouponDao;
import ru.kursio.application.dao.RenatQuizDao;
import ru.kursio.application.model.entity.customization.renat.ColorQuizQuestion;
import ru.kursio.application.model.entity.customization.renat.Coupon;
import ru.kursio.application.model.exception.InvalidParamException;
import ru.kursio.application.model.exception.NotFoundException;
import ru.kursio.application.model.pojo.ErrorDetails;
import ru.kursio.application.util.CouponUtil;
import ru.kursio.application.util.ValidationUtil;

import java.util.List;
import java.util.Optional;

import static ru.kursio.application.constants.Constants.*;

@Service
public class RenatCouponService {

	private static Logger log = LoggerFactory.getLogger(RenatCouponService.class.getName());

	@Autowired
	private RenatCouponDao renatCouponDao;

	public ResponseEntity<Object> findAllCoupons() {
		List<Coupon> questions = renatCouponDao.findAll();
		if(ValidationUtil.objectIsNotNull(questions))
			return new ResponseEntity<>(renatCouponDao.findAll(), HttpStatus.OK);
		return new ResponseEntity<>(new ErrorDetails(MSG_RENAT_COUPONS_NOT_FOUND), HttpStatus.BAD_REQUEST);
	}

	private Coupon findCouponById(Long id) throws InvalidParamException, NotFoundException {
		if(!ValidationUtil.objectIsNotNull(id))
			throw new InvalidParamException(MSG_INVALID_PARAM);
		Optional<Coupon> question = renatCouponDao.findById(id);
		return question.orElseThrow(NotFoundException::new);
	}

	public Coupon findCouponByCouponCode(String couponCode) throws InvalidParamException, NotFoundException {
		if(!ValidationUtil.objectIsNotNull(couponCode))
			throw new InvalidParamException(MSG_INVALID_PARAM);
		Optional<Coupon> coupon = renatCouponDao.findByCouponCode(couponCode);
		return coupon.orElseThrow(NotFoundException::new);
	}

	public ResponseEntity<Object> isHasBeenUsed(String couponCode) {
		try {
			//attempt to find, return true if it's found or false
			Coupon coupon = findCouponByCouponCode(couponCode);
			return new ResponseEntity<>(coupon.isHasBeenUsed(), HttpStatus.OK);
		} catch (InvalidParamException e) {
			return new ResponseEntity<>(new ErrorDetails(MSG_INVALID_PARAM), HttpStatus.BAD_REQUEST);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(new ErrorDetails(MSG_COUPON_NOT_FOUND), HttpStatus.BAD_REQUEST);
		}
	}
	public boolean isCouponForSaving(String couponCode){
		//check if the coupon generated exist
		try {
			return findCouponByCouponCode(couponCode) == null;
		} catch (InvalidParamException e) {
			log.error(MSG_INVALID_PARAM);
		} catch (NotFoundException e) {
			return true;
		}
		return false;
	}

	public ResponseEntity<Object> deleteCouponById(Long id){
		try {
			this.findCouponById(id);
		} catch (InvalidParamException e) {
			return new ResponseEntity<>(new ErrorDetails(MSG_INVALID_PARAM), HttpStatus.BAD_REQUEST);
		} catch (NotFoundException e) {
			return new ResponseEntity<>(new ErrorDetails(MSG_COUPON_NOT_FOUND), HttpStatus.BAD_REQUEST);
		}
		renatCouponDao.deleteById(id);
		return new ResponseEntity<>(true, HttpStatus.BAD_REQUEST);
	}

	public ResponseEntity<Object> saveCoupon(Coupon coupon){
		if(!ValidationUtil.objectIsNotNull(coupon))
			return new ResponseEntity<>(new ErrorDetails(MSG_INVALID_PARAM), HttpStatus.BAD_REQUEST);
		Coupon savedCoupon = renatCouponDao.save(coupon);
		if(ValidationUtil.objectIsNotNull(savedCoupon))
			return new ResponseEntity<>(savedCoupon, HttpStatus.OK);
		return new ResponseEntity<>(new ErrorDetails(MSG_COUPON_NOT_FOUND), HttpStatus.BAD_REQUEST);
	}
}


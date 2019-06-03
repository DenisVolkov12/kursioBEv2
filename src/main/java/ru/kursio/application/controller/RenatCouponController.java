package ru.kursio.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.kursio.application.model.entity.customization.renat.Coupon;
import ru.kursio.application.service.RenatCouponService;

import javax.validation.Valid;

import static ru.kursio.application.constants.Constants.*;

@RestController
@RequestMapping(RENAT_ROOT_PATH)
public class RenatCouponController {

	@Autowired
	private RenatCouponService renatCouponService;

	@GetMapping(COUPON)
	@CrossOrigin
	public ResponseEntity<Object> findAllCoupons() {
		return renatCouponService.findAllCoupons();
	}

	@PostMapping(COUPON)
	@CrossOrigin
	public ResponseEntity<Object> saveCoupon(@RequestBody @Valid Coupon coupon) {
		return renatCouponService.saveCoupon(coupon);
	}

	@DeleteMapping(COUPON)
	@CrossOrigin
	public ResponseEntity<Object> deleteCouponById(@RequestBody @Valid Coupon coupon) {
		return renatCouponService.deleteCouponById(coupon.getCouponId());
	}

	@PostMapping(HAS_BEEN_USED)
	@CrossOrigin
	public ResponseEntity<Object> checkCouponHasBeenUsed(@RequestBody @Valid Coupon coupon) {
		return renatCouponService.isHasBeenUsed(coupon.getCouponCode());
	}
}
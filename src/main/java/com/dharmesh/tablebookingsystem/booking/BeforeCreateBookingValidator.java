package com.dharmesh.tablebookingsystem.booking;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreateBookingValidator")
public class BeforeCreateBookingValidator implements Validator {

    private static final Log logger = LogFactory.getLog(BeforeCreateBookingValidator.class);

    @Override
    public boolean supports(Class<?> aClass) {
        return Booking.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        Booking booking = (Booking) o;

        if (booking.getConfirmed() != null) {
            errors.rejectValue("confirmed", "confirmed.given", "Confirmed flag is to be set within the application");
        }

        if (booking.getTimestamp() != null) {
            errors.rejectValue("timestamp", "timestamp.given", "Timestamp is to be set within the application");
        }
    }
}

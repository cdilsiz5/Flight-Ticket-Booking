package com.renastech.FlightTicketBooking.stripe;

import com.renastech.FlightTicketBooking.exception.NotFoundException;
import com.renastech.FlightTicketBooking.model.entity.TicketPrice;
import com.renastech.FlightTicketBooking.repository.TicketPriceRepository;
import com.renastech.FlightTicketBooking.service.FlightService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RequiredArgsConstructor
@RestController
public class PaymentController {

    private final FlightService flightService;
    private final TicketPriceRepository ticketPriceRepository;
    public double calculatePrice(CreatePayment createPayment){
        int  ticketPriceId = flightService.getFlightById(createPayment.getFlightId()).getTicketPrice().getId();
        TicketPrice ticketPrice=ticketPriceRepository.findById(ticketPriceId).orElseThrow(()->new NotFoundException("Ticket Price Not Found"));
        return createPayment.getTicketNumber()*ticketPrice.getAmount();

    }
    @PostMapping("/create-payment-intent")
    public CreatePaymentResponse createPayment(@RequestBody CreatePayment createPayment) throws StripeException {
        Stripe.apiKey = "sk_test_51M5fyKBOWD1rcLcdHjdZj10J51XeLBVuQJOn1TFm3MwwLLrTuZF82E5E8Nk0XwsLSglVNaNShpwYErdR7PjnFM6L00ug2KGiEY";
        PaymentIntentCreateParams params =
                PaymentIntentCreateParams.builder()
                        .setAmount(new Long((long) (calculatePrice(createPayment)*100L)))
                        .setCurrency("usd")
                        .setAutomaticPaymentMethods(
                                PaymentIntentCreateParams.AutomaticPaymentMethods
                                        .builder()
                                        .setEnabled(true)
                                        .build()
                        )
                        .build();
        PaymentIntent paymentIntent = PaymentIntent.create(params);
        System.out.println(createPayment.getTravellers());
        return new CreatePaymentResponse(paymentIntent.getClientSecret());

    }
}
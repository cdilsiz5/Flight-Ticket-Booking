package com.renastech.FlightTicketBooking.stripe;


import com.stripe.Stripe;
import com.stripe.model.StripeObject;
import com.stripe.net.Webhook;
import com.stripe.model.Event;
import com.stripe.model.EventDataObjectDeserializer;
import com.stripe.exception.SignatureVerificationException;
import com.stripe.model.PaymentIntent;
import com.stripe.model.PaymentMethod;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class StripeWebHookController {

    @Value("whsec_d5d39b412a605ddd5a316c29857de55e729ad224d439467d56bf18c59788b187")
    private String endpointSecret;

    @PostMapping("stripe/events")
    public String  handleEvent(@RequestBody String payload,@RequestHeader("Stripe-Signature")String sigHeader){
        Stripe.apiKey = "sk_test_51M5fyKBOWD1rcLcdHjdZj10J51XeLBVuQJOn1TFm3MwwLLrTuZF82E5E8Nk0XwsLSglVNaNShpwYErdR7PjnFM6L00ug2KGiEY";
        if(sigHeader== null) {
            return "";
        }
        Event event;
        try {
            event = Webhook.constructEvent(
                    payload, sigHeader, endpointSecret
            );
        } catch (SignatureVerificationException e) {
            System.out.println("⚠️  Webhook error while validating signature.");
            return "";
        }
        EventDataObjectDeserializer dataObjectDeserializer = event.getDataObjectDeserializer();
        StripeObject stripeObject = null;
         if (dataObjectDeserializer.getObject().isPresent()) {
            stripeObject = dataObjectDeserializer.getObject().get();
        } else {
            }
            switch (event.getType()) {
                case "payment_intent.succeeded":
                    PaymentIntent paymentIntent = (PaymentIntent) stripeObject;
                     //handlePaymentIntentSucceeded(paymentIntent);
                    System.out.println(paymentIntent.getCurrency());
                    break;
                case "payment_method.attached":
                    PaymentMethod paymentMethod = (PaymentMethod) stripeObject;
                    // Then define and call a method to handle the successful attachment of a PaymentMethod.
                    // handlePaymentMethodAttached(paymentMethod);
                    System.out.println("payment_method.attached");

                    break;
                default:
                    System.out.println("Unhandled event type: " + event.getType());
                    break;
            }
            return "";

    }
}


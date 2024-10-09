package com.example.paymentservice;

import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

@RestController
public class PaymentController {
    private final ConcurrentMap<String, PaymentResponse> payments = new ConcurrentHashMap<>();

    @PostMapping("/make_payment")
    public PaymentResponse makePayment(@RequestBody PaymentRequest request) {
        String transactionId = "txn_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME);
        PaymentResponse response = new PaymentResponse();
        response.setSuccess(true);
        response.setTransactionId(transactionId);
        response.setMessage("Payment successful");
        response.setTimestamp(timestamp);
        response.setFee(1.00);

        payments.put(transactionId, response);
        return response;
    }

    @PostMapping("/get_payment_status")
    public PaymentStatusResponse getPaymentStatus(@RequestBody PaymentStatusRequest request) {
        PaymentResponse paymentResponse = payments.get(request.getTransactionId());
        if (paymentResponse == null) {
            throw new RuntimeException("Transaction not found");
        }

        PaymentStatusResponse statusResponse = new PaymentStatusResponse();
        statusResponse.setTransactionId(paymentResponse.getTransactionId());
        statusResponse.setStatus("completed");
        statusResponse.setMessage(paymentResponse.getMessage());
        statusResponse.setTimestamp(paymentResponse.getTimestamp());
        return statusResponse;
    }
}
package com.example.paymentservice;

public class PaymentResponse {
    private boolean success;
    private String transactionId;
    private String message;
    private String timestamp;
    private double fee;

    // Getters and Setters
    public void setSuccess(boolean success) {
        this.success = success;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public String getMessage() {
        return message;
    }

    public String getTimestamp() {
        return timestamp;
    }
}
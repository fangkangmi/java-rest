.PHONY: clean compile

clean:
	mvn clean install

compile:
	mvn spring-boot:run

test_payment:
	curl -X POST http://localhost:8080/make_payment -H "Content-Type: application/json" -d '{"amount":100.00,"currency":"USD","method":"credit_card","details":{"card_number":"4111111111111111","expiry_date":"12/23","cvv":"123"}}'

test_payment_status:
	curl -X POST http://localhost:8080/get_payment_status -H "Content-Type: application/json" -d '{"transactionId": "txn_20241009235855"}'
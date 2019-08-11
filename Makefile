SHELL=/bin/bash
SEAPAY_VERSION=0.0.1

all: clean build

run: run-catalog run-payment run-shopping run-user-management run-voucher

run-catalog:
	java -jar ./seapay-catalog/build/libs/seapay-catalog-$(SEAPAY_VERSION)-SNAPSHOT.jar

run-payment:
	java -jar ./seapay-payment/build/libs/seapay-payment-$(SEAPAY_VERSION)-SNAPSHOT.jar

run-shopping:
	java -jar ./seapay-shopping/build/libs/seapay-shopping-$(SEAPAY_VERSION)-SNAPSHOT.jar

run-user-management:
	java -jar ./seapay-user-management/build/libs/seapay-user-management-$(SEAPAY_VERSION)-SNAPSHOT.jar

run-voucher:
	java -jar ./seapay-voucher/build/libs/seapay-voucher-$(SEAPAY_VERSION)-SNAPSHOT.jar

clean:
	./gradlew clean

build:
	./gradlew build --info

db-migrate:
	./gradlew migrateDb

SHELL=/bin/bash
SEAPAY_VERSION=0.0.1
DB_NAME="seapay_dev"
DB_PORT=5432

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

db-drop:
	dropdb -p $(DB_PORT) --if-exists -Upostgres $(DB_NAME)

db-create:
	createdb -p $(DB_PORT) -Opostgres -Eutf8 $(DB_NAME)

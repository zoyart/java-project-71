.DEFAULT_GOAL := build-run

clean:
	make -C app clean

build:
	make -C app build

install-dist:
	make -C app installDist

run:
	make -C app run

test:
	make -C app test

report:
	make -C app report

lint:
	make -C lint
	./gradlew checkstyleMain checkstyleTest

checkstyle:
	make -C app checkstyle

run-dist-json-stylish:
	make -C app run-dist-json-stylish

run-dist-json-plane:
	make -C app run-dist-json-plane

run-dist-json-json:
	make -C app run-dist-json-json

.PHONY: build

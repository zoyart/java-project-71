.DEFAULT_GOAL := build-run

clean:
	./gradlew clean

build:
	./gradlew clean build

install-dist:
	./gradlew clean installDist

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew test
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

checkstyle:
	./gradlew checkstyleMain

run-dist-json-stylish:
	./gradlew installDist
	./build/install/app/bin/app src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

run-dist-json-plain:
	./gradlew installDist
	./build/install/app/bin/app -f plain src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

run-dist-json-json:
	./gradlew installDist
	./build/install/app/bin/app -f json src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

.PHONY: build

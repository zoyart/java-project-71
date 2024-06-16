.DEFAULT_GOAL := build-run

build:
	./gradlew build

install-dist:
	./gradlew installDist

checkstyle:
	./gradlew checkstyleMain

run-dist-json-stylish:
	./gradlew installDist
	./build/install/app/bin/app src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

run-dist-yml-stylish:
	./gradlew installDist
	./build/install/app/bin/app src/test/resources/fixtures/file1.yml src/test/resources/fixtures/file2.yml

run-dist-json-plane:
	./gradlew installDist
	./build/install/app/bin/app -f plane src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

run-dist-yml-plane:
	./gradlew installDist
	./build/install/app/bin/app -f plane src/test/resources/fixtures/file1.yml src/test/resources/fixtures/file2.yml

run-dist-json-json:
	./gradlew installDist
	./build/install/app/bin/app -f json src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

run-dist-yml-json:
	./gradlew installDist
	./build/install/app/bin/app -f json src/test/resources/fixtures/file1.yml src/test/resources/fixtures/file2.yml

clean:
	./gradlew clean

test:
	./gradlew test

test-report:
	./gradlew test
	./gradlew jacocoTestReport

.PHONY: build
.DEFAULT_GOAL := build-run

clean:
	./gradlew clean

build:
	./gradlew clean build

install:
	./gradlew clean install

run-dist:
	./build/install/java-package/bin/java-package

run:
	./gradlew run

test:
	./gradlew test

report:
	./gradlew test
	./gradlew jacocoTestReport

lint:
	./gradlew checkstyleMain checkstyleTest

update-deps:
	./gradlew useLatestVersions


build-run: build run

checkstyle:
	./app/gradlew checkstyleMain

run-dist-json-stylish:
	./app/gradlew installDist
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

.PHONY: build

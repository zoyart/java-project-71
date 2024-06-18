clean:
	./gradlew clean

build:
	./gradlew build

install:
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

update-deps:
	./gradlew useLatestVersions

checkstyle:
	./gradlew checkstyleMain

run-dist-json-stylish:
	./gradlew installDist
	./build/install/app/bin/app src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

run-dist-json-plane:
	./gradlew installDist
	./build/install/app/bin/app -f plane src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

.PHONY: build

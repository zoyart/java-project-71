.DEFAULT_GOAL := build-run

build:
	./gradlew build

install-dist:
	./gradlew installDist

checkstyle:
	./gradlew checkstyleMain

run-dist-json-stylish:
	./gradlew installDist
	./build/install/app/bin/app src/test/resources/testData/file1.json src/test/resources/testData/file2.json

run-dist-yml-stylish:
	./gradlew installDist
	./build/install/app/bin/app src/test/resources/testData/file1.yml src/test/resources/testData/file2.yml

run-dist-json-plane:
	./gradlew installDist
	./build/install/app/bin/app -f plane src/test/resources/testData/file1.json src/test/resources/testData/file2.json

run-dist-yml-plane:
	./gradlew installDist
	./build/install/app/bin/app -f plane src/test/resources/testData/file1.yml src/test/resources/testData/file2.yml

clean:
	./gradlew clean

test:
	./gradlew test

test-report:
	./gradlew test
	./gradlew jacocoTestReport

.PHONY: build
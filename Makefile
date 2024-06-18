clean:
	make -C app ./gradlew clean

build:
	make -C app ./gradlew build

install:
	make -C app ./gradlew clean install

run:
	make -C app ./gradlew run

test:
	make -C app ./gradlew test

report:
	make -C app ./gradlew test
	make -C app ./gradlew jacocoTestReport

lint:
	make -C app ./gradlew checkstyleMain checkstyleTest

update-deps:
	make -C app ./gradlew useLatestVersions

checkstyle:
	cd app && ./gradlew checkstyleMain

run-dist-json-stylish:
	cd app && ./gradlew installDist
	cd app && ./build/install/app/bin/app src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

run-dist-json-plane:
	cd app && ./gradlew installDist
	cd app && ./build/install/app/bin/app -f plane src/test/resources/fixtures/file1.json src/test/resources/fixtures/file2.json

.PHONY: build

build:
	./gradlew clean build

install-dist:
	./gradlew installDist

checkstyle:
	./gradlew checkstyleMain

run-dist-plane:
	./gradlew installDist
	./build/install/app/bin/app src/test/resources/testData/file1.json src/test/resources/testData/file2.json

clean:
	./gradlew clean

test:
	./gradlew test

test-report:
	./gradlew jacocoTestReport

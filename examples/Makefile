
gradle:
	make -C ../ build

build: gradle
	javac -cp ".:../lib/build/libs/fluvio.jar" Simple.java

run: build
	java -Djava.library.path=${PWD}/../target/release/ -cp ".:../lib/build/libs/fluvio.jar" Simple

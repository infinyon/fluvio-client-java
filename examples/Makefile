
gradle:
	make -C ../ build

build: gradle
	javac -cp ".:../lib/build/libs/lib-0.0-SNAPSHOT.jar" Simple.java

run: build
	java -Djava.library.path=/home/simlay/projects/infinyon/fluvio-client-java/target/release/ -cp ".:../lib/build/libs/lib-0.0-SNAPSHOT.jar" Simple

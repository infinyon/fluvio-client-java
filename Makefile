.PHONY: assemble test clean docs

assemble:
	./gradlew assemble --no-daemon

build:
	./gradlew build -x test

test: build
	fluvio topic create simple-send || true
	FLV_SOCKET_WAIT=1200 ./gradlew cleanTest test --no-daemon -i
	fluvio topic delete simple-send || true

examples: build
	fluvio topic create simple-example || true
	make -C examples/ run
	fluvio topic delete simple-example || true

clean:
	cargo clean
	./gradlew clean --no-daemon

docs:
	./gradlew javadoc

publish:
	./gradlew publish

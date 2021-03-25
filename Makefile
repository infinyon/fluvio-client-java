.PHONY: assemble test clean docs

assemble:
	./gradlew assemble --no-daemon

test: assemble
	fluvio topic create simple-send || true
	FLV_SOCKET_WAIT=1200 ./gradlew cleanTest test --no-daemon -i
	fluvio topic delete simple-send || true

clean:
	cargo clean
	./gradlew clean --no-daemon

docs:
	./gradlew javadoc

.PHONY: assemble test clean docs

GRADLE=./gradlew --no-daemon --no-build-cache

assemble:
	$(GRADLE) assemble

build:
	$(GRADLE) build -x test

test: build
	FLV_SOCKET_WAIT=1200 $(GRADLE) cleanTest test -i

examples: build
	$(GRADLE)  -q run

clean:
	cargo clean
	$(GRADLE) clean

docs:
	$(GRADLE) javadoc

publish-local:
	$(GRADLE) publishToMavenLocal -x rust-deploy

publish:
	$(GRADLE) publish -x rust-deploy

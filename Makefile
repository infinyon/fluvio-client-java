.PHONY: assemble test clean docs

GRADLE=./gradlew --no-daemon --no-build-cache

assemble:
	$(GRADLE) assemble

build:
	$(GRADLE) build

test: build
	FLV_SOCKET_WAIT=1200 $(GRADLE) cleanTest test -i

examples: build
	$(GRADLE)  -q run

clean:
	cargo clean
	$(GRADLE) clean

docs:
	$(GRADLE) javadoc

checkstyle:
	$(GRADLE) checkstyleMain

publish-local:
	$(GRADLE) publishToMavenLocal -x rust-deploy

publish:
	$(GRADLE) publish -x rust-deploy

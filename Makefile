.PHONY: assemble test clean docs

assemble:
	gradle assemble --no-daemon

test: assemble
	fluvio topic create simple-send || true
	FLV_SOCKET_WAIT=1200 gradle cleanTest test --no-daemon -i
	fluvio topic delete simple-send || true

clean:
	cargo clean
	gradle clean --no-daemon

docs:
	gradle javadoc

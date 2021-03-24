
symbols:
	nm -gD lib/build/lib/shared/*.so

assemble:
	gradle assemble --no-daemon

test: assemble
	fluvio topic create simple-send || true
	gradle cleanTest test --no-daemon -i
	fluvio topic delete simple-send || true

clean:
	cargo clean
	gradle clean

docs:
	gradle javadoc

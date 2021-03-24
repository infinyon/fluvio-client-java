
symbols:
	nm -gD lib/build/lib/shared/*.so

assemble:
	gradle assemble

test: assemble
	fluvio topic create simple-send || true
	gradle cleanTest test --no-daemon
	fluvio topic delete simple-send || true

clean:
	cargo clean
	gradle clean

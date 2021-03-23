
symbols:
	nm -gD lib/build/lib/shared/*.so

assemble:
	gradle assemble

test: assemble
	#fluvio topic delete simple-send || true
	#fluvio topic create simple-send || true
	gradle cleanTest test
	fluvio topic delete simple-send || true

clean:
	cargo clean
	gradle clean

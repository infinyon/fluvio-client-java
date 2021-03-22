
symbols:
	nm -gD lib/build/lib/shared/*.so

build:
	gradle build

test: build
	gradle test

clean:
	cargo clean
	gradle clean

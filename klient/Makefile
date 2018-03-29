DOCKER  := docker
NAIS    := nais
NPM     := npm
VERSION := $(shell cat ./VERSION)
REGISTRY:= docker.adeo.no:5000

.PHONY: all build test docker docker-push bump-version manifest

all: build test docker

build:
	$(NPM) install

test:
	$(NPM) test

docker:
	$(NAIS) validate
	$(DOCKER) build --pull -t $(REGISTRY)/presys-frontend -t $(REGISTRY)/presys-frontend:$(VERSION) .

docker-push:
	$(DOCKER) push $(REGISTRY)/presys-frontend:$(VERSION)

bump-version:
	@echo $$(($$(cat ./VERSION) + 1)) > ./VERSION

manifest:
	nais upload --app presys-frontend -v $(VERSION)

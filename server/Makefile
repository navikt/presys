DOCKER  := docker
NAIS    := nais
MVN     := mvn
VERSION := $(shell cat ./VERSION)
REGISTRY:= docker.adeo.no:5000

.PHONY: all build test docker docker-push bump-version manifest

all: build test docker

build:
	$(MVN) clean package -DskipTests=true -B -V

test:
	$(MVN) verify -B

docker:
	$(NAIS) validate
	$(DOCKER) build --pull -t $(REGISTRY)/presys -t $(REGISTRY)/presys:$(VERSION) .

docker-push:
	$(DOCKER) push $(REGISTRY)/presys:$(VERSION)

bump-version:
	@echo $$(($$(cat ./VERSION) + 1)) > ./VERSION

manifest:
	nais upload --app presys -v $(VERSION)

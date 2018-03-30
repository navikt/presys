DOCKER  := docker
NAIS    := nais
MVN     := mvn
VERSION := $(shell cat ./VERSION)
REGISTRY:= repo.adeo.no:5443

.PHONY: all build test docker docker-push bump-version manifest

all: build test docker

build:
	$(MVN) clean package -DskipTests=true -B -V

test:
	$(MVN) verify -B

test-coverage:
	$(MVN) clean org.jacoco:jacoco-maven-plugin:prepare-agent verify -Pcoverage-per-test -B -e

docker:
	$(NAIS) validate
	$(DOCKER) build --pull -t $(REGISTRY)/presys -t $(REGISTRY)/presys:$(VERSION) .

docker-push:
	$(DOCKER) push $(REGISTRY)/presys:$(VERSION)

bump-version:
	@echo $$(($$(cat ./VERSION) + 1)) > ./VERSION

manifest:
	nais upload --app presys -v $(VERSION)

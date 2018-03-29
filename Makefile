BACKEND_VERSION := $(shell cat ./server/VERSION)
FRONTEND_VERSION := $(shell cat ./klient/VERSION)

.PHONY: all release tag

all: build test docker
release: tag docker-push

%:
	$(MAKE) -C klient $@
	$(MAKE) -C server $@

tag:
	git add ./server/VERSION ./klient/VERSION
	git commit -m "Bump version [skip ci]"

	git tag -a presys-$(BACKEND_VERSION) -m "auto-tag from Makefile"
	git tag -a presys-frontend-$(FRONTEND_VERSION) -m "auto-tag from Makefile"

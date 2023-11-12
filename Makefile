run:
	@./gradlew bootRun

stop:
	@docker-compose down

start-kafka:
	@docker-compose up -d --build zookeeper kafka schema-registry kafka-ui

status:
	@docker ps -a

cleanup:
	@docker rmi $$(docker images -f "dangling=true"-q)

test:
	@./gradlew clean test

.PHONY: run start-kafka status cleanup test
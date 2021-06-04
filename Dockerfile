FROM openjdk:11

EXPOSE 4567

COPY . /usr/src/dafte
WORKDIR /usr/src/dafte

RUN ./gradlew build

CMD ["./gradlew", "run"]

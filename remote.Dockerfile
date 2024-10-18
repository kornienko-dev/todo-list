FROM tomcat:11.0.0-jdk21 AS base

RUN apt update \
    && apt install -y git \
    && apt clean

WORKDIR /
RUN git clone https://github.com/kornienko-dev/todo-list.git
WORKDIR /todo-list

RUN chmod +x gradlew \
    && ./gradlew clean \
    && ./gradlew war

FROM tomcat:11.0.0-jdk21 AS result

COPY --from=base /todo-list/build/libs/todo-list-*.war /usr/local/tomcat/webapps/todo-list.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
# Run "gradle clean war" first
FROM tomcat:11.0.0-jdk21
COPY build/libs/todo-list-*.war /usr/local/tomcat/webapps/todo-list.war
EXPOSE 8080
CMD ["catalina.sh", "run"]
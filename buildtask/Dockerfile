FROM daocloud.io/java:8
RUN mkdir /app/
RUN mkdir /app/logs
RUN mkdir /app/target
RUN mkdir /app/buildtask

COPY ./target/com.thoughtworks.sharing.aws.webapp-0.0.1-SNAPSHOT.war /app/target
COPY ./buildtask/entrypoint.sh /app/
WORKDIR /app/
EXPOSE 8080 8080
CMD ["./entrypoint.sh"]
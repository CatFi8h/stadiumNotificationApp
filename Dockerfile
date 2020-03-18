FROM openjdk:12-jdk-slim

ENV MYSQL_URL="mysql-master:3306" \
    MYSQL_USER="wsec_user" \
    MYSQL_PASSWORD="wsec_user"


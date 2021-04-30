FROM openjdk:11.0.11-9-jdk-oraclelinux8

LABEL component="@artifact.final-name@"
LABEL componentVersion="@project.version@"

ENV WORKDIR /apps

ADD @artifact.final-name@.jar ${WORKDIR}/@artifact.final-name@.jar

WORKDIR ${WORKDIR}

ENTRYPOINT ["java", "-jar", "@artifact.final-name@.jar"]

EXPOSE 8080
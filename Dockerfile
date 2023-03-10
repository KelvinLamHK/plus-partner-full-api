FROM maven:3.6.3-jdk-11

RUN useradd -ms /bin/bash ftlife

COPY ./agent-0.0.1.jar /home/ftlife/agent-0.0.1.jar
RUN chown -R ftlife:ftlife /home/ftlife/agent-0.0.1.jar

USER ftlife
WORKDIR /home/ftlife
ENTRYPOINT ["java","-Xmx512M", "-jar", "agent-0.0.1.jar"]

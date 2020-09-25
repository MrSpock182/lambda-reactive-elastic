FROM adoptopenjdk/openjdk14

ENV SPRING_PROFILE deploy
ENV PORT 8082
ENV JVM_XMS 512m
ENV JVM_XMX 1024m

# Add file to image on build
ADD target/*.jar /app/app.jar
ADD app.sh /

RUN chmod 0755 /app.sh

CMD /app.sh

EXPOSE ${PORT}
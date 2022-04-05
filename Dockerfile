FROM maven
WORKDIR /app
COPY ./ .
ENTRYPOINT mvn -Dtest=FindTests test
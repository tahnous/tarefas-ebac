### Building the application

To run the application, you use Maven:

```bash
  mvn clean package
  mvn install package
```

### Running the application

To run the application, run the command:

```bash
./target/server/bin/standalone.sh -Denv.POSTGRESQL_USER=postgres -Denv.POSTGRESQL_PASSWORD=admin -Denv.POSTGRESQL_DATABASE=mydb -Denv.POSTGRESQL_JNDI=java:jboss/datasources/Postgre1DS
```

Once WildFly is running, the application can be accessed at:
http://localhost:8080/hello.xhtml

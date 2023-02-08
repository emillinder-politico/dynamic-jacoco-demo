```shell
rm build/*.exec || true
java -javaagent:jacocoagent.jar=address=*,port=36320,destfile=build/jacoco-it.exec,output=tcpserver -jar build/libs/dynamic-jacoco-demo-0.0.1-SNAPSHOT.jar &
sleep 5
curl -X GET http://localhost:8080/name
sleep 5
java -jar jacococli.jar dump --address localhost --port 36320 --destfile build/jacoco-it-cli.exec
sleep 5
java -jar jacococli.jar report build/jacoco-it.exec --classfiles build/classes/com --sourcefiles src/main/java/ --html build/jacoco-report
```
```shell
java -javaagent:jacocoagent.jar=destfile=/tmp/jacoco-it.exec -jar build/libs/dynamic-jacoco-demo-0.0.1-SNAPSHOT.jar &
sleep 5
curl -X GET http://localhost:8080/name
sleep 5 # potentially shell into the container
java -jar jacococli.jar report /tmp/jacoco-it.exec --classfiles build/classes/com --html /tmp/jacoco-report 
# can use the class files from in the webapp, might have to expand some of our jars
```

This can just as easily be done in a container.

curl ${CFGURL} -o application.yml
java -jar edu-management.jar server application.yml

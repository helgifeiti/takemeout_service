# Server side startup

echo "Starting up server side of the app.."

cd registered_event_service

gradle wrap

./gradlew build

echo "Running JAR file.."
java -jar build/libs/gs-rest-service-0.1.0.jar

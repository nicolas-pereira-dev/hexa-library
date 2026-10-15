# Start kafka and produce messages in a topic
docker pull apache/kafka
docker run -d -p 9092:9092 --name hexa-kafka apache/kafka:latest
docker exec --workdir /opt/kafka/bin/ -it broker sh
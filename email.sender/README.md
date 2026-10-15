# Start kafka and consume messages from it
docker pull apache/kafka
docker run -d -p 9092:9092 --name hexa-kafka apache/kafka:latest
docker exec -it 41db9f92ca61 bash
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic hexa-order --from-beginning

./kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic hexa-order

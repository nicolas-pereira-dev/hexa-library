# Hexagonal Architecture showroom project

I created this little project in order to learn more about Hexagonal Architecture, Angular signals, Kafka and S3 resource management. It works with docker images for the database, the Minio (S3 bucket) and the kafka topics.

## Start minio, local amazon S3 bucket manager
docker pull minio/minio
docker run --name hexas3 -p 9000:9000 -p 8900:8900 minio/minio server /data/minio --console-address ":8900" -d

## Start kafka and consume messages from it
docker pull apache/kafka
docker run -d -p 9092:9092 --name hexa-kafka apache/kafka:latest
docker exec -it 41db9f92ca61 bash
./kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic hexa-order --from-beginning

./kafka-topics.sh --bootstrap-server localhost:9092 --delete --topic hexa-order

## Start minio, local amazon S3 bucket manager
docker pull minio/minio
docker run --name hexas3 -p 9000:9000 -p 8900:8900 minio/minio server /data/minio --console-address ":8900" -d

## Step to start/restart everything

1)  colima start

2)  docker restart hexadb
    docker restart hexas3
    docker restart hexas-kafka

3)  run the ui and the spring boot core app

4)  edit email.sender application.yml > incule gmail credentials

5)  run then email.sender service

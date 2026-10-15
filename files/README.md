# Start minio, local amazon S3 bucket manager
docker pull minio/minio
docker run --name hexas3 -p 9000:9000 -p 8900:8900 minio/minio server /data/minio --console-address ":8900" -d
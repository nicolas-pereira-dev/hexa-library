# Start colima, docker and database
colima start
docker run --name hexadb -e POSTGRES_USER=hexadb -e POSTGRES_PASSWORD=hexadb -p 5432:5432 -d postgres
docker exec -it b36d66a12377 bash
psql -Uhexadb
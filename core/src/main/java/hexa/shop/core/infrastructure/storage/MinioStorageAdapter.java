package hexa.shop.core.infrastructure.storage;

import hexa.shop.core.domain.port.storage.ImageStoragePort;
import io.minio.*;
import io.minio.errors.MinioException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

@Component
public class MinioStorageAdapter implements ImageStoragePort {
    private final MinioClient minioClient;
    private final String bucketName;

    public MinioStorageAdapter(
            @Value("${minio.endpoint}") String endpoint,
            @Value("${minio.access-key}") String accessKey,
            @Value("${minio.secret-key}") String secretKey,
            @Value("${minio.bucket}") String bucketName)
            throws InvalidKeyException, NoSuchAlgorithmException {
        this.minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey)
                .build();
        this.bucketName = bucketName;
        
        try {
            if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
                minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
            }
        } catch (MinioException e) {
            throw new RuntimeException("Failed to initialize MinIO bucket", e);
        }
    }

    @Override
    public InputStream getImage(String imagePath) throws IOException {
        try {
            return minioClient.getObject(
                    GetObjectArgs.builder()
                            .bucket(bucketName)
                            .object(imagePath.split("/")[1])
                            .build()
            );
        } catch (MinioException e) {
            throw new IOException("Failed to retrieve image from MinIO", e);
        }
    }
}
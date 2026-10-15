package hexa.shop.core.domain.service;

import java.io.IOException;
import java.io.InputStream;
import org.springframework.stereotype.Service;
import hexa.shop.core.domain.port.storage.ImageStoragePort;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ImageService {
    private final ImageStoragePort imageStoragePort;

    public InputStream getImage(String imagePath) throws IOException {
        return imageStoragePort.getImage(imagePath);
    }
}

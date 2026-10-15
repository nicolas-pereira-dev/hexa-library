package hexa.shop.core.domain.port.storage;

import java.io.IOException;
import java.io.InputStream;

public interface ImageStoragePort {
    public InputStream getImage(String imagePath) throws IOException;
}

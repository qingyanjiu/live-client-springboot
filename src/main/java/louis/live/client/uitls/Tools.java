package louis.live.client.uitls;

import java.util.UUID;

public class Tools {

    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}

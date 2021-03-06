package io.getstream.client;

import io.getstream.core.models.Data;
import io.getstream.core.models.ProfileData;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class UserTest {
    private static final String apiKey = "gp6e8sxxzud6";
    private static final String secret = "7j7exnksc4nxy399fdxvjqyqsqdahax3nfgtp27pumpc7sfm9um688pzpxjpjbf2";

    @Test
    void get() {
        Data[] result = new Data[1];
        assertDoesNotThrow(() -> {
            Client client = Client.builder(apiKey, secret)
                    .build();

            String userID = "get-user";
            User user = client.user(userID);
            user.getOrCreate().join();
            result[0] = user.get().join();
        });
    }

    @Test
    void delete() {
        assertDoesNotThrow(() -> {
            Client client = Client.builder(apiKey, secret)
                    .build();

            String userID = "delete-user";
            User user = client.user(userID);
            user.getOrCreate().join();
            user.delete().join();
        });
    }

    @Test
    void getOrCreate() {
        Data[] result = new Data[1];
        assertDoesNotThrow(() -> {
            Client client = Client.builder(apiKey, secret)
                    .build();

            String userID = "get-or-create-user";
            User user = client.user(userID);
            try {
                user.delete().join();
            } catch (Exception ignored) {
                //XXX: do nothing
                System.out.println(ignored);
            }
            result[0] = user.getOrCreate().join();
        });
    }

    @Test
    void create() {
        Data[] result = new Data[1];
        assertDoesNotThrow(() -> {
            Client client = Client.builder(apiKey, secret)
                    .build();

            String userID = "create-user";
            User user = client.user(userID);
            try {
                user.delete().join();
            } catch (Exception ignored) {
                //XXX: do nothing
                System.out.println(ignored);
            }
            result[0] = user.create().join();
        });
    }

    @Test
    void update() {
        Data[] result = new Data[1];
        assertDoesNotThrow(() -> {
            Client client = Client.builder(apiKey, secret)
                    .build();

            String userID = "update-user";
            User user = client.user(userID);
            user.getOrCreate().join();
            result[0] = user.update(new Data().set("key", "value")).join();
        });
    }

    @Test
    void profile() {
        ProfileData[] result = new ProfileData[1];
        assertDoesNotThrow(() -> {
            Client client = Client.builder(apiKey, secret)
                    .build();

            String userID = "new-profile-user";
            User user = client.user(userID);
            user.getOrCreate().join();
            result[0] = user.profile().join();
        });
    }
}
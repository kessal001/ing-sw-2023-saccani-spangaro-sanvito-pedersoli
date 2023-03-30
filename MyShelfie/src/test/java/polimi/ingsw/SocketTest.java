package polimi.ingsw;

import org.junit.jupiter.api.*;
import polimi.ingsw.client.ClientBase;
import polimi.ingsw.server.Server;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SocketTest {

    private final static String ip = "127.0.0.1";
    private final static int port = 4567;
    private static ClientBase client, client2, client3;
    private static Server server;

    @BeforeEach
    void setup() throws IOException {
        server = new Server();
        server.start(port);
        client = new ClientBase();
        client.startConnection(ip, port);
        client2 = new ClientBase();
        client2.startConnection(ip, port);
        client3 = new ClientBase();
        client3.startConnection(ip, port);
    }

    @AfterEach
    void tearDown() throws IOException {
        client.stopConnection();
        //TODO: close the server connection without it throwing an exception
        server.stopConnection();
    }

    @Test
    @DisplayName("Test connection")
    void testConnection() throws IOException, ClassNotFoundException {
        String resp1 = client.sendMsg("ciao");
        String resp2 = client.sendMsg("ciao again");
        String resp3 = client.sendMsg(".");

        assertEquals("ciao", resp1);
        assertEquals("ciao again", resp2);
        assertEquals("Ciao Ciao", resp3);
    }

    @Test
    @DisplayName("Test multiple connection")
    void testMulConnection() throws IOException, ClassNotFoundException {
        String respCl10 = client.sendMsg("ciao");
        String respCl11 = client.sendMsg("ciao again");
        String respCl12 = client.sendMsg(".");

        String respCl20 = client2.sendMsg("bau");
        String respCl21 = client2.sendMsg("miao");
        String respCl22 = client2.sendMsg(".");

        String respCl30 = client3.sendMsg("test magico");
        String respCl31 = client3.sendMsg("test magico 2");
        String respCl32 = client3.sendMsg(".");


        assertEquals("ciao", respCl10);
        assertEquals("bau", respCl20);
        assertEquals("test magico", respCl30);
        assertEquals("ciao again", respCl11);
        assertEquals("miao", respCl21);
        assertEquals("test magico 2", respCl31);
        assertEquals("Ciao Ciao", respCl12);
        assertEquals("Ciao Ciao", respCl22);
        assertEquals("Ciao Ciao", respCl32);
    }

    @Test
    @DisplayName("Test for lots of messages")
    void testInfinite() throws IOException, ClassNotFoundException {
        for(int i = 0; i<10; i++){
            String ciao = client.sendMsg("ciao");
            assertEquals("ciao", ciao);
        }
        //Closes the connection
        client.sendMsg(".");
    }


}

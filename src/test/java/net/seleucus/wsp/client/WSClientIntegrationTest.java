package net.seleucus.wsp.client;

import net.seleucus.wsp.console.WSConsole;
import net.seleucus.wsp.main.WebSpa;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WSClientIntegrationTest {

    @Test
    void clientBodyMethod() {
        final WebSpa webSpa = new WebSpa(WSConsole.getWsConsole());
        WSClient wsClient = new WSClient(webSpa);

        String host = "http://29f7a.yeg.rac.sh:80";
        CharSequence password = "Pass@123";
        String localHost = "http://localhost:80";

        List<Input> inputs = new ArrayList<>();
        inputs.add(new Input(localHost, "Pass@123", 1));
       /* inputs.add(new Input(localHost, "User@123", 4));
        inputs.add(new Input(localHost, "Value@123434324", 2));
        inputs.add(new Input(localHost, "Mack@123", 2));
        inputs.add(new Input(localHost, "Test@123", 5));*/

        for (Input input : inputs) {
            for (int i = 0; i < 30; i++) {
                wsClient.clientBodyMethod(input.getHost(), input.password.toString(), input.getAction(), host);
            }
        }

    }

    class Input{
        String host ;
        CharSequence password ;
        int action ;

        public Input(String host, CharSequence password, int action) {
            this.host = host;
            this.password = password;
            this.action = action;
        }

        public String getHost() {
            return host;
        }

        public CharSequence getPassword() {
            return password;
        }

        public int getAction() {
            return action;
        }
    }
}
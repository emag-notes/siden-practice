  package sidenpractice;

import ninja.siden.App;

import java.nio.file.Paths;

/**
 * @author tanabe
 */
public class UseWebsocket {

  public static void main(String[] args) {
    App app = new App();
    app.get("/", (req, res) ->
      Paths.get("assets/chat.html"));
    app.websocket("/ws").onText((con, txt) ->
      con.peerConnections().forEach(c ->
        c.send(txt)));
    app.listen("0.0.0.0", 8181);
  }

}

package sidenpractice;

import ninja.siden.App;
import ninja.siden.Renderer;
import org.boon.json.JsonFactory;
import sidenpractice.exceptions.SystemRuntimeException;
import sidenpractice.model.User;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    App app = new App();

    // simple get
    app.get("/hello", (req, res) -> "Hello World!");

    // exception handling
    app.error(SystemRuntimeException.class, (ex, req, res) -> ex.message());
    app.get("/err", (req, res) -> {
      throw new SystemRuntimeException();
    });

    // response code handling
    app.error(402, (req, res) -> "Payment Required. Payment Required!!");
    app.get("/402", (req, res) -> 402);
    app.get("/payment", (req, res) -> res.status(402));

    // json marshalling
    app.get("/users", (req, res) -> new User(1, "User1"))
      .render(Renderer.of(JsonFactory::toJson))
      .type("application/json");

    app.listen("localhost", 18080);
  }

}

package sidenpractice;

import ninja.siden.App;

/**
 * @author Yoshimasa Tanabe
 */
public class Main {

  public static void main(String[] args) {
    App app = new App();
    app.get("/hello", (req, res) -> "Hello World!");
    app.listen("localhost", 18080);
  }

}

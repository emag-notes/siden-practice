package sidenpractice.exceptions;

/**
 * @author tanabe
 */
public class SystemRuntimeException extends RuntimeException {

  public String message() {
    return "System error!";
  }

}

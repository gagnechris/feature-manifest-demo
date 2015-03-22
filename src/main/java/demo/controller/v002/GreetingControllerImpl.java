package demo.controller.v002;

import demo.model.Greeting;
import demo.controller.IGreetingController;
import java.util.concurrent.atomic.AtomicLong;

public class GreetingControllerImpl implements IGreetingController {

  private static final String template = "V002 demo, %s!";
  private final AtomicLong counter = new AtomicLong();

  public Greeting greeting(String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
}
package demo.controller.v001;

import demo.model.Greeting;
import demo.controller.IGreetingController;
import java.util.concurrent.atomic.AtomicLong;

public class GreetingControllerImpl implements IGreetingController {

  private static final String template = "V001 demo, %s!";
  private final AtomicLong counter = new AtomicLong();

  public Greeting greeting(String name) {
    return new Greeting(counter.incrementAndGet(), String.format(template, name));
  }
}
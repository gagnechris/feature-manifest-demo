package demo.controller;

import demo.model.Greeting;
import demo.ManifestDictionary;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CookieValue;

@RestController
public class GreetingController {
  IGreetingController greetingControllerImpl;
  ManifestDictionary manifestDictionary = new ManifestDictionary();

  public GreetingController() {
    setGreetingControllerImpl(new demo.controller.v001.GreetingControllerImpl());
  }

  @RequestMapping("/greeting")
  public Greeting greeting(@CookieValue(value="MANIFEST", defaultValue="Production") String manifest, @RequestParam(value="name", defaultValue="World") String name)
    throws ClassNotFoundException, InstantiationException, IllegalAccessException {

    setGreetingControllerImpl(manifestDictionary.getManifest(manifest).get(this.getClass().getName()));
    return greetingControllerImpl.greeting(name);
  }

  public void setGreetingControllerImpl(Class<?> greetingControllerImpl) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    try {
      setGreetingControllerImpl((IGreetingController) greetingControllerImpl.newInstance());
    } catch (Exception ex) {
      // need to log
      throw ex;
    }
  }

  public void setGreetingControllerImpl(IGreetingController greetingControllerImpl) {
    this.greetingControllerImpl = greetingControllerImpl;
  }

  public IGreetingController getGreetingControllerImpl()
  {
    return greetingControllerImpl;
  }
}
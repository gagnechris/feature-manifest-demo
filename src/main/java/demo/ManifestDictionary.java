package demo;

import java.util.HashMap;
import java.util.Map;

public class ManifestDictionary {

  private final Map<String, Class<?>> production;
  private final Map<String, Class<?>> staging;
  private final Map<String, Class<?>> f001;
  private final Map<String, Class<?>> f002;

  public ManifestDictionary() {
    production = createProductionManifest();
    staging = createStagingManifest();
    f001 = createF001Manifest();
    f002 = createF002Manifest();
  }

  public Map<String, Class<?>> getManifest(String name) {
    Map<String, Class<?>> ret;
    switch (name) {
      case "Production":
        ret = getProductionManifest();
        break;
      case "Staging":
        ret = getStagingManifest();
        break;
      case "F001":
        ret = getF001Manifest();
        break;
      case "F002":
        ret = getF002Manifest();
        break;
      default:
        ret = getProductionManifest();
        break;
    }
    return ret;
  }

  public Map<String, Class<?>> getProductionManifest() {
    return this.production;
  }

  public Map<String, Class<?>> getStagingManifest() {
    return this.staging;
  }

  public Map<String, Class<?>> getF001Manifest() {
    return this.f001;
  }

  public Map<String, Class<?>> getF002Manifest() {
    return this.f002;
  }

  private Map<String, Class<?>> createProductionManifest() {
    Map<String, Class<?>> map = new HashMap<String, Class<?>>();
    map.put("demo.controller.GreetingController", demo.controller.v001.GreetingControllerImpl.class);
    return map;
  }

  private Map<String, Class<?>> createStagingManifest() {
    Map<String, Class<?>> map = new HashMap<String, Class<?>>();
    map.put("demo.controller.GreetingController", demo.controller.v002.GreetingControllerImpl.class);
    return map;
  }

  private Map<String, Class<?>> createF001Manifest() {
    Map<String, Class<?>> map = new HashMap<String, Class<?>>();
    map.put("demo.controller.GreetingController", demo.controller.v001.GreetingControllerImpl.class);
    return map;
  }

  private Map<String, Class<?>> createF002Manifest() {
    Map<String, Class<?>> map = new HashMap<String, Class<?>>();
    map.put("demo.controller.GreetingController", demo.controller.v002.GreetingControllerImpl.class);
    return map;
  }
}
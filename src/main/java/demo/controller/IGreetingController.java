package demo.controller;

import demo.model.Greeting;

public interface IGreetingController {
  public Greeting greeting(String name);
}
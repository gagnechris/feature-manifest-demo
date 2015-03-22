package demo.controller;

import demo.model.Status;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RestController
public class ManifestController {

  @RequestMapping("/manifest/{name}")
  public Status manifest(@PathVariable String name, HttpServletResponse response) {
    Cookie manifestCookie = new Cookie("MANIFEST", name);
    manifestCookie.setPath("/");

    response.addCookie(manifestCookie);
    return new Status("OK", String.format("Successfully set MANIFEST to %s", name));
  }
}
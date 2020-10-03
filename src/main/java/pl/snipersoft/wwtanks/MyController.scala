package pl.snipersoft.wwtanks

import org.springframework.web.bind.annotation.{GetMapping, RestController}

@RestController
class MyController {
  @GetMapping(Array("/hello", "/"))
  def hello(): String = "Witaj kolego"

}

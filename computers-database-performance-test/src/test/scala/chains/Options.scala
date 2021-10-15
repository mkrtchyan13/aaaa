package chains

import io.gatling.http.Predef._
import io.gatling.core.Predef._

class Options {

  def getSimpleHeader() : Map[String, String] = {
    val headers = Map(
      "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
      "Content-Type" -> "text/html; charset=UTF-8",
      "Accept-Encoding" -> "gzip, deflate, sdch",
      "Accept-Language" -> "en-US,en;q=0.8",
      "Cache-Control" -> "max-age=0",
      "Connection" ->  "keep-alive")
    headers
  }

  def modifyHeader():Map[String, String] = {
    val headers = Map(
      "Accept" -> "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
      "Content-Type" -> "application/x-www-form-urlencoded",
      "Accept-Encoding" -> "gzip, deflate, sdch",
      "Accept-Language" -> "en-US,en;q=0.8",
      "Cache-Control" -> "max-age=0",
      "Connection" ->  "keep-alive")
    headers
  }

  def getHttpProtocol = {

    val httpProtocol = http
      .baseUrl("http://computer-database.gatling.io")
      .inferHtmlResources(BlackList(""".*\.js""", """.*\.css""", """.*\.gif""", """.*\.jpeg""", """.*\.jpg""", """.*\.ico""", """.*\.woff""", """.*\.woff2""", """.*\.(t|o)tf""", """.*\.png""", """.*detectportal\.firefox\.com.*"""), WhiteList())
      .upgradeInsecureRequestsHeader("1")
      .userAgentHeader("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/94.0.4606.71 Safari/537.36")
    httpProtocol
  }

}

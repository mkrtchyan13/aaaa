package chains

import io.gatling.core.Predef._
import io.gatling.http.Predef._

class SearchChain {

  val option = new Options

  val openAplication = {

    exec(http("open aplication")
      .get("/computers")
      .headers(option.getSimpleHeader())
        .check(status.is(200)))
  }


  val searchComputers = {

    exec(http("search computers")
      .get("/computers?f=ASCI+Red")
        .headers(option.getSimpleHeader())
        .check(status.is(200)))
  }

  val modifyComputers = {

    exec(http("Modify Computers")
      .post("/computers/382")
      .headers(option.modifyHeader())
      .formParam("name", "ASCI Red")
      .formParam("introduced", "2021-01-01")
      .formParam("discontinued", "")
      .formParam("company", "1"))
  }
}

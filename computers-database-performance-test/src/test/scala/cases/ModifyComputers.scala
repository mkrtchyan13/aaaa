package cases

import chains.{Options, SearchChain}
import io.gatling.core.Predef._
import io.gatling.core.scenario.Simulation
import io.gatling.http.Predef._

class ModifyComputers extends  Simulation{

  val searchChain = new SearchChain
  val options = new Options

  val scn = scenario("Search and modify computers").exec(searchChain.openAplication, searchChain.searchComputers, searchChain.modifyComputers)

  setUp(scn.inject(rampUsers(10).during(5))).protocols(options.getHttpProtocol)
}

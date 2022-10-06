package syllogisms
package figure1

import propositions._

object Barbara extends Syllogism{

  type Major = (x: Entity) => x.M => x.P
  type Minor = (x: Entity) => x.S => x.M
  type Conclusion = (x: Entity) => x.S => x.P

  def proof(major: Major, minor: Minor): Conclusion =
    x => minor(x) andThen major(x)
}


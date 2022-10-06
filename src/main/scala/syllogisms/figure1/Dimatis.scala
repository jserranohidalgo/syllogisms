package syllogisms
package figure1

object Dimatis extends Syllogism {

  trait Major { val x: Entity; val value: (x.P, x.M) }
  type Minor = (x: Entity) => x.M => x.S
  trait Conclusion { val x: Entity; val value: (x.S, x.P) }

  def proof(major:  Major, minor: Minor): Conclusion = new Conclusion {
    val x: major.x.type = major.x
    val value = (minor(major.x)(major.value._2), major.value._1)
  }
}


/*
def celarent(p1: (x: Entity) => x.M => Not[x.P],
             p2: (x: Entity) => x.S => x.M):
                 (x: Entity) => x.S => Not[x.P] =
  x => p2(x) andThen p1(x)

def camestres(p1: (x: Entity) => x.P => x.M,
              p2: (x: Entity) => x.S => Not[x.M]):
                  (x: Entity) => x.S => Not[x.P] =
  x => xIsS => xIsP =>
    p2(x)(xIsS)(p1(x)(xIsP))

import reflect.Selectable.reflectiveSelectable

trait Premise1{
  val x: Entity; val value: (x.P, x.M)
}

trait Conclusion{ val x: Entity; val value: (x.S, x.P) }

def dimatis(//p1: Premise1 ,
            p1: { val x: Entity; val value: (x.P, x.M) },
            p2: (x: Entity) => x.M => x.S):
Exists{ val x: Entity; val value: (x.S, x.P) } =
{
  val x: p1.x.type = p1.x
  val value = (p2(p1.x)(p1.value._2), p1.value._1)
}
*/


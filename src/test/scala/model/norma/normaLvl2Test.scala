package cl.uchile.dcc.citric
package model.norma

class normaLvl2Test extends munit.FunSuite {
  private var normaTwo: NormaLvl2 = _

  override def beforeEach(context: BeforeEach): Unit = {
    normaTwo = new NormaLvl2()
  }

  test("Norma 2 must have correctly set its objectives") {
    assertEquals(normaTwo.normaLevel, 2)
    assertEquals(normaTwo.victoriesNeeded, 3)
    assertEquals(normaTwo.starsNeeded, 30)
  }
}


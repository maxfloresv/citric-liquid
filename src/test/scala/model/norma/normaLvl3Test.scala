package cl.uchile.dcc.citric
package model.norma

class normaLvl3Test extends munit.FunSuite {
  private var normaThree: NormaLvl3 = _

  override def beforeEach(context: BeforeEach): Unit = {
    normaThree = new NormaLvl3()
  }

  test("Norma 3 must have correctly set its objectives") {
    assertEquals(normaThree.normaLevel, 3)
    assertEquals(normaThree.victoriesNeeded, 6)
    assertEquals(normaThree.starsNeeded, 70)
  }
}


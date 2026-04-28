package repro

import kotlin.test.Test
import kotlin.test.assertEquals

class DaggerReproTest {

  @Test
  fun `re-abstracted property with parent default works in Dagger`() {
    val graph = DaggerDaggerKitchen.factory().create(
      food = listOf("eggs", "milk"),
      note = "don't eat the cake",
      chefName = "Gordon",
    )

    // Same pattern as Metro test, but Dagger correctly generates overrides
    assertEquals(listOf("eggs", "milk"), graph.food)
    assertEquals("don't eat the cake", graph.note)
    assertEquals("Gordon", graph.chefName)
  }
}

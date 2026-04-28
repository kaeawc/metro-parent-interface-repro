package repro

import dev.zacsweers.metro.createGraphFactory
import kotlin.test.Test
import kotlin.test.assertEquals

class MetroReproTest {

  @Test
  fun `re-abstracted property with parent default causes AbstractMethodError`() {
    val factory = createGraphFactory<MetroKitchen.Factory>()
    val graph = factory.create(
      food = listOf("eggs", "milk"),
      note = "don't eat the cake",
      chefName = "Gordon",
    )

    // These calls throw AbstractMethodError if Metro skipped the overrides
    assertEquals(listOf("eggs", "milk"), graph.food)
    assertEquals("don't eat the cake", graph.note)
    assertEquals("Gordon", graph.chefName)
  }
}

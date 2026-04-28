package repro

import dev.zacsweers.metro.DependencyGraph
import dev.zacsweers.metro.Provides

/**
 * Reproduces: Metro skips generating accessor overrides in the graph's $Impl
 * when a parent interface declaration has a default body, even if the graph
 * interface re-abstracts via `override val`.
 *
 * Result: AbstractMethodError at runtime when accessing the property on the graph.
 */

// Fridge defaults to empty
interface Fridge {
  val food: List<String>
    get() = emptyList()

  val note: String?
    get() = null
}

// Kitchen graph re-abstracts the fridge properties.
// Metro should generate overrides in $Impl for these, but because
// Fridge has default bodies, it may skip them.
@DependencyGraph
interface MetroKitchen : Fridge {
  override val food: List<String>
  override val note: String?

  val chefName: String

  @DependencyGraph.Factory
  interface Factory {
    fun create(
      @Provides food: List<String>,
      @Provides note: String?,
      @Provides chefName: String,
    ): MetroKitchen
  }
}

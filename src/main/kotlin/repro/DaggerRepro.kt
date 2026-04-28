package repro

import dagger.BindsInstance
import dagger.Component
import javax.inject.Named

@Component
interface DaggerKitchen : Fridge {
  override val food: List<String>

  @get:Named("note")
  override val note: String?

  @get:Named("chefName")
  val chefName: String

  @Component.Factory
  interface Factory {
    fun create(
      @BindsInstance food: List<String>,
      @BindsInstance @Named("note") note: String?,
      @BindsInstance @Named("chefName") chefName: String,
    ): DaggerKitchen
  }
}

abstract class PizzaCity(
    val neapolitianPizzaPrice: Double,
    val romanPizzaPrice: Double,
    val sicilianPizzaPrice: Double,
    val tyroleanPizzaPrice: Double
) {
    var neapolitianPizzaCount = 0
    var romanPizzaCount = 0
    var sicilianPizzaCount = 0
    var tyroleanPizzaCount = 0

    var checkCount = 0
    var checkDiscount = 0.0

    var coffeeCount = 0
    var coffeeRevenue = 0.0

    var coffeeNeapolitian = 0
    var coffeeRoman = 0
    var coffeeSicilian = 0
    var coffeeTyrolean = 0

    var sauceAcount = 0
    var sauceBcount = 0
    var sauceARevenue = 0.0
    var sauceBRevenue = 0.0

    abstract fun neapolitianPizzaSale()
    abstract fun romanPizzaSale()
    abstract fun sicilianPizzaSale()
    abstract fun tyroleanPizzaSale()

    fun showStatistics() {
        println("\n=== Статистика продаж ===")
        println("Неаполитанская пицца: $neapolitianPizzaCount шт.")
        println("Римская пицца: $romanPizzaCount шт.")
        println("Сицилийская пицца: $sicilianPizzaCount шт.")
        println("Тирольская пицца: $tyroleanPizzaCount шт.")

        val pizzaRevenue =
            neapolitianPizzaCount * neapolitianPizzaPrice +
                    romanPizzaCount * romanPizzaPrice +
                    sicilianPizzaCount * sicilianPizzaPrice +
                    tyroleanPizzaCount * tyroleanPizzaPrice

        println("Доход с пиццы: $pizzaRevenue руб.")
        println("Сумма скидок по чекам: $checkDiscount руб.")

        println("Продано кофе: $coffeeCount шт., выручка: $coffeeRevenue руб.")

        if (coffeeCount > 0) {
            println("Кофе по пиццам:")
            fun printCoffeeStat(name: String, sold: Int) {
                val total = coffeeCount
                val percent = if (total > 0) sold * 100.0 / total else 0.0
                println("  $name: $sold шт. (${String.format("%.1f", percent)}%)")
            }
            printCoffeeStat("Неаполитанская", coffeeNeapolitian)
            printCoffeeStat("Римская", coffeeRoman)
            printCoffeeStat("Сицилийская", coffeeSicilian)
            printCoffeeStat("Тирольская", coffeeTyrolean)
        }

        if (sauceAcount + sauceBcount > 0) {
            println("Продано соусов A: $sauceAcount шт., выручка: $sauceARevenue руб.")
            println("Продано соусов B: $sauceBcount шт., выручка: $sauceBRevenue руб.")
        }

        val totalRevenue = pizzaRevenue - checkDiscount + coffeeRevenue + sauceARevenue + sauceBRevenue
        println("Итоговая выручка: $totalRevenue руб.")

        val totalChecks = neapolitianPizzaCount + romanPizzaCount + sicilianPizzaCount + tyroleanPizzaCount
        if (totalChecks > 0) {
            val percentCheck = checkCount * 100.0 / totalChecks
            println("Процент клиентов, показывающих чек: ${String.format("%.1f", percentCheck)}%")
            println("Процент клиентов, не показывающих чек: ${String.format("%.1f", 100 - percentCheck)}%")
        }

        if (totalChecks > 0) {
            val percentCoffee = coffeeCount * 100.0 / totalChecks
            println("Процент клиентов, покупающих кофе: ${String.format("%.1f", percentCoffee)}%")
            println("Процент клиентов, отказывающихся от кофе: ${String.format("%.1f", 100 - percentCoffee)}%")
        }
    }
}
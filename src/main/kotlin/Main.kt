fun main() {
    val pizzaPeter = PizzaPeter(175.0, 241.5, 165.5, 215.0)
    val pizzaMoscow = PizzaMoscow(215.0, 250.5, 180.5, 240.0)
    val pizzaIrkutsk = PizzaIrkutsk(200.0, 260.0, 190.0, 230.0)

    var currentPizzaCity: PizzaCity

    while (true) {
        println("\nВыберите город:")
        println("1. Москва\n2. Санкт-Петербург\n3. Иркутск\n0. Выход")

        currentPizzaCity = when (readln()) {
            "1" -> pizzaMoscow
            "2" -> pizzaPeter
            "3" -> pizzaIrkutsk
            "0" -> break
            else -> { println("ERROR"); continue }
        }

        selectPizza(currentPizzaCity)
    }
}

private fun selectPizza(pizzaCity: PizzaCity) {
    println(
        "Выберите пиццу:\n" +
                "1. Неаполитанская\n2. Римская\n3. Сицилийская\n4. Тирольская\n0. Показать статистику"
    )
    when (readln()) {
        "1" -> { pizzaCity.neapolitianPizzaSale(); selectAddService(pizzaCity, "neapolitian") }
        "2" -> { pizzaCity.romanPizzaSale(); selectAddService(pizzaCity, "roman") }
        "3" -> { pizzaCity.sicilianPizzaSale(); selectAddService(pizzaCity, "sicilian") }
        "4" -> { pizzaCity.tyroleanPizzaSale(); selectAddService(pizzaCity, "tyrolean") }
        "0" -> pizzaCity.showStatistics()
        else -> println("ERROR")
    }
}

fun selectAddService(currentPizzaCity: PizzaCity, lastPizza: String) {
    if (currentPizzaCity is CheckPhoto) currentPizzaCity.showCheckPhoto()
    if (currentPizzaCity is Drink) {
        currentPizzaCity.drinkSale()
        when (lastPizza) {
            "neapolitian" -> currentPizzaCity.coffeeNeapolitian++
            "roman" -> currentPizzaCity.coffeeRoman++
            "sicilian" -> currentPizzaCity.coffeeSicilian++
            "tyrolean" -> currentPizzaCity.coffeeTyrolean++
        }
    }
    if (currentPizzaCity is PizzaIrkutsk) currentPizzaCity.selectSauce()
}
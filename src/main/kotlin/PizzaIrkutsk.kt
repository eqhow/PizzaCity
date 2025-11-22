class PizzaIrkutsk(
    neapolitianPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double,
    private val sauceAPrice: Double = 50.0,
    private val sauceBPrice: Double = 60.0
) : PizzaCity(neapolitianPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice), CheckPhoto, Drink {

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            println("Вам будет скидка 50 рублей")
            checkCount++
            checkDiscount += 50
        }
    }

    override fun drinkSale() {
        println("Вы будете кофе?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            println("С вас 200 рублей")
            coffeeCount++
            coffeeRevenue += 200.0
        }
    }

    fun selectSauce() {
        println("Выберите соус:")
        println("1. Сырный соус ($sauceAPrice)\n2. Кисло-сладкий соус ($sauceBPrice)")
        when (readln()) {
            "1" -> { sauceAcount++; sauceARevenue += sauceAPrice; println("Сырный соус добавлен в заказ") }
            "2" -> { sauceBcount++; sauceBRevenue += sauceBPrice; println("Кисло-сладкий соус добавлен в заказ") }
            else -> println("Соус не выбран")
        }
    }

    override fun neapolitianPizzaSale() { neapolitianPizzaCount++; println("Спасибо за покупку неаполитанской пиццы в Иркутске") }
    override fun romanPizzaSale() { romanPizzaCount++; println("Спасибо за покупку римской пиццы в Иркутске") }
    override fun sicilianPizzaSale() { sicilianPizzaCount++; println("Спасибо за покупку сицилийской пиццы в Иркутске") }
    override fun tyroleanPizzaSale() { tyroleanPizzaCount++; println("Спасибо за покупку тирольской пиццы в Иркутске") }
}
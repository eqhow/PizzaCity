class PizzaMoscow(
    neapolitianPizzaPrice: Double,
    romanPizzaPrice: Double,
    sicilianPizzaPrice: Double,
    tyroleanPizzaPrice: Double
) : PizzaCity(neapolitianPizzaPrice, romanPizzaPrice, sicilianPizzaPrice, tyroleanPizzaPrice), CheckPhoto {

    override fun showCheckPhoto() {
        println("У вас есть фотография чека?")
        println("1. Да\n2. Нет")
        if (readln() == "1") {
            println("Вам будет скидка 50 рублей")
            checkCount++
            checkDiscount += 50
        }
    }

    override fun neapolitianPizzaSale() { neapolitianPizzaCount++; println("Спасибо за покупку неаполитанской пиццы в Москве") }
    override fun romanPizzaSale() { romanPizzaCount++; println("Спасибо за покупку римской пиццы в Москве") }
    override fun sicilianPizzaSale() { sicilianPizzaCount++; println("Спасибо за покупку сицилийской пиццы в Москве") }
    override fun tyroleanPizzaSale() { tyroleanPizzaCount++; println("Спасибо за покупку тирольской пиццы в Москве") }
}
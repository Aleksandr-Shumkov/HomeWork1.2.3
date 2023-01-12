package ru.netology

fun main() {

    var num = 0
    val numLimit = 20
    var amount = 345
    var discountPermanent = false

    val percentDiscount = 5 //скидка в процентах
    val percentDiscountPermanent = 1  //скидка для постоянных покупателей
    val discount = 100 //скидка в рублях
    val limitMinDiscount = 1_000 // минимальный порог суммы для начала действия скидок
    val limitMaxDisсount = 10_000 //свыше этой суммы будет применяться скидка percentDiscount

    //Выводится набор стоимостей покупок с возможными вариациями сначала со скидками - потом без
    while (num < 20) {
        val discountFive = amount - amount * percentDiscount / 100

        val result = if (amount > limitMinDiscount && amount <= limitMaxDisсount)
            if (discountPermanent) (amount - discount) - (amount - discount) * percentDiscountPermanent / 100 else amount - discount
         else if (amount > limitMaxDisсount)
            if (discountPermanent) discountFive - discountFive * percentDiscountPermanent / 100 else amount - amount * percentDiscount / 100
         else
            amount
        
        println((if (!discountPermanent) "Нет скидки постоянному покупателю, " else "Есть скидка постоянному покупателю, ") + "Сумма покупки: " + amount + " ------ Cумма со скидками = " + result)

        if (num == numLimit - 1 && !discountPermanent) {
            num = 0
            amount = 345
            discountPermanent = true
        } else {
            num += 1
            amount += 725
        }
    }

}
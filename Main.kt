package parking

//val parkingSpots: Array<Int> = Array(20) { 0 }
const val error = "Sorry, a parking lot has not been created."

fun main() {
    var parkingLot: ParkingLot? = null
    var userInput = readln().split(" ")

    while (userInput[0] != "exit") {
        when (userInput[0]) {
            "create" -> {
                parkingLot = ParkingLot(userInput[1].toInt())
                println("Created a parking lot with ${parkingLot.parkingLotSize} spots.")
            }
            "park" -> parkingLot?.park(userInput[1], userInput[2]) ?: println(error)
            "leave" -> parkingLot?.leave(userInput[1].toInt()) ?: println(error)
            "status" -> parkingLot?.status() ?: println(error)
            "reg_by_color" -> parkingLot?.registrationsByColor(userInput[1]) ?: println(error)
            "spot_by_color" -> parkingLot?.spotByColor(userInput[1]) ?: println(error)
            "spot_by_reg" -> parkingLot?.spotByRegNumber(userInput[1]) ?: println(error)

        }
        userInput = readln().split(" ")
    }
}
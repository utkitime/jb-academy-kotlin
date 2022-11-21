package parking

class ParkingLot(var parkingLotSize: Int) {

    private val parkingSpots: Array<Car?> = Array(parkingLotSize) { null }

    fun park(registrationNum: String, color: String) {
        val freeSpot = parkingSpots.indexOfFirst { it == null }
        if (freeSpot == -1) {
            println("Sorry, the parking lot is full.")
        } else {
            parkingSpots[freeSpot] = Car(registrationNum, color)
            println("$color car parked in spot ${freeSpot + 1}.")
        }
    }

    fun leave(spotNumber: Int) {
        if (parkingSpots[spotNumber - 1] == null) {
            println("There is no car in spot $spotNumber.")
        } else {
            parkingSpots[spotNumber - 1] = null
            println("Spot $spotNumber is free.")
        }
    }

    fun status() {
        var count = 0
        for (i in parkingSpots.indices) {
            if (parkingSpots[i] != null) {
                println("${i + 1} ${parkingSpots[i]?.registrationNum} ${parkingSpots[i]?.color}")
            } else {
                count++
            }
        }
        if (count == parkingLotSize) {
            println("Parking lot is empty.")
        }
    }

    fun registrationsByColor (color: String) {
        var output = ""
        for (i in parkingSpots.indices) {
            if (parkingSpots[i]?.color?.uppercase() == color.uppercase()) {
                output += if (output.isNotBlank()) {
                    ", ${parkingSpots[i]?.registrationNum}"
                } else {
                    parkingSpots[i]?.registrationNum
                }
            }
        }
        if (output.isBlank()) println("No cars with color $color were found.") else println(output)
    }

    fun spotByColor (color: String) {
        var output = ""
        for (i in parkingSpots.indices) {
            if (parkingSpots[i]?.color?.uppercase() == color.uppercase()) {
                output += if (output.isNotEmpty()) {
                    ", ${i + 1}"
                } else {
                    i + 1
                }
            }
        }
        if (output.isBlank()) println("No cars with color $color were found.") else println(output)
    }

    fun spotByRegNumber (registrationNum: String) {
        var output = 0
        for (i in parkingSpots.indices) {
            if (parkingSpots[i]?.registrationNum?.uppercase() == registrationNum.uppercase()) {
                output = i + 1
            }
        }
        if (output == 0) println("No cars with registration number $registrationNum were found.") else println(output)
    }

}
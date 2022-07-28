package ps.psp.digcom.pitestkotlintest

object RangeValidator {

    fun isValid(value: Double): Boolean {
        if (value > 0 && value < 50.0) {
            return true
        }

        return false
    }
}

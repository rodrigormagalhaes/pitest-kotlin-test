package ps.psp.digcom.pitestkotlintest

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class RangeValidatorTest {

    @Test
    fun `deve retornar true quando o valor for 1`() {
        val isValid = RangeValidator.isValid(1.0)

        Assertions.assertFalse(isValid)
    }

    @Test
    fun `deve retornar false quando o valor for 51`() {
        val isValid = RangeValidator.isValid(51.0)

        Assertions.assertFalse(isValid)
    }



    @ParameterizedTest
    @ValueSource(doubles = [0.0, 50.0, 51.0])
    fun `deve retornar false quando o valor estiver fora do range valido`(value: Double) {
        val isValid = RangeValidator.isValid(value)

        Assertions.assertFalse(isValid)
    }


}

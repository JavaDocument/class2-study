package level3.module.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class PrimeNumbersFinderTest {

    @Test
    void 소수_리스트_테스트() {
        // given
        final PrimeNumbersFinder primeNumbersFinder = PrimeNumbersFinder.newInstance();
        final int number = 10;
        // when

        final boolean[] isPrime = primeNumbersFinder.getPrimesInRangeFrom(number);

        // then
        Assertions.assertThat(isPrime[0]).isFalse();
        Assertions.assertThat(isPrime[1]).isFalse();
        Assertions.assertThat(isPrime[4]).isFalse();
        Assertions.assertThat(isPrime[6]).isFalse();
        Assertions.assertThat(isPrime[8]).isFalse();
        Assertions.assertThat(isPrime[9]).isFalse();
        Assertions.assertThat(isPrime[10]).isFalse();

        Assertions.assertThat(isPrime[2]).isTrue();
        Assertions.assertThat(isPrime[3]).isTrue();
        Assertions.assertThat(isPrime[7]).isTrue();

    }

}
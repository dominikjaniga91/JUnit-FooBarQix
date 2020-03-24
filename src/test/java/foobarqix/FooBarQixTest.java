package foobarqix;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import static org.junit.jupiter.api.Assertions.*;

public class FooBarQixTest {

    FooBarQix fooBarQix = new FooBarQix();


    @ParameterizedTest(name = "Should return provided number {0}")
    @DisplayName("Should return the same number when is not divisible or does not contains 3,5,7")
    @ValueSource(ints = {1,2,4,8,11,16,22})
    void shouldReturnNumber_whenNumberIsNotDivisibleOrContains357(int number){

        Assertions.assertThat(fooBarQix.returnAppropriateString(number)).isEqualTo(String.valueOf(number));
    }

   @ParameterizedTest(name = "Number {0} should return Foo")
   @DisplayName("Should return Foo number is divisible by 3 OR contains only one 3")
   @ValueSource(ints = {6,9,12,13,18,23,43})
    void shouldReturnFooString_whenNumberIsDivisibleOrContains3(int number){
        Assertions.assertThat(fooBarQix.returnAppropriateString(number)).isEqualTo("Foo");
    }

    @ParameterizedTest(name = "Number {0} should return Bar")
    @DisplayName("Should return Bar number is divisible by 5 OR contains only one 5")
    @ValueSource(ints ={52,58,59})
    void shouldReturnBarString_whenNumberIsDivisibleOrContains5(int number){
        Assertions.assertThat(fooBarQix.returnAppropriateString(number)).isEqualTo("Bar");
    }

    @ParameterizedTest(name = "Number {0} should return Qix")
    @DisplayName("Should return QixQix when number is divisible by 7 OR contains only one 7")
    @ValueSource(ints ={14,17,47,67,71,1171,11171})
    void shouldReturnBarString_whenNumberIsDivisibleOrContains7(int number){
        Assertions.assertThat(fooBarQix.returnAppropriateString(number)).isEqualTo("Qix");
    }

    @ParameterizedTest(name = "Number {0} should return FooFoo")
    @DisplayName("Should return FooFoo string when number is divisible by 3 AND contains only one 3")
    @ValueSource(ints ={3,93,132})
    void shouldReturnFooFooString_whenNumberIsDivisibleAndContains3(int number){
        Assertions.assertThat(fooBarQix.returnAppropriateString(number)).isEqualTo("FooFoo");
    }

    @ParameterizedTest(name = "Number {0} should return BarBar")
    @DisplayName("Should return BarBar string when number is divisible by 5 AND contains only on 5")
    @ValueSource(ints ={5,25,65,85,95})
    void shouldReturnBarBarString_whenNumberIsDivisibleAndContains5(int number){
        Assertions.assertThat(fooBarQix.returnAppropriateString(number)).isEqualTo("BarBar");
    }

    @Test
    @DisplayName("Should return QixQix when number is divisible by 7 AND contains only one 7")
    void shouldReturnQixQiXString_whenNumberIsDivisibleAndContains7(){
        Assertions.assertThat(fooBarQix.returnAppropriateString(7)).isEqualTo("QixQix");
    }

    @Test
    @DisplayName("Should return the same number but with asterisk in the place of zero")
    void shouldSwapZeroToAsterisk(){

        Assertions.assertThat(fooBarQix.returnAppropriateString(101)).isEqualTo("1*1");
    }

   @ParameterizedTest(name =" Given number equals to {0} should return string value equals to {1}")
   @DisplayName("Should return appropriate string after reading number from CSV")
   @CsvSource({
           "357, FooQixFooBarQix",
           "303, FooFoo*Foo",
           "105, FooBarQix*Bar",
           "10101, FooQix**",
           "107, *Qix",
           "733, QixFooFoo",
           "33, FooFooFoo"
   })
    void shouldReturnAppropriateString_afterReadingNumberFromCsvSource(int input, String expected) {

        String actual = fooBarQix.returnAppropriateString(input);
        assertEquals(expected, actual);
    }
}

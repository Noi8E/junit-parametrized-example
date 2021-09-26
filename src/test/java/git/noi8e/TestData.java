package git.noi8e;

import org.junit.jupiter.params.provider.Arguments;

import java.util.stream.Stream;

public class TestData {
    static Stream<Arguments> testWithMethodSource() {
        return Stream.of(
                Arguments.of(
                        0, "Экспресс"
                ),
                Arguments.of(
                        1, "Электроника"
                ),
                Arguments.of(
                        2, "Бытовая техника"
                ),
                Arguments.of(
                        3, "Компьютеры"
                ),
                Arguments.of(
                        4, "Детям"
                )
        );
    }
}

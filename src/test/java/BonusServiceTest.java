import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

public class BonusServiceTest {

    @Test
    void shouldCalculateForRegisteredAndUnderLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1000;
        boolean registered = true;
        long expected = 30;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void shouldCalculateForRegisteredAndOverLimit() {
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 1_000_000;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);

        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void checkLargeBoundaryValueRegistered() { // Проверяем пограничное превышение максимального бонуса у зарегистрирвоаннного пользователя на 1 рубль.
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 16_700;
        boolean registered = true;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void checkLargeBoundaryValueUnRegistered() { // Проверяем пограничное превышение максимального бонуса у незарегистрирвоаннного пользователя на 1 рубль.
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount =  50_100;
        boolean registered = false;
        long expected = 500;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void minimumBoundaryValueRegistered() { // Проверяем минимальное пограничное значение у зарегистрирвоаннного пользователя.
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 34;
        boolean registered = true;
        long expected = 1;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void minimumBoundaryValueUnegistered() { // Проверяем пограничное минимальное значение у незарегистрирвоаннного пользователя.
        BonusService service = new BonusService();

        // подготавливаем данные:
        long amount = 100;
        boolean registered = false;
        long expected = 1;

        // вызываем целевой метод:
        long actual = service.calculate(amount, registered);
        // производим проверку (сравниваем ожидаемый и фактический):
        Assertions.assertEquals(expected, actual);
    }

}
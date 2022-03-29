package Data;

import org.testng.annotations.DataProvider;

public class DataProviderClass {
    @DataProvider(name="DemoBlazeTest")
    public static Object [][] getUsers() {
        return new Object[][]
                {
                        {"julia1", "Argentina1", "Cordoba1", "visa", "marzo", "2022"},
                        {"julia2", "Argentina2", "Cordoba2", "visa", "marzo", "2022"},
                        {"julia3", "Argentina3", "Cordoba3", "visa", "marzo", "2022"},

                };
    }
}

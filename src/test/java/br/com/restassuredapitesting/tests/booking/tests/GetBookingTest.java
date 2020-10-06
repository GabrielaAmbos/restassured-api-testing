package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;

import static org.hamcrest.Matchers.greaterThan;

public class GetBookingTest extends BaseTest {

    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Listar ID's das reservas")
    public void validarIDsDasReservas() throws Exception{
        getBookingRequest.allBookings().then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }
}

package br.com.restassuredapitesting.tests.booking.tests;

import br.com.restassuredapitesting.runners.Acceptance;
import br.com.restassuredapitesting.runners.Contract;
import br.com.restassuredapitesting.tests.base.tests.BaseTest;
import br.com.restassuredapitesting.tests.booking.requests.GetBookingRequest;
import br.com.restassuredapitesting.utils.Utils;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.junit4.DisplayName;
import org.junit.Test;
import org.junit.experimental.categories.Category;

import java.io.File;

import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;
import static org.hamcrest.Matchers.greaterThan;

@Feature("Reservas")
public class GetBookingTest extends BaseTest {

    GetBookingRequest getBookingRequest = new GetBookingRequest();

    @Test
    @Severity(SeverityLevel.NORMAL)
    @Category(Acceptance.class)
    @DisplayName("Listar ID's das reservas")
    public void validarIDsDasReservas() throws Exception{
        getBookingRequest.allBookings().then()
                .statusCode(200)
                .body("size()",greaterThan(0));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Category(Contract.class)
    @DisplayName("Garantir o contrato de retorno da lista de reservas")
    public void garantirContratoListaReservas() throws Exception {
        getBookingRequest.allBookings().then()
                .statusCode(200)
                .assertThat()
                .body(
                        matchesJsonSchema(
                            new File(
                                Utils.getContractsBasePath("booking", "bookings")
                            )
                        )
                );
    }
}

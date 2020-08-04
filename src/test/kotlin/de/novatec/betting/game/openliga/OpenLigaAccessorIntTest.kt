package de.novatec.betting.game.openliga

import io.quarkus.test.common.QuarkusTestResource
import io.quarkus.test.junit.QuarkusTest
import org.eclipse.microprofile.rest.client.inject.RestClient
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import utils.classification.IntegrationTest
import javax.inject.Inject

@IntegrationTest
@QuarkusTest
@QuarkusTestResource(WiremockMatchDay::class)
class OpenLigaAccessorIntTest {

    @RestClient
    @Inject
    lateinit var openLigaAccessor: OpenLigaAccessor

    @Test
    fun `GET - requests the current match day from the openliga api`() {
        val result = openLigaAccessor.getCurrentMatchDay()
        assertThat(result.size).isEqualTo(1)
        assertThat(result[0].matchID).isEqualTo(55574L)
    }
}

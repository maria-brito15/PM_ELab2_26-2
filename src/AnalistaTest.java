import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class AnalistaTest {

    @Test
    public void registrarPagamentoCorretamente() {
        Analista analista = new Analista("Duda", "123.456.789-00");
        double pagamento = analista.registrarPagamento();

        assertEquals(analista.ultimoSalario, pagamento, 0.2);
    }

    @Test
    public void adicionarHorasExtrasCorretamente() {
        Analista analista = new Analista("Duda", "123.456.789-00");

        double qntdHoras = 25;
        double horasExtras = analista.addHorasExtras(qntdHoras);

        assertEquals(horasExtras, qntdHoras, 0.1);
    }
}

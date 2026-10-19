import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

/** 
 * MIT License
 *
 * Copyright(c) 2026 João Caram <caram@pucminas.br>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

/**
 * @author João Caram - caram@pucminas.br
 * Utilização do Copilot para geração de documentação da classes.  
 */

/**
 * Representa um projeto com data de início, possível data de término e nome.
 * <p>
 * O projeto pode ser finalizado e permite consultar há quantos dias foi
 * finalizado.
 * </p>
 */
public class Projeto {

	private LocalDate iniciadoEm;
	private LocalDate finalizadoEm;
	private String nome;

	/**
	 * Cria um novo projeto.
	 * <p>
	 * Se a data de início for nula, utiliza a data atual.
	 * Se o nome for vazio, utiliza o nome padrão {@code "Projeto"}.
	 * </p>
	 *
	 * @param nome       nome do projeto
	 * @param dataInicio data de início do projeto
	 */
	public Projeto(String nome, LocalDate dataInicio) {
		if (dataInicio == null)
			dataInicio = LocalDate.now();

		if (nome.length() == 0)
			nome = "Projeto";

		iniciadoEm = dataInicio;
		this.nome = nome;
	}

	/**
	 * Finaliza o projeto na data atual.
	 *
	 * @return quantidade de dias entre o início e a finalização do projeto
	 */
	public int finalizar() {
		finalizadoEm = LocalDate.now();
		return (int) iniciadoEm.until(finalizadoEm, ChronoUnit.DAYS);
	}

	/**
	 * Informa há quantos dias o projeto foi finalizado.
	 *
	 * @return quantidade de dias desde a finalização, ou {@code -1} se o projeto
	 *         ainda não foi finalizado
	 */
	public int diasAposFinalizacao() {
		LocalDate hoje = LocalDate.now();
		return (int) finalizadoEm.until(hoje, ChronoUnit.DAYS);
	}

	/**
	 * Retorna uma representação textual do projeto com nome e datas.
	 *
	 * @return descrição textual do projeto
	 */
	@Override
	public String toString() {
		DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/uuuu");
		String inicio = formatador.format(iniciadoEm);
		String fim = finalizadoEm == null ? "(não terminado)." : formatador.format(finalizadoEm);
		return String.format("Projeto %s, de %s até %s ", nome, inicio, fim);
	}
}
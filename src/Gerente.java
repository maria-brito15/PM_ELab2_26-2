
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
 * Representa um gerente da empresa.
 * <p>
 * O gerente possui salário fixo e pode receber bônus adicionais
 * com base em projetos alocados e finalizados em um intervalo de tempo específico.
 * </p>
 */
import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

public class Gerente extends Funcionario {

	private static final double SALARIO_GERENTE = 8060;
	private static final double BONUS_PROJETO = 8.0 / 100;
	private static final int TEMPO_BONUS = 90;
	private List<Projeto> projetos;

	/**
	 * Cria um novo gerente.
	 *
	 * @param nome nome do gerente
	 * @param CPF  CPF do gerente
	 */
	public Gerente(String nome, String CPF) {
		super(nome, CPF);
		projetos = new LinkedList<>();
	}

	/**
	 * Calcula o valor total de bônus do gerente com base nos projetos finalizados
	 * segundo as regras da empresa.
	 *
	 * @return valor total do bônus
	 */
	private double valorBonus() {
		int totalProjetos = projetos.size();
		int projetosFinalizados = 0;

		double bonus = 0;

		for (int i = 0; i < totalProjetos; i++) {
			Projeto projeto = projetos.get(i);

			if (projeto.diasAposFinalizacao() <= TEMPO_BONUS) {
				projetosFinalizados++;
			}
		}

		bonus = BONUS_PROJETO * projetosFinalizados;
		return bonus;
	}

	/**
	 * Aloca um novo projeto ao gerente, segundo as regras da empresa.
	 *
	 * @param projeto projeto a ser alocado
	 */
	public int alocarProjeto(Projeto projeto) {
		int qntdProjetos = projetos.size();
		boolean podeAlocar = true;
		int NAO_PODE = -1;

		for (Projeto p : projetos) {
			if (p.diasAposFinalizacao() == -1)
				podeAlocar = false;
		}

		return (podeAlocar) ? qntdProjetos : NAO_PODE;
	}

	/**
	 * Registra o pagamento do gerente, incluindo salário base e bônus por projeto.
	 *
	 * @return valor total pago ao gerente
	 */
	public double registrarPagamento() {
		ultimoSalario = SALARIO_GERENTE + valorBonus();
		return ultimoSalario;
	}

	/**
	 * Retorna uma descrição textual do gerente, incluindo quantidade de projetos
	 * alocados.
	 *
	 * @return descrição textual do gerente
	 */
	@Override
	public String toString() {
		return "GERENTE " + super.toString() + " - " + projetos.size() + " projetos alocados.";
	}
}
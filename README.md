#Lista de Tarefas 7 - Programação Orientada a Objetos (POO) em Java
Este repositório contém as soluções para os exercícios da "Lista de Tarefas 7" de POO em Java. A atividade tem como objetivo praticar conceitos essenciais como encapsulamento, herança, polimorfismo, interfaces, classes abstratas, imutabilidade, generics e padrões de design.

Exercícios e Conceitos Abordados
Exercício 1: Encapsulamento (Classe Produto)

Descrição: Implementa a classe Produto com atributos privados (nome, preco, quantidadeEmEstoque).


Conceitos: Uso de getters e setters para controle de acesso, com validações para garantir que o preço e a quantidade não sejam negativos e que o nome não seja nulo ou vazio. As validações lançam 

IllegalArgumentException em casos inválidos.

Exercício 2: Encapsulamento com Validação de Regra (Desconto)

Descrição: Adiciona o método aplicarDesconto(double porcentagem) à classe Produto.

Conceitos: Aplicação de regras de negócio dentro da classe. O método aceita descontos apenas entre 

0% e 50%, lançando uma exceção caso a regra seja violada.

Exercício 3: Herança (Hierarquia de Funcionários)

Descrição: Cria a classe base Funcionario e as subclasses Gerente e Desenvolvedor.


Conceitos: Demonstra a herança de atributos e o polimorfismo com a sobrescrita do método calcularBonus(). O bônus é de 20% para gerentes e 10% para desenvolvedores.

Exercício 4: Polimorfismo com Interface (IMeioTransporte)

Descrição: Define a interface IMeioTransporte com os métodos acelerar() e frear(). As classes 

Carro, Bicicleta e Trem implementam essa interface, cada uma com sua própria lógica de velocidade.

Conceitos: Uso de interfaces para definir um contrato de comportamento. O programa demonstra 

polimorfismo ao iterar sobre uma lista de IMeioTransporte.

Exercício 5: Abstração (Sistema de Pagamentos)

Descrição: Implementa a classe abstrata FormaPagamento com métodos validarPagamento() e processarPagamento(). As classes 

CartaoCredito, Boleto e Pix estendem a classe base, cada uma com suas validações e lógicas de processamento.


Conceitos: Uso de classes abstratas para definir uma estrutura comum e polimorfismo para simular o uso de cada forma de pagamento.

Exercício 6: Imutabilidade e Objetos de Valor (Carrinho de Compras)

Descrição: Cria um objeto de valor imutável Dinheiro (com BigDecimal e enum Moeda). A classe 


Carrinho é modelada para que suas operações (adicionar, remover, aplicarCupom) retornem um novo objeto em vez de modificar a instância atual.


Conceitos: Imutabilidade em classes, uso de equals() e hashCode() para objetos de valor e validação de regras de negócio (ex.: limite de 30% para cupons).


Exercício 7: Generics (Repositório Genérico em Memória)

Descrição: Define uma interface IRepository com métodos genéricos (salvar, buscarPorId, listarTodos, remover). A classe 

InMemoryRepository implementa essa interface usando um Map.


Conceitos: Uso de generics para criar um repositório que pode ser usado com qualquer tipo de entidade, desde que ela implemente a interface Identificavel.

Exercício 8: Padrão Strategy (Cálculo de Frete)

Descrição: Modela o cálculo de frete com o padrão de design Strategy. A interface 

CalculadoraFrete define a estratégia, e as classes Sedex, Pac e RetiradaNaLoja a implementam.



Conceitos: Demonstra a injeção e troca de estratégia em tempo de execução. O exercício também inclui a implementação de uma estratégia promocional usando uma 


lambda.

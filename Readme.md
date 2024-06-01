Sistema de Reservas de Hotel

Este é um simples sistema de reservas de hotel implementado em Java, usando um HashMap para armazenar as reservas.

Funcionalidades:

- Inserir novas reservas de forma eficiente, incluindo nome do hotel, número do quarto, data de check-in e data de check-out.
- Recuperar detalhes de uma reserva rapidamente usando o código único da reserva.
- Ver todas as reservas existentes.
- Remover reservas de forma eficiente após o check-out ou cancelamento.

Requisitos:

- JDK (Java Development Kit) instalado
- IDE Java (opcional)

Execução:

1. Clone o repositório para sua máquina local:

git clone https://github.com/seu-usuario/sistema-reservas-hotel.git

2. Navegue até o diretório do projeto:

cd sistema-reservas-hotel

3. Compile os arquivos Java:

javac *.java

4. Execute o programa:

java Hotel

5. Siga as instruções no console para utilizar o sistema de reservas de hotel.

Exemplo de Uso:

- Inserir nova reserva:
  Opções:
  1. Inserir nova reserva
  2. Ver todas as reservas
  3. Procurar reserva pelo código
  4. Remover reserva
  5. Sair
  Escolha uma opção: 1
  Inserir nova reserva:
  Nome do hotel: Hotel ABC
  Número do quarto: 101
  Data de check-in (yyyy-mm-dd): 2024-06-01
  Data de check-out (yyyy-mm-dd): 2024-06-05
  Reserva inserida com sucesso! Código da reserva: 123456789

- Procurar reserva pelo código:
  Opções:
  1. Inserir nova reserva
  2. Ver todas as reservas
  3. Procurar reserva pelo código
  4. Remover reserva
  5. Sair
  Escolha uma opção: 3
  Digite o código da reserva: 123456789
  Reserva encontrada:
  Código da Reserva: 123456789
  Nome do Hotel: Hotel ABC
  Número do Quarto: 101
  Data de Check-in: 2024-06-01
  Data de Check-out: 2024-06-05

Contribuindo:

Contribuições são bem-vindas! Abra uma issue ou envie um pull request com suas sugestões, melhorias ou correções.

Licença:

Este projeto está licenciado sob a MIT License.

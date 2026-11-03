# Sugestão de Integração — XAVi

Cartões CRC das classes do sistema XAVi (Xulambs Agência de Viagens), Programação Modular, PUC Minas.

## Cartões

| Classe | Cartão |
|---|---|
| Cliente | [CRC-Cliente.png](cartoes/CRC-Cliente.png) |
| Bilhete | [CRC-Bilhete.png](cartoes/CRC-Bilhete.png) |
| Voo | [CRC-Voo.png](cartoes/CRC-Voo.png) |
| Rota | [CRC-Rota.png](cartoes/CRC-Rota.png) |
| Cidade | [CRC-Cidade.png](cartoes/CRC-Cidade.png) |
| Agência | [CRC-Agencia.png](cartoes/CRC-Agencia.png) |

## Pré-visualização

![CRC Cliente](cartoes/CRC-Cliente.png)
![CRC Bilhete](cartoes/CRC-Bilhete.png)
![CRC Voo](cartoes/CRC-Voo.png)
![CRC Rota](cartoes/CRC-Rota.png)
![CRC Cidade](cartoes/CRC-Cidade.png)
![CRC Agência](cartoes/CRC-Agencia.png)

## Modelo do sistema

```mermaid
classDiagram
    class Agencia
    class Cliente
    class Bilhete
    class Voo
    class Rota
    class Cidade
    Agencia "1" --> "*" Cliente : cadastra
    Agencia "1" --> "*" Voo : cadastra
    Agencia "1" --> "*" Bilhete : vende
    Cliente "1" --> "*" Bilhete : compra
    Bilhete "1" --> "1..*" Voo : contém
    Voo "*" --> "1" Rota : segue
    Rota "*" --> "2" Cidade : origem e destino
```

## Regras principais

- Rota: código de quatro dígitos (dois da cidade de origem, dois da de destino).
- Voo: rota associada a uma data, com preço base e capacidade de 150 passageiros.
- Bilhete: voos encadeados (origem do seguinte = destino do anterior), no mesmo dia ou em dias consecutivos.
- Preço de venda: 60% do voo mais caro + 40% do segundo mais caro + 10% de cada voo adicional.
- Comissão da agência: 6% do valor dos bilhetes.

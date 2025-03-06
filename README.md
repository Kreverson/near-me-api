# points-of-interest
A api to find points of interests based on X and Y parameters

# Problema
Seu desafio será implementar um serviço para a empresa XY Inc., especializada na produção de excelentes receptores GPS (Global Positioning System). A diretoria está empenhada em lançar um dispositivo inovador que promete auxiliar pessoas na localização de pontos de interesse (POIs), e precisa muito de sua ajuda. Você foi contratado para desenvolver a plataforma que fornecerá toda a inteligência ao dispositivo. Esta plataforma deve ser baseada em serviços REST, para flexibilizar a integração.

# Requisitos
1. Cadastrar pontos de interesse, com 03 atributos: nome do POI, coordenada X (inteiro não negativo) e coordenada Y (inteiro não negativo).
2. Os POIs devem ser armazenados em uma base de dados.
3. Listar todos os POIs cadastrados.
4. Listar os POIs por proximidade. Este serviço receberá uma coordenada X e uma coordenada Y, especificando um ponto de referência, bem como uma distância máxima (d-max) em metros. O serviço deverá retornar todos os POIs da base de dados que estejam a uma distância menor ou igual a d-max a partir do ponto de referência.

# Exemplo
Considere a seguinte base de dados de POIs:

- 'Lanchonete' (x=27, y=12)
- 'Posto' (x=31, y=18)
- 'Joalheria' (x=15, y=12)
- 'Floricultura' (x=19, y=21)
- 'Pub' (x=12, y=8)
- 'Supermercado' (x=23, y=6)
- 'Churrascaria' (x=28, y=2)

Dado o ponto de referência (x=20, y=10) indicado pelo receptor GPS, e uma distância máxima de 10 metros, o serviço deve retornar os seguintes POIs:

- Lanchonete
- Joalheria
- Pub
- Supermercado

# Representação

![image](https://github.com/user-attachments/assets/b74775f1-dc75-4ec1-bae5-538d54ba038e)


O quadrado pontilhado se resumirá na query para o banco de dados através da busca baseada no ponto de interesse e na distância de 10 metros. Sendo assim, o x mínimo é = 10, o x máximo é igual a 30, o y mínimo é igual a 10 e o y máximo é igual a 20.

Neste caso, a query retornará a churrascaria, porém, para o refinamento da distância máxima dentro de um raio de 10 metros, deve-se aplicar a seguinte fórmula:
![image](https://github.com/user-attachments/assets/7c239185-a37c-4f73-95f9-067d3ccc8b6b)

Com isso, somente os pontos de interesse serão retornados.

# Instalação

1 - Executar o projeto

2 - Listar pontos de interesse
```
curl --request GET \
  --url http://localhost:8080/points-of-interests \
  --header 'content-type: application/json'
```

3 - Buscar pontos de interesse próximos
```
curl --request GET \
  --url 'http://localhost:8080/near-me?x=20&y=10&dmax=6'
```

4 - Adicionar novos pontos de interesse

```
curl --request POST \
  --url http://localhost:8080/points-of-interests \
  --header 'content-type: application/json' \
  --data '{
  "name": "Mercado",
  "x": 10,
  "y": 0
}'

```


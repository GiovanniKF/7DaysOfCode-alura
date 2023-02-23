# 7DaysOfCode - Java
![Logo 7DaysOfCode](/img/7days_of_code.png)

# Dia 1
O projeto consiste em criar uma requisição GET para consumir uma API de filmes (IMDB), buscando os melhores 250 filmes e imprimindo-os no console.
Para conseguir manipular no console e formatar o resultado utilizei o JSONObject que possui diversas funcionalidades.

# Dia 2
Agora precisei separar e listar alguns dados específicos que busquei anteriormente.
Para isso, fiz alguns métodos na classe 'GetMovie' para separar o título, url da imagem, ano e as avaliação utilizando das funcionalidades do JSONObject.

![Print 1 - Métodos criados no dia 2](/img/print1.png)

# Dia 3
O desafio agora foi juntar as listas dos dados extraídos de cada lista, fazendo uma única lista de filmes.
Para fazer essa lista criei um método que adicionasse cada elemento das outras listas em cada entrada.

![Print 2 - Método criado no dia 3](/img/print2.png)

# Dia 4
No dia 4 precisei gerar um HTML com todos os dados coletados.
Utilizando o PrintWriter criei um arquivo HTML e utilizei Bootstrap para estilizar a página com os filmes.

# Dia 5
Neste quinto dia o desafio foi encapsular a chamada de API. Além disso foi encapsulado também o código que faz o parseamento do JSON, assim foram criadas 2 novas classes no projeto (ImbdApiClient e br.com.alura.desafio.main.Movie).

# Dia 6
No sexto dia foi implementadas interfaces para colocarmos em algumas classes, assim deixando o código mais organizado e garantindo que a estrutura esteja de acordo com a que queremos.
Também foi feito o exercício extra que consistia em consumir a API da Marvel para pegarmos dados de alguns quadrinhos e criar uma nova página como a de Filmes.

# Dia 7
O último desafio foi implementar a ordenação de elementos através dos métodos da 'Collections'. Para isso implementamos a interface 'Comparable' na classe (record) 'Movie' e 'Series', implementando o método compareTo.
Por fim, no exercício extra foi pedido para juntar as duas listas de filmes e da Marvel utilizando a API de 'Streams'.

# Conclusão
Esse desafio foi essencial para recapitular todo o aprendizado obtido na Formação 'Java e Orientação a Objetos'. O projeto foi bem desafiador e com isso consegui aprender cada vez mais utilizando documentações de bibliotecas e do próprio JavaDoc.

![Print 3 - Página criada de top 250 filmes](/img/print3.png)
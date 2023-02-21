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
Neste quinto dia o desafio foi encapsular a chamada de API. Além disso foi encapsulado também o código que faz o parseamento do JSON, assim foram criadas 2 novas classes no projeto (ImbdApiClient e Movie).

# testJava

Observacoes:
Atualmente e por algum tempo trabalho com Spring Boot (versao 4 -- 1.5.8-Release).
Nao possuo conhecimento em EJB, mas dei uma olhada e entendi um pouco da logica de comunicacao, estados dos Beans e etc.
Nao possuo conhecimento em JSF e JSP. Trabalho com angularJS no Frontend Spring Boot no Backend; toda comunicao e troca de dados ocorre em JSON.

Ah, ia esquecendo. Ambos os codigos foram feitos no Eclipse. Dá pra importar o projeto por lá se ficar mais facil de executar ;)

Resposta do teste:
1-A
2-B
3-C
4-E
5-C
6-Certo-C
7-Errado-E



Baixar o projeto:
-- git clone https://github.com/luizlucca/testJava.git

Para compilar o projeto dos numeros e executar(questao 8):

-- cd /testJava/Numbers

-- mkdir build

-- javac -d build/ src/com/lcl/MainNumbers.java

-- cd build/

-- jar cvf number.jar *

-- java -classpath number.jar com.lcl.MainNumbers

Para compilar o projeto da arvore binaria e executar(questao 9):

-- /testJava/Numbers

-- mkdir build

-- javac -d build/ src/com/lcl/*.java

-- cd build/

-- jar cvf btree.jar *

-- java -classpath btree.jar com.lcl.BTreeApplication

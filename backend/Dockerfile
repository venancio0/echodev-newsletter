# Usa a imagem do OpenJDK 23
FROM openjdk:23-jdk

# Define o diretório de trabalho dentro do container
WORKDIR /app

# Copia o arquivo JAR já empacotado da máquina host para o container
COPY target/*.jar app.jar

# Expõe a porta 8080
EXPOSE 8080

# Comando correto para rodar o JAR
ENTRYPOINT ["java", "-jar", "app.jar"]

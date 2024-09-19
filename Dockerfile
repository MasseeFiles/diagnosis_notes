##################### DOCKERFILE diagnosis_note ####################

#################### STAGE 1 : Construction du projet ##########################

# Definition de l'image de base
FROM maven AS build

# Definition du fichier de travail dans le container
WORKDIR /diagnosis_note

# Copie du pom et du code source dans le fichier de travail
COPY pom.xml /diagnosis_note
COPY src /diagnosis_note/src

# Copier le fichier application.properties dans l'image
COPY src/main/resources/application.properties /diagnosis_note

# Package de l'appli (sans execution des tests - DskipTests)
RUN mvn clean package -DskipTests



#################### STAGE 2 : Execution de l'appli ####################
FROM openjdk:21-jdk-slim

WORKDIR /diagnosis_note

# Copie du fichier packagé (jar) vers le fichier de travail
COPY --from=build /diagnosis_note/target/diagnosis_notes-0.0.1-SNAPSHOT.jar diagnosis_note.jar

# Exposition du port d'accès à l'appli
EXPOSE 8083

#RUN de l'appli (par defaut au demarrage du container)
ENTRYPOINT ["java", "-Dspring.config.location=classpath:/application.properties", "-jar", "diagnosis_note.jar"]







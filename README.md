# DIAGNOSIS APP
# _Microservice NOTE_

DIAGNOSIS est une application d'aide à la détection du diabète de type 2 comportant 5 microservices (Gateway, View, Patient, Risk et Note). Le microservice NOTE a pour rôle de gérer les notes médicales des patients. Il expose pour cela des endpoints REST accessibles aux autres microservices de l'appli.

### Persistence des données
Le microservice utilise une base NoSQL pour la persistence des données (MongoDB).

### Port
Le microservice NOTE est exposé sur le port 8083

### Docker

Le microservice comporte un fichier Dockerfile à la racine du projet pour la création de son image DOCKER.
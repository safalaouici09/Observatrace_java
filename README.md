README \- TP3: Introduction to Software Logging and Observability

**Table des matières**  
Introduction  
Prérequis  
Installation  
Utilisation  
Structure du Code  
Conclusion

**Introduction**  
Ce projet implémente une gestion des produits et des profils utilisateurs à travers un menu interactif, permettant de :  
Ajouter, afficher et supprimer des produits.  
Ajouter des actions à des utilisateurs (comme visualiser, ajouter ou supprimer un produit).  
Sauvegarder des profils utilisateurs avec leurs actions.  
Analyser un fichier de log pour récupérer les actions des utilisateurs.

Le projet comprend 5 parties principales :  
Gestion des produits : ajout, suppression, et mise à jour.  
Gestion des profils utilisateurs : création, affichage, et ajout d'actions.  
Parser un fichier de log pour extraire les actions des utilisateurs.  
Sauvegarder les profils utilisateurs.  
Interaction avec l'utilisateur à travers un menu textuel.

### **Prérequis**

Avant d'exécuter ce projet, vous devez avoir installé les éléments suivants :

* **Java 11** ou supérieur (JDK)  
* Un **IDE** (IntelliJ IDEA, Eclipse ou Visual Studio Code avec le plugin Java)  
* Un **système d'exploitation** compatible : Windows, MacOS ou Linux

### **Installation**

1. **Téléchargement et extraction du projet**  
   * Téléchargez le fichier ZIP contenant le projet.  
   * Extrayez son contenu dans un répertoire sur votre ordinateur.  
2. **Configuration dans un IDE**  
   * Ouvrez le projet dans un IDE comme IntelliJ IDEA, Eclipse ou VS Code.  
   * Assurez-vous que le projet est configuré pour utiliser **Java 11**.  
   * Identifiez la classe principale `Main.java`, située dans le répertoire `src/main/java`.

### 

### **Exécution du programme**

1. **Depuis l'IDE**  
   * Localisez la classe principale `Main.java`.  
   * Cliquez sur "Run" (ou utilisez le raccourci correspondant dans votre IDE) pour démarrer le programme.  
2. **Depuis la ligne de commande**  
   * Naviguez dans le répertoire contenant les fichiers sources après avoir extrait le ZIP.

Compilez les fichiers Java avec la commande suivante :  
bash  
Copier le code  
`javac -d out src/main/java/*.java`

Exécutez le programme avec cette commande :  
bash  
Copier le code  
`java -cp out Main`



**Utilisation**  
Menu principal  
Le programme affiche un menu avec les options suivantes :
### Menu principal

Le programme affiche un menu interactif avec les options suivantes :

1. **Afficher tous les produits** : Permet d'afficher la liste complète des produits actuellement disponibles dans le système.
2. **Récupérer un produit par ID** : Permet de récupérer et d'afficher un produit spécifique en entrant son identifiant unique (ID).
3. **Ajouter un nouveau produit** : Permet d'ajouter un produit au système en saisissant ses informations (nom, prix, description, etc.).
4. **Supprimer un produit par ID** : Permet de supprimer un produit du système en entrant son identifiant unique (ID).
5. **Mettre à jour un produit** : Permet de modifier les informations d'un produit existant, telles que son prix ou sa description, en entrant son identifiant unique (ID).
6. **Afficher tous les profils utilisateur** : Affiche la liste des profils utilisateurs et leurs actions associées.
7. **Ajouter une action à un utilisateur** : Permet d'ajouter une nouvelle action à un profil utilisateur, comme ajouter ou supprimer un produit, ou consulter un produit.
8. **Quitter** : Quitte le programme.

Lorsque le programme est exécuté, l'utilisateur est invité à choisir une option en entrant le numéro correspondant dans le menu. Le menu se répète jusqu'à ce que l'option "Quitter" soit sélectionnée.


**Conclusion**

Ce projet permet de gérer une collection de produits et d'associer des actions à des profils utilisateurs, tout en permettant l'interaction via un menu textuel. Il inclut également un mécanisme de parsing de logs pour récupérer les actions des utilisateurs à partir d'un fichier.

Ce projet peut être étendu pour inclure davantage de fonctionnalités, telles que l'intégration avec une base de données ou l'ajout d'un frontend pour une interface graphique.  



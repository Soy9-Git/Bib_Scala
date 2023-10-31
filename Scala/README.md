# Bib_Scala
**Gestionnaire de Bibliothèque :**

Ce programme est une application simple de gestion de bibliothèque écrite en Scala. 

Il permet aux utilisateurs d'ajouter de nouveaux livres, d'emprunter des livres, de les retourner, et de rechercher des livres.

**Fonctionnalités Principales :**

· Ajouter un nouveau livre : Les utilisateurs peuvent saisir le titre, l'auteur et l'année de publication d'un livre, puis l'ajouter à la bibliothèque.

· Emprunter un livre : Les utilisateurs peuvent emprunter un livre en fonction de son titre. S'il n'a pas encore été emprunté, il sera marqué comme emprunté.

· Retourner un livre : Les utilisateurs peuvent retourner un livre qu'ils ont emprunté, le marquant ainsi comme non emprunté.

· Rechercher un livre : Les utilisateurs peuvent rechercher des livres par titre ou par auteur, et consulter leurs informations.

**Fichiers Principaux :**

· Bibliothèque.scala : Contient la classe de gestion de bibliothèque Bibliothèque, qui définit les fonctionnalités telles que l'ajout, l'emprunt et le retour de livres.

· Livre.scala : Définit la classe de livre Livre, avec des attributs tels que le titre, l'auteur, et l'année de publication.

· Main.scala : Fichier principal du programme, contenant les menus interactifs et le démarrage et l'arrêt du programme.

**Remarques :**

·Lors de l'ajout d'un livre, si les informations saisies sont identiques à celles d'un livre déjà existant (y compris le titre, l'auteur et l'année de publication), le programme n'ajoutera pas de doublons.

·Lors de l'emprunt ou du retour d'un livre, veuillez vous assurer de saisir le titre du livre correctement.

·À la fermeture du programme, l'état actuel de la bibliothèque sera automatiquement enregistré dans le fichier livres.txt, et sera chargé lors du prochain démarrage du programme.

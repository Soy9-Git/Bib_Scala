object Main {
  def main(args: Array[String]): Unit = {

    // Créer une bibliothèque
    val bibliothèque = new Bibliothèque()
    bibliothèque.chargerLivres()

    // Interaction avec l'utilisateur
    println("Bienvenue à la bibliothèque !")
    var continuer = true

    while (continuer) {
      println("\nMenu:")
      println("1. Ajouter un livre")
      println("2. Emprunter un livre")
      println("3. Rendre un livre")
      println("4. Rechercher un livre")
      println("5. Quitter")
      print("Veuillez sélectionner une option : ")

      val choix = scala.io.StdIn.readInt()

      choix match {
        case 1 => // Ajouter un livre
          print("Titre du livre : ")
          val titre = scala.io.StdIn.readLine()
          print("Auteur du livre : ")
          val auteur = scala.io.StdIn.readLine()
          print("Année de publication : ")
          val année = scala.io.StdIn.readInt()

          val nouveauLivre = new Livre(titre, auteur, année)

          if (!bibliothèque.existeDeja(nouveauLivre)) {
            bibliothèque.ajouterLivre(nouveauLivre)
            println(s"Le livre '$titre' a été ajouté à la bibliothèque.")
          } else {
            println(s"Le livre '$titre' existe déjà dans la bibliothèque.")
          }

        case 2 => // Emprunter un livre
          print("Titre du livre à emprunter : ")
          val titre = scala.io.StdIn.readLine()
          bibliothèque.emprunterLivre(titre)

        case 3 => // Rendre un livre
          print("Titre du livre à rendre : ")
          val titre = scala.io.StdIn.readLine()
          bibliothèque.rendreLivre(titre)

        case 4 => // Rechercher un livre
          println("\n1. Rechercher par titre")
          println("2. Rechercher par auteur")
          print("Veuillez sélectionner une option : ")
          val rechercheOption = scala.io.StdIn.readInt()

          rechercheOption match {
            case 1 => // Rechercher pqr titre
              print("Titre du livre : ")
              val titre = scala.io.StdIn.readLine()
              bibliothèque.chercherLivreParTitre(titre) match {
                case Some(livre) =>
                  println(s"Le livre '$titre' a été trouvé dans la bibliothèque.")
                case None =>
                  println(s"Le livre '$titre' n'a pas été trouvé dans la bibliothèque.")
              }
            case 2 => // Rechercher par Auteur
              print("Auteur du livre : ")
              val auteur = scala.io.StdIn.readLine()
              val livresTrouvés = bibliothèque.chercherLivreParAuteur(auteur)
              if (livresTrouvés.nonEmpty) {
                println(s"Les livres de l'auteur '$auteur' ont été trouvés dans la bibliothèque:")
                livresTrouvés.foreach(livre => println(s"- ${livre.titre}"))
              } else {
                println(s"Aucun livre de l'auteur '$auteur' n'a été trouvé dans la bibliothèque.")
              }
            case _ => // Non valide
              println("Option non valide. Veuillez réessayer.")
          }

        case 5 => // Quitter
          continuer = false

        case _ => println("Option non valide. Veuillez réessayer.") // Non valide
      }
    }

    println("Merci d'avoir utilisé la bibliothèque !")

    // Sauvergarder le nouveau fichier
    sys.addShutdownHook {
      bibliothèque.sauvegarderLivres()
    }
  }
}
import scala.io.Source
import java.io.PrintWriter

// Définir la classe Bibliothèque avec l'attribut listeDeLivres
class Bibliothèque {
  var listeDeLivres: List[Livre] = List()

  // Méthode d'ajouterLivre
  def ajouterLivre(livre: Livre): Unit = {
    listeDeLivres = livre :: listeDeLivres
  }

  // Méthode d'emprunterLivre
  def emprunterLivre(titre: String): Unit = {
    val livreOption = listeDeLivres.find(_.titre == titre) // Rechercher les livres correspondant au titre

    livreOption match {
      case Some(livre) => // Si un livre correspondant est trouvé
        if (!livre.estEmprunté) {
          livre.emprunter()
          println(s"Le livre '$titre' a été emprunté.")
        } else {
          println(s"Le livre '$titre' est déjà emprunté.")
        }
      case None => // Si aucun livre correspondant n'est trouvé
        println(s"Le livre '$titre' n'a pas été trouvé dans la bibliothèque.")
    }
  }

  // Méthode de rendreLivre
  def rendreLivre(titre: String): Unit = {
    val livreOption = listeDeLivres.find(_.titre == titre) // Rechercher les livres correspondant au titre

    livreOption match {
      case Some(livre) => // Si un livre correspondant est trouvé
        if (livre.estEmprunté) {
          livre.rendre()
          println(s"Le livre '$titre' a été rendu.")
        } else {
          println(s"Le livre '$titre' n'est pas actuellement emprunté.")
        }
      case None => // Si aucun livre correspondant n'est trouvé
        println(s"Le livre '$titre' n'a pas été trouvé dans la bibliothèque.")
    }
  }

  // Méthode d'existeDeja pour déterminer l’ajout répété de livres.
  def existeDeja(livre: Livre): Boolean = {
    listeDeLivres.exists(l => l.titre == livre.titre && l.auteur == livre.auteur && l.annéeDePublication == livre.annéeDePublication)
  }

  // Méthode de chargerLivres pour reader le contenu de livres.txt
  def chargerLivres(): Unit = {
    val lines = Source.fromFile("src/livres.txt").getLines()

    for (line <- lines) {
      val Array(titre, auteur, année, emprunté) = line.split(',')
      val livre = new Livre(titre, auteur, année.toInt)
      if (emprunté == "true") {
        livre.emprunter()
      }
      ajouterLivre(livre)
    }
  }

  // Méthode de sauvergarderLivres dans livres.txt
  def sauvegarderLivres(): Unit = {
    val writer = new PrintWriter("src/livres.txt")

    for (livre <- listeDeLivres) {
      writer.println(s"${livre.titre},${livre.auteur},${livre.annéeDePublication},${livre.estEmprunté}")
    }

    writer.close()
  }

  def chercherLivreParTitre(titre: String): Option[Livre] = {
    listeDeLivres.find(_.titre == titre)
  }

  def chercherLivreParAuteur(auteur: String): List[Livre] = {
    listeDeLivres.filter(_.auteur == auteur)
  }
}
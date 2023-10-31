package Programme

// Définir la classe Livre avec les attributs : titre, auteur, annéeDePublication et estEmprunté.
class Livre(val titre: String, val auteur: String, val annéeDePublication: Int) {
  var estEmprunté: Boolean = false

  // Méthode d'emprunt, définissant estEmprunté à true
  def emprunter(): Unit = {
    estEmprunté = true
  }

  // Méthode de retour, définissant estEmprunté à false
  def rendre(): Unit = {
    estEmprunté = false
  }
}
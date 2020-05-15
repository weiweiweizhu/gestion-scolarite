# gestion-scolarite
Une promotion d'étudiants représente tous les étudiants d'une même classe
(CDA1, CDA2 ou CDA3 par exemple)
La scolarité gère un ensemble de promotions.
Développez les classes Promotion, Scolarite et Etudiant, autres ?
et proposez un menu qui permet de faire les actions suivantes :
- ajouter/supprimer/lister les promotions.
- ajouter un étudiant à une promotion existante. quand on crée un étudiant on demande à quelle promotion l'ajouter.
- supprimer un étudiant d'une promotion existante.
- retrouver un étudiants par son nom et prenom . ( afficher toutes ses informations + le nom de sa promotion )
- retrouver un étudiant par son id. ( afficher toutes ses informations + le nom de sa promotion )
- lister les étudiants d'une promotion dans l'ordre des noms puis prénoms puis id.
- ajouter des notes à un étudiant.
- afficher la moyenne des notes d'un étudiant.
- afficher la moyenne des notes d'une promotion.
Quand un étudiant est ajouté à une promotion, il faut tester que cet étudiant n'existe
pas déjà dans la promotion.
Concevez vos classe avant de les utiliser.
ultra plus, essayer de découvrir d'autres types de structures :
TreeMap<K,V>
TreeSet
ou autres
Contraintes :
- Un étudiant ne peut pas appartenir à 2 promotions différentes.
- Un étudiant est unique par son nom et prénom : 
-- exemple :
--- on peut avoir 2 étudiants différents ayant le même nom mais un prénoms différents
--- on ne peut pas avoir deux étudiants diffèrents ayant le même nom ET prénoms.
- la seule classe qui contient des syso et scanner est la classe Scolarite

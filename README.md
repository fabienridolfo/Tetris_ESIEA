# Tetris_ESIEA

Réalisé par RIDOLFO Fabien, PERRAUT Alexandre et ROUX Guillaume


Exercice SOLID :

1.	« Single Responsability Principle » (SRP)
Chaque classe dans notre conception a un seul rôle, en effet :  
-La classe « Format_Piece » Décrit la forme des mouvements de la pièce du jeu.
-La classe « Game_Logic » gère la logique du jeu.
-La classe « Link » assure le lien entre les deux classes et l’utilisateur.

2.	« Open Closed Principle » (OCP)
On a choisi de mettre dans la classe pièce que des attributs qui décrivent une pièce indépendamment du type du jeu « Format Pièce », ce qui veut dire que notre classe peut être utilisée dans d’autres contextes, il suffit de gérer les règles du jeu dans une autre classe, par exemple.


3.	« Dependency inversion principle » (DIP)
On peut appliquer ce principe si on souhaite utiliser la classe pièce dans plusieurs contextes différents, il suffit de créer une classe abstraite, par exemple si on veut les utiliser dans un jeu où les pièces ne peuvent pas tourner (un puzzle par exemple) alors la fonction rotate() va créer un problème, pour cela on peut utiliser une classe abstraite.



Les features utilisées sont : 


1.	Simple
2.	Object-Oriented : On a utilisé plusieurs classes et méthodes pour programmer le jeu.
3.	Platform Independent : grâce à la JVM et le byte code 
4.	Secured: No explicit pointerPrograms run inside virtual machine sandbox.

5.	Robust  exception handling and type checking
6.	Architecture neutral
7.	Portable : On a utilisé des packages

Pour jouer il suffit juste d'utiliser les touches directionnelles du clavier. En effet, la touche gauche et droite pour déplacer la piece horizontalement. Puis la flèche du haut pour la rotation horaire. 

Pour exécuter notre jeu : Vous pouvez utiliser l’IDE Eclipse. Puis, importer le projet et enfin faire un « update project », (ça correspond au maven install)


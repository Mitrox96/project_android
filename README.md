# AppMovie

Ce commit ne concerne pas le contenu du projet, juste des informations concernant celui-ci (rajouté après la deadline, car plus accessible qu'un mail avec les infos).

Partie entièrement fonctionnelle (première page du pdf) fait par Damien LOUBIOU :
---------------------------------------------------------
- Splash (vérification si un compte a déjà été créé -> redirection vers la home)
  sinon -> redirection vers page de création de compte

- Page choix création de compte : Bouton scanner QR code + bouton remplir formulaire manuellement

- Page remplir formulaire manuellement : Vérification si les champs sont bien tous remplis. Si c'est le cas, lorsqu'on appuie sur le bouton -> redirection home

- Page scan QR Code : Problème d'orientation bloquée à l'horizontale je n'ai pas réussi à forcer la verticale, mais fonctionnel, lorsque le scan est effectué, l'utilisateur est redirigé vers la page d'inscription manuelle
  avec tous les champs auto-complétés. Si l'utilisateur fait un retour à la page de choix d'inscription, alors une vérification fait que le formulaire est rénitialisé. Lorsque l'utilisateur valide l'inscription, il est redirigé sur la home.

- Page modifier compte : Fonctionnelle Optimisation faite pour éviter d'avoir une page création, et une page modification du compte. C'est la même pour les deux, mais le nom de la page et du boutons changent en fonction de si un compte existe ou non (pour
  vérifier si on est à l'étape de création ou de modification)

- Design des pages amélioré

Deuxième partie (deuxième page du pdf) fait par Dorian GRONER, Mateo LO PINTO, Noah PIESSE
-------------------------------------------------------
Des problèmes ont été rencontrés sur la deuxième partie du projet dû à une mauvaise organisations. En théorie fonctionnelle.

- 4 fragments relié à la HomeActivity
- Design complété
- Page qui fait appel au webservice pour avoir les films et leurs détails
- Map avec les salles de cinéma redirection vers une page détails, et bouton retour si besoin
- Page afficher logo avec des données préfaites car problème de compréhension de la bibliothèque
- Page panier avec les salles ajoutées.
- Nettoyage de l'app

Pour avoir la partie fonctionnelle, voir les commits qui datent du 4 février ou moins de Damien (nom des participants et travail réalisé ci-dessous.)
---------------------------------------------------------------------------------------------------------------------------------------------------

Mitrox96 = Damien LOUBIOU : **première partie** (Splash + page création compte + remplir formulaire manuellement + scan qrcode + modifier compte + design + home(bouton modifier compte))

Matelop132 = Matéo LO PINTO : **deuxième partie**  (Logo + nettoyage + afficher qrcode + fragment correspondant)

Dorianov = Dorian GRONER: **deuxième partie** (Finition webservice + Panier + Design + résolution de bugs + fragments + details)

Noah PIESSE pas précisé sur les commits car sa partie a été envoyée à Dorian à cause de problèmes techniques, donc Dorian a push sa partie et celle de Noah) : **deuxième partie** (Map + details + webservice + fragments)

# calculsodexo

MES NOTES

----------------------------------------------------------------------------------------------------

- Dans le cas d'une relation One to Many / Many to One, le coté non propriétaire (celui qui n'a pas de référence à l'autre) est annoté avec 
mapedBy = "nom_attribut_autre_classe". Le coté propriétaire, lui est annoté avec @ManyToOne @JoinColumn(name="colonne_id_autre")

- Le coté propriétaire (qui a la référence) ne peut exister sans le coté qui ne l'est pas (A VERIFIER). Il faut donc que l'entité non propriétaire soit persistée en 
premier. 

- Une fois persisté, l'entité non propriétaire peut ajouter des entité propriétaire dans son ensemble, MAIS elles doivent avoir en elle un lien a ladite entité. L'enregistrement peut se faire par l'entité non propriétaire ensuite

- Toutefois, il n'est uniquement possible que de rajouter un élément à la collection. Le fait de setX(null) ou même d'enlever les éléments persistés de la collection ne change pas. Ca me semble en contradiction avec le cascadeType...

- A VOIR transactionnal reste mystérieux ? j'ai besoin de transactionnal sinon erreur no session. 

----------------------------------------------------------------------------------------------------

A FAIRE 

- Gitignore de mon projet 

- l'algo de calcul des articles payable dans analyse 

- liste des articles payables Sodexo

- Creer une liste de course (classe result à creer, les apports seront pas complet surement. Il faut comparer tous les result et choisir le meilleur
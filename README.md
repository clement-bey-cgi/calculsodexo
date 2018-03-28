# calculsodexo

#MES NOTES
----------------------------------------------------------------------------------------------------
##**MAPPING** 

- Dans le cas d'une relation One to Many / Many to One, le coté non propriétaire (celui qui n'a pas de référence à l'autre) est annoté avec 
mapedBy = "nom_attribut_autre_classe". Le coté propriétaire, lui est annoté avec @ManyToOne @JoinColumn(name="colonne_id_autre")

##**PERSISTANCE** 

- Le coté propriétaire d'un One to Many / Many To One (qui a la référence) ne peut exister sans le coté qui ne l'est pas. Il faut donc que l'entité non propriétaire soit persistée en 
premier. 

- Une fois persisté, l'entité non propriétaire peut ajouter des entité propriétaire dans son ensemble, MAIS elles doivent avoir en elle un lien a ladite entité. L'enregistrement peut se faire par l'entité non propriétaire ensuite.

- Toutefois, il n'est uniquement possible que de rajouter un élément à la collection. Le fait de setX(null) ou même d'enlever les éléments persistés de la collection ne change pas. Ca me semble en contradiction avec le cascadeType...

- [CASCADE ET ORPHAN, la fin des soucis](http://blog.paumard.org/cours/jpa/chap03-entite-relation.html)

##**HISTOIRE DE SESSION**

- A VOIR transactionnal reste mystérieux ? j'ai besoin de transactionnal sinon erreur no session. 

- [Doc sympa sur le management des entité par JPA et Hibernate](https://www.thoughts-on-java.org/persist-save-merge-saveorupdate-whats-difference-one-use/)

----------------------------------------------------------------------------------------------------

#**A FAIRE**

- vérouillez les entrées utilisateur "au cas où"

- l'algo de calcul des articles payable dans analyse.

- Creer une liste de course (classe result à creer, les apports seront pas complet surement. Il faut comparer tous les result et choisir le meilleur

- Mode enervé : en cas de multiple solutions, on va chercher tous les articles qu'on sait remboursé
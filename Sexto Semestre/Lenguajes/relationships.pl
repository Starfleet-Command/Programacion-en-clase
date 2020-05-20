/*
Program to establish family relationships between persons
Source of the data:
    https://dragonball.fandom.com/wiki/Bardock
Gilberto Echeverria
02/10/2019
*/

% Facts
father(goku, gohan).
father(goku, goten).
father(bardock, goku).
father(bardock, raditz).
father(vegeta, trunks).
father(vegeta, bulla).
father(dr_brief, bulma).
father(ox_king, chichi).
father(king_vegeta, vegeta).
mother(gine, goku).
mother(gine, raditz).
mother(chichi, gohan).
mother(chichi, goten).
mother(bulma, trunks).
mother(bulma, bulla).
mother(panchy, bulma).
male(bardock).
male(raditz).
male(goku).
male(vegeta).
male(gohan).
male(goten).
male(trunks).
male(king_vegeta).
male(dr_brief).
male(ox_king).
female(gine).
female(chichi).
female(bulma).
female(bulla).
female(panchy).

% Rules
siblings(X, Y) :- 
    X\=Y,
    father(Z,X),
    father(Z,Y),
    mother(W,X),
    mother(W,Y).

brother(X, Y) :- 
    male(X),
    siblings(X,Y).

sister(X, Y) :-
    female(X),
    siblings(X,Y).

grandfather(X,Y) :-
    male(X),
    (father(X,Z),father(Z,Y)).

grandfather(X,Y) :-
    male(X),
    (father(X,Z),mother(Z,Y)).

grandmother(X,Y) :-
    female(X),
    mother(X,Z),
    father(Z,Y).

grandmother(X,Y) :-
    female(X),
    mother(X,Z),
    mother(Z,Y).

grandchild(X,Y) :-
    grandfather(Y,X).

grandchild(X,Y) :-
    grandmother(Y,X).

grandson(X,Y) :-
    male(X),
    grandchild(X,Y).

granddaughter(X,Y) :-
    female(X),
    grandchild(X,Y).

uncle(X,Y) :-
  
    brother(X,Z),
    father(Z,Y).

uncle(X,Y) :-
    
    brother(X,Z),
    mother(Z,Y).

aunt(X,Y) :-
    
    sister(X,Z),
    father(Z,Y).

aunt(X,Y) :-
    
    sister(X,Z),
    mother(Z,Y).


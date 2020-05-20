%Juan Francisco Gortarez Ricardez A01021926
%Programs for the may 22nd HW.

in_list([E|_],E). %Base case if equal

in_list([_|T],E):- %Recursive rule
    in_list(T,E).

in_list([], _) :- 
    !, fail. %Case to account for empty list


element_at(I1,[E|_],I1, E). % Base Case for indexes != 0

element_at(I,[_|T],I1,E):- %Recursive rule
    I>=0, 
    I2 is I1+1, 
    element_at(I,T,I2,E).
    

element_at(I,[_|T], I1, E):- %Turn negative indexes into positive indexes and send to recursion
    I<0,
    length([_|T],I2),
    I3 is I2+I,
    element_at(I3,[_|T],I1,E).

element_at(0,[E|_],E). %Base case when asking for index 0

element_at(I,[_|T],E):- %Entry function
    element_at(I,[_|T],0,E).
    


range(T,N2,I,L):- %Base Case if passed from above
    I>=0,
    L=[],
    T>=N2.

range(T,N2,I,L):- %Base Case if passed from below.
    I=<0,
    L=[],
    T=<N2.


range(T,N2,I,L):- %Recursive rule when approaching from more to less. 
    T1 is T + I,
    I=<0,
    T1>=N2,
    range(T1,N2,I,L1),
    L=[T|L1].

range(T,N2,I,L):- %Recursive rule when approaching from less to more
    T1 is T + I,
    I>=0,
    T1=<N2,
    range(T1,N2,I,L1),
    L=[T|L1].

remove_doubles([], []).   % Empty list is empty list 
remove_doubles([X], [X]). % Single element list is itself

%Recursive rule when same
remove_doubles([X,X|T], [X|R]) :-
    remove_doubles([X|T], [X|R]).

% Recursive rule when different
remove_doubles([X,Y|T], [X|R]) :-
    X \== Y,
    remove_doubles([Y|T], R).





    
How to use the programs:

SERVER:
1. Compile the server program using the Makefile
2. Before executing the client programs, start the server by doing ./Server [PORT NUMBER] on the Command Line where 
port number is any number over 2000 (otherwise it causes conflicts)

3. Your job here is done

CLIENT:
1. Compile the client program using the makefile
2. After starting the server, start the client by doing ./Client [IP_ADDRESS] [PORT_NUMBER] where port number must be the same as the server 
and IP Address is either 127.0.0.1 (playing locally) or the address of the computer where Server is running (playing remotely)
3. You will be prompted to bet an amount out of 2000 (starting money). To play, write a number on the command line and hit enter
4. You will be dealt two cards and asked if you want to hit (ask for another one) or stand (don't ask for more). 
If you want to hit, write 0 and hit enter. If you do not, write 1 and hit enter. 
5. If you hit, you will be shown the card dealt and asked again to hit or stand. If you stand, you will be shown the final results
6. After the final results, you will be prompted to play again. If you want to do so, write 1 and hit enter. If not, write 0 and hit enter.  

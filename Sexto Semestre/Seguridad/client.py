import socket
s=socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.connect(("10.0.0.1", 1100))
data=s.send(b'hola')
s.close()

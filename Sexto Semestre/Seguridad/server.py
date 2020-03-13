from Crypto.Cipher import AES, DES, PKCS1_OAEP
from Crypto.PublicKey import RSA
import socket
import time
keyDES = b'12345678'
keyAES = b'1234567812345678'

f = open("private.pem", "rb")

PrivadaRSA = f.read()
privada = RSA.import_key(PrivadaRSA)
f.close()

s = socket.socket(socket.AF_INET, socket.SOCK_STREAM)
s.bind(('10.0.10.2', 3200))
s.listen(1)
connection, address = s.accept()

a = connection.recv(1024)
# print(a.decode("ascii"))

############### DES #####################


#des_cipher = DES.new(keyDES, DES.MODE_CBC, iv=b'12345678')

#plain = des_cipher.decrypt(a)

############### AES #####################

#aes_cipher = AES.new(keyAES, AES.MODE_CBC, iv=b'1234567812345678')

#plain = aes_cipher.decrypt(a)

############### RSA #####################
ini_time = time.clock()

cipher = PKCS1_OAEP.new(privada)
plain = cipher.decrypt(a)

end_time = time.clock()

tot_time = end_time-ini_time
print("Tiempo de decripción"+tot_time)

print(plain.decode('ascii'))
connection.close()

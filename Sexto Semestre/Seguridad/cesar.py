
def cesar(mensaje, letra):
    nuevoMensaje = ""
    for x in mensaje:
        Nletra = chr((ord(x)-ord(letra)) % 27 + 61)
        nuevoMensaje = nuevoMensaje+Nletra

    return nuevoMensaje
    pass


if __name__ == "__main__":
    mensaje = "Roa es cagado"
    letra = "f"
    nuevoMen = ""
    nuevoMen = cesar(mensaje, letra)
    print(nuevoMen)
    pass

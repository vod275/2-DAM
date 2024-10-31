from pathlib import Path


guia = Path("Recursos")


contador_txt = 0


for txt in guia.glob("**/*.txt"):
    print(f"Archivo encontrado: {txt}")
    contador_txt += 1

print(f"Cantidad de archivos .txt en '{guia}': {contador_txt}")

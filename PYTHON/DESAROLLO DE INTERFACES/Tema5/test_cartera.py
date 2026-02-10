
import pytest
from cartera import Cartera



def test_saldo_inicial_por_defecto():
    #El inicial es 0
    mi_cartera = Cartera()
    assert mi_cartera.saldo == 0


def test_tipo_incorrecto_en_constructor():
    #El saldo se queda en 0
    mi_cartera = Cartera("texto")
    assert mi_cartera.saldo == 0


def test_saldo_negativo_en_constructor():
    #El saldo se pone en 0 en negativo"
    mi_cartera = Cartera(-50)
    assert mi_cartera.saldo == 0
    


def test_saldo_inicial_valido():
    #El saldo se asigna correctamente
    mi_cartera = Cartera(100)
    assert mi_cartera.saldo == 100



def test_ingresar_dinero_correctamente():
   #Ingresar dinero suma correctamente y devuelve el nuevo saldo
    mi_cartera = Cartera(50)
    nuevo_saldo = mi_cartera.ingresar(30)
    
    assert nuevo_saldo == 80
    assert mi_cartera.saldo == 80


def test_ingresar_cantidad_no_valida():
    #Comprueba que ingresar una cantidad no válida devuelve None y no cambia el saldo
    mi_cartera = Cartera(50)
    
    resultado = mi_cartera.ingresar("20")
    assert resultado is None
    assert mi_cartera.saldo == 50
    
    resultado = mi_cartera.ingresar(-10)
    assert resultado is None
    assert mi_cartera.saldo == 50



def test_gastar_dinero_correctamente():
    #Comprueba que gastar dinero resta correctamente y devuelve el nuevo saldo
    mi_cartera = Cartera(100)
    nuevo_saldo = mi_cartera.gastar(30)
    
    assert nuevo_saldo == 70
    assert mi_cartera.saldo == 70


def test_gastar_mas_del_saldo_disponible():
    #Comprueba que gastar más dinero del disponible devuelve None y no cambia el saldo
    mi_cartera = Cartera(50)
    resultado = mi_cartera.gastar(100)
    
    assert resultado is None
    assert mi_cartera.saldo == 50
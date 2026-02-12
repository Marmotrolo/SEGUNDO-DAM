import pytest
from factorial import factorial

def test_factorial_cero():
    assert factorial(0)==1


def test_factorial_uno():
    assert factorial(1)==1

def test_factorial_5():
    assert factorial(5)==120

def test_factorial_no_entero():
    with pytest.raises(TypeError):
        factorial(2.5)
        
def test_factorial_negativo():
    with pytest.raises(ValueError):
        factorial(-1)
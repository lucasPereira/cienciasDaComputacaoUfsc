module Hiperbolicas(
	Hiperbole(CosenoHiperbolico, SenoHiperbolico, TangHiperbolico, CotangenteHiperbolico),
	calcular, 
	epsilon
) where

data Hiperbole = CosenoHiperbolico Float 
	| SenoHiperbolico Float
	| TangHiperbolico Float
	| CotangenteHiperbolico Float
	deriving Show

epsilon = 2.718281828

calcular :: Hiperbole -> Float
calcular(CosenoHiperbolico x) = (epsilon**(2*x)+1)/(2*(epsilon**x))
calcular(SenoHiperbolico x) = (epsilon**(2*x)-1)/(2*(epsilon**x))
calcular(TangHiperbolico x) = (calcular(SenoHiper x))/(calcular(CosenoHiper x))
calcular(CotangenteHiperbolico x) = (calcular(CosenoHiper x))/(calcular(SenoHiper x))


module Resistores(resistor) where

x // y = do
	a <- x
	b <- y
	if b == 0 then Nothing else Just(a/b)

soma x y = do
	x' <- x
	y' <- y
	return (x'+y')

resistor x y = let
	um = return 1
	rx = return x
	ry = return y
	in um//(soma(um//rx) (um//ry))

